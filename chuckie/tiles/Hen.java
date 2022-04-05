// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.tiles;

import chuckie.Game;
import chuckie.events.PlayerMove.Direction;
import chuckie.util.Position;
import static chuckie.tiles.Air.AIR;

/**
 * Represents an egg on the board.
 *
 * @author David J. Pearce
 *
 */
public class Hen implements Tile {

	@Override
	public String toString() {
		if (goingLeft) {
			return "p";
		} else {
			return "q";
		}
	}

	@Override
	public boolean providesSupport() {
		return false;
	}

	@Override
	public boolean isObstruction() {
		return false;
	}

	private boolean goingLeft = true;

	/**
	 * Move the hen in the given direction.
	 */
	public void changeDirection() {
		goingLeft = !goingLeft;
	}

	/**
	 * Move the player in the given direction.
	 *
	 * @param direction The direction in which the player is moving.
	 * @param game      The game in which the player is moving.
	 * @return The new position of the player.
	 */
	public boolean apply(Game game, Position pp) {
		Position np = pp.move(goingLeft ? Direction.RIGHT : Direction.LEFT);
		Hen ht = (Hen) game.getTile(pp);
		Tile tt = game.getTile(np);
		// Only move left or right if not obstructed
		if ((tt instanceof Air || tt instanceof Player) && checkBelow(game, np)) {
			game.setTile(pp, AIR);
			game.setTile(np, ht);
		} else {
			// change direction
			goingLeft = !goingLeft;
		}
		return false;
	}

	/**
	 * Check whether the tile below the given position is air.
	 * 
	 * @param game The game to check.
	 * @param pp   The position to check.
	 * @return True if the tile below the given position is air.
	 */
	private boolean checkBelow(Game game, Position pp) {
		Position np = pp.move(Direction.DOWN);
		Tile tt = game.getTile(np);
		if (tt instanceof Air) {
			return false;
		}
		return true;
	}
}
