// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.events;

import chuckie.Game;
import chuckie.io.GameError;
import chuckie.tiles.Hen;
import chuckie.tiles.Ladder;
import chuckie.tiles.Player;
import chuckie.tiles.Tile;
import static chuckie.tiles.Air.AIR;
import chuckie.util.Position;

/**
 * Represents a directional move of the player within a given input sequence.
 *
 * @author David J. Pearce
 *
 */
public class PlayerMove implements Event {
	/**
	 * Represents one of the four directions in which the snake can move (Up, Down,
	 * Left and Right).
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}

	/**
	 * Indicates the direction in which the player moves.
	 */
	private final Direction direction;

	/**
	 * Construct a new player move object for a given direction.
	 *
	 * @param direction Indicates which direction the player is moving
	 */
	public PlayerMove(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void apply(Game game) {
		// Find player's position on the board.
		Position pp = findPlayer(game);
		// Calculate player's new position
		Position np = pp.move(direction);
		// Get the players tile
		Player pt = (Player) game.getTile(pp);
		// Check whether moving left or right
		if (direction == Direction.LEFT || direction == Direction.RIGHT
				|| (pt.isOnLadder() && (direction == Direction.UP || direction == Direction.DOWN))) {
			// check obstructions
			// Get tile at target position
			Tile tt = game.getTile(np);

			// not move into hen
			if (tt instanceof Hen) {
				return;
			}
			// Only move left or right if not obstructed
			if (!tt.isObstruction()) {
				if (pt.isOnLadder()) {
					game.setTile(pp, new Ladder());
				} else {
					game.setTile(pp, AIR);
				}
				if (tt instanceof Ladder) {
					pt.setOnLadder(true);
				} else {
					pt.setOnLadder(false);
				}
				game.setTile(np, pt);
			}
		}
	}

	/**
	 * Find the position where the player is currently located.
	 *
	 * @param game The game board in which to find the player.
	 * @return Position of player tile on board
	 */
	public static Position findPlayer(Game game) {
		// Find all sections
		for (int x = 0; x < game.getWidth(); ++x) {
			for (int y = 0; y < game.getHeight(); ++y) {
				Position p = new Position(x, y);
				// Extract tile at x,y position
				Tile t = game.getTile(p);
				// Check whether is part of snake
				if (t instanceof Player) {
					return p;
				}
			}
		}
		throw new IllegalArgumentException("Player not located on the board!");
	}
}
