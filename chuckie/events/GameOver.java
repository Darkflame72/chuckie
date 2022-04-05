// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.events;

import chuckie.Game;
import chuckie.io.GameError;
import chuckie.tiles.Egg;
import chuckie.tiles.Player;
import chuckie.tiles.Tile;
import chuckie.util.Position;

/**
 * Represents the end of the game as a result of either player winning or
 * losing. The player wins when all eggs are collected. Likewise, if the player
 * loses if they fall off the board or hits a hen.
 *
 * @author David J. Pearce
 *
 */
public class GameOver implements Event {
	/**
	 * Indicates whether the game was won (true) or lost (false).
	 */
	private final boolean won;

	/**
	 * Construct a new GameOver event which indicates whether or not the game was
	 * won.
	 *
	 * @param won This is true if the game was won, or false otherwise.
	 */
	public GameOver(boolean won) {
		this.won = won;
	}

	@Override
	public void apply(Game game) {
		// Look for an egg on the board
		boolean someEggs = findEgg(game);
		// Decide what happened
		if (won && someEggs) {
			throw new GameError("Player hasn't collected all the eggs!");
		}
		boolean player = findPlayer(game);
		if (!won && player) {
			throw new GameError("Player is still on the board!");
		}
	}

	/**
	 * Check whether or not one or more eggs remain on the board.
	 *
	 * @param game The current game.
	 * @return
	 */
	private static boolean findEgg(Game game) {
		// Search through board
		for (int y = 0; y != game.getHeight(); ++y) {
			for (int x = 0; x != game.getWidth(); ++x) {
				Tile t = game.getTile(new Position(x, y));
				// Check whether tile is egg or not
				if (t instanceof Egg) {
					return true;
				}
			}
		}
		//
		return false;
	}

	private static boolean findPlayer(Game game) {
		// Search through board
		for (int y = 0; y != game.getHeight(); ++y) {
			for (int x = 0; x != game.getWidth(); ++x) {
				Tile t = game.getTile(new Position(x, y));
				// Check whether tile is egg or not
				if (t instanceof Player) {
					return true;
				}
			}
		}
		//
		return false;
	}
}
