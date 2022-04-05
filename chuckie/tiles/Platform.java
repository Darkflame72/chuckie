// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.tiles;

/**
 * Represents a section of <i>platform</i> on which other objects in the game
 * can rest (such as the player, the hens, the eggs, etc).
 *
 * @author David J. Pearce
 *
 */
public class Platform implements Tile {
	@Override
	public String toString() {
		return "=";
	}

	@Override
	public boolean providesSupport() {
		return true;
	}

	@Override
	public boolean isObstruction() {
		return true;
	}
}
