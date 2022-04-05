// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie;

import chuckie.events.Event;
import chuckie.events.GameOver;
import chuckie.events.PlayerMove;
import chuckie.events.PlayerMove.Direction;
import chuckie.io.GameError;

import static chuckie.tiles.Air.AIR;

import java.util.ArrayList;

import chuckie.tiles.*;
import chuckie.util.Position;

/**
 * Represents the state of a game of Chuckie Egg. In particular, the game holds
 * the position of each piece on the board and the list of events.
 *
 * @author David J. Pearce
 *
 */
public class Game {

	/**
	 * Stores the width of the board.
	 */
	private int width;

	/**
	 * Stores the height of the board.
	 */
	private int height;

	/**
	 * A 2-dimensional array representing the board itself.
	 */
	private Tile[][] board;

	/**
	 * The array of event which make up this game.
	 */
	private Event[] events;

	/**
	 * Construct a game of Chuckie Egg
	 *
	 * @param width  Width of the board (in cells)
	 * @param height Height of the board (in cells)
	 *
	 * @param events --- The events that make up the game
	 */
	public Game(int width, int height, Event[] events) {
		this.events = events;
		this.width = width;
		this.height = height;
		board = new Tile[height][width];
	}

	/**
	 * Get the height of the game board.
	 *
	 * @return Board height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the width of the game board.
	 * 
	 * @return Board width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Run this game to produce the final board, whilst also checking each move
	 * against the rules of Chuckie Egg.
	 */
	public void run() {
		for (int i = 0; i != events.length; ++i) {
			Event move = events[i];
			// Check if there is a move and there is still eggs
			// Check if the player has fallen off the board
			if (move instanceof PlayerMove && !findEgg()) {
				throw new GameError("Player hasn't collected all the eggs!");
			} else if (move instanceof PlayerMove && findPlayer() == null) {
				throw new GameError("Player is still on the board!");
			} else {
				move.apply(this);

				// Make sure game is not over
				if (move instanceof GameOver) {
					break;
				}
				// Apply post moves
				applyGravity();
				moveHens();
			}
		}
	}

