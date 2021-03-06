// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.tiles;

/**
 * Represents an egg on the board.
 *
 * @author David J. Pearce
 *
 */
public class Ladder implements Tile {

	public final static Ladder LADDER = new Ladder();

	@Override
	public String toString() {
		return "#";
	}

	@Override
	public boolean providesSupport() {
		return true;
	}

	@Override
	public boolean isObstruction() {
		return false;
	}
}
