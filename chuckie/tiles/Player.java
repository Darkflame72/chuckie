// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.tiles;

/**
 * Represents the player on the board. This includes, for example, any
 * information about the player (such as whether they are currently on a ladder
 * or not).
 *
 * @author David J. Pearce
 *
 */
public class Player implements Tile {

	private boolean onLadder = false;

	public boolean isOnLadder() {
		return onLadder;
	}

	public void setOnLadder(boolean onLadder) {
		this.onLadder = onLadder;
	}

	@Override
	public String toString() {
		if (onLadder) {
			return "@";
		} else {
			return "O";
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
}