	/**
	 * check if any eggs are on the board.
	 * 
	 * @return
	 */
	private boolean findEgg() {
		for (int y = 0; y != height; ++y) {
			for (int x = 0; x != width; ++x) {
				Tile t = board[y][x];
				if (t instanceof Egg) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * Get the tile at a given position on the board. If the position is outside the
	 * board dimensions, it just returns empty air.
	 *
	 * @param position Board position to get tile from
	 * @return Tile at given position
	 */
	public Tile getTile(Position position) {
		final int x = position.getX();
		final int y = position.getY();
		if (x < 0 || x >= width) {
			return AIR;
		} else if (y < 0 || y >= height) {
			return AIR;
		} else {
			return board[position.getY()][position.getX()];
		}
	}

	/**
	 * Set the tile at a given position on the board. Note, this will overwrite the
	 * record of any other tile being at that position.
	 *
	 * @param position Board position to place piece on
	 * @param tile     The tile to put at the given position.
	 */
	public void setTile(Position position, Tile tile) {
		final int x = position.getX();
		final int y = position.getY();
		if (x < 0 || x >= width) {
			return;
		} else if (y < 0 || y >= height) {
			return;
		} else {
			board[position.getY()][position.getX()] = tile;
		}
	}

	/**
	 * Locate a given tile on the board.
	 *
	 * @param tile Tile to be located
	 * @return Position containing tile
	 */
	public Position locateTile(Tile tile) {
		for (int y = 0; y != height; ++y) {
			for (int x = 0; x != width; ++x) {
				if (board[y][x] == tile) {
					return new Position(x, y);
				}
			}
		}
		throw new IllegalArgumentException("Tile not located on board!");
	}

	private void moveHens() {
		// iterate through all tiles
		ArrayList<Hen> hens = new ArrayList<Hen>();
		ArrayList<Position> positions = new ArrayList<Position>();
		for (int y = 0; y != height; ++y) {
			for (int x = 0; x != width; ++x) {
				Tile t = board[y][x];
				if (t instanceof Hen) {
					// move hen
					hens.add((Hen) t);
					positions.add(new Position(x, y));
				}
			}
		}
		for (int i = 0; i < hens.size(); i++) {
			Hen hen = hens.get(i);
			Position pos = positions.get(i);
			hen.apply(this, pos);
		}
	}

	/**
	 * Apply gravity to the player, meaning that it moves down until such time as
	 * either leaves the board entirely or is stopped by some obstruction.
	 */
	private void applyGravity() {
		// NOTE: to implement this method, we need to find the player. Then we need to
		// decide if the player is supported. Finally, if the player is not supported,
		// then we need to move it down. At this point, we repeat the process until the
		// player is supported or has fallen off the board.
		while (true) {
			Position pp = findPlayer();
			if (pp == null) {
				break;
			}
			if (!findEgg()) {
				break;
			}

			// new position
			Position np = pp.move(Direction.DOWN);
			Player pt = (Player) getTile(pp);
			if (pt.isOnLadder()) {
				break;
			}
			Tile tt = getTile(np);

			if (!tt.isObstruction() && !tt.providesSupport()) {
				if (pt.isOnLadder()) {
					setTile(pp, new Ladder());
				} else {
					setTile(pp, AIR);
				}
				if (tt instanceof Ladder) {
					pt.setOnLadder(true);
				} else {
					pt.setOnLadder(false);
				}
				setTile(np, pt);
			} else {
				break;
			}
		}
	}

	/**
	 * Find the player on the board.
	 *
	 * @return Position of the player
	 */
	public Position findPlayer() {
		// Find all sections
		for (int x = 0; x < getWidth(); ++x) {
			for (int y = 0; y < getHeight(); ++y) {
				Position p = new Position(x, y);
				// Extract tile at x,y position
				Tile t = getTile(p);
				// Check whether is part of snake
				if (t instanceof Player) {
					return p;
				}
			}
		}
		// throw new IllegalArgumentException("Player not located on the board!");
		return null;
	}

	/**
	 * Provide a human-readable view of the current game board. This is
	 * particularly useful to look at when debugging your code!
	 */
	@Override
	public String toString() {
		String r = "";
		for (int i = height - 1; i >= 0; --i) {
			r += (i % 10) + "|";
			for (int j = 0; j != width; ++j) {
				Tile p = board[i][j];
				r += p.toString();
			}
			r += "|\n";
		}
		r += "  ";
		// Do the X-Axis
		for (int j = 0; j != width; ++j) {
			r += (j % 10);
		}
		return r;
	}

	/**
	 * Initialse the board from a given input board. This includes the placement of
	 * all terrain and pieces.
	 *
	 * @param boardString String representing board.
	 */
	public void initialiseBoard(String boardString) {
		// You don't need to understand this!
		String[] rows = boardString.split("\n");
		for (int y = 0; y != height; ++y) {
			String row = rows[y];
			for (int x = 0; x != width; ++x) {
				char c = row.charAt(x + 2);
				board[height - (y + 1)][x] = createPieceFromChar(c);
			}
		}
	}

	/**
	 * Create a piece from a given character.
	 *
	 * @param c Character to be converted
	 * @return Piece corresponding to character
	 */
	private Tile createPieceFromChar(char c) {
		switch (c) {
			case ' ':
				return AIR; // blank space
			case 'O':
				return new Player();
			case '@':
				Player p = new Player();
				p.setOnLadder(true);
				return p;
			case '=':
				return new Platform();
			case '*':
				return new Egg();
			case 'p':
				return new Hen();
			case 'q':
				Hen h = new Hen();
				h.changeDirection();
				return h;
			case '#':
				return new Ladder();
		}
		throw new IllegalArgumentException("invalid character");
	}
}
