// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.tiles;

/**
 * Represents an arbitrary piece on the board. This includes the player, as well
 * as platforms, hens, eggs, etc.
 *
 * @author David J. Pearce
 *
 */
public interface Tile {
	/**
	 * Check whether this tile provides support against the action of gravity. That
	 * is, whether or not when applying gravity to the character, this tile can
	 * prevent the character from falling. For example, platforms provide support.
	 *
	 * @return True if this tile does provide support.
	 */
	public boolean providesSupport();

	/**
	 * Check whether this tile is an obstruction which prevents the character from
	 * moving. For example, platforms prevent the character from moving.
	 *
	 * @return True if this tile does obstruct movement.
	 */
	public boolean isObstruction();
}
