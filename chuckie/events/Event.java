// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.events;

import chuckie.Game;

/**
 * Represents an event which occurs during the game, which is either moving a
 * player in some direction or game over.
 *
 * @author David J. Pearce
 *
 */
public interface Event {
	/**
	 * Apply this move to the board, whilst checking that it is valid.
	 *
	 * @param game --- game to validate this move against.
	 */
	public void apply(Game game);
}
