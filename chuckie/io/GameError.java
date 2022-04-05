// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.io;

/**
 * Indicates some problem with the structure or syntax of an input sequence.
 *
 * @author David J. Pearce
 *
 */
public class GameError extends Error {
	/**
	 * Create a new error with a given error message.
	 *
	 * @param msg Error message to report.
	 */
	public GameError(String msg) {
		super(msg);
	}
}
