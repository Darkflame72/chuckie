// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.io;

import java.util.*;

import chuckie.Game;
import chuckie.events.*;
import chuckie.events.PlayerMove.Direction;

/**
 * Responsible for parsing an input sequence of the game.
 *
 * @author David J. Pearce
 *
 */
public class Parser {
	private String text; // text to be processed
	private int index; // position into text

	/**
	 * Construct a new parser for a given input sequence expressed as a textual
	 * string.
	 *
	 * @param text The sequence of moves to be parsed.
	 */
	public Parser(String text) {
		this.text = text;
		this.index = 0;
	}

	/**
	 * Parse the input sequence assuming a given width and height to produce a new
	 * game object.
	 *
	 * @param width  Width of game board to use
	 * @param height Height of game board to use
	 * @return Game object representing the game
	 */
	public Game parse(int width, int height) {
		ArrayList<Event> events = new ArrayList<>();
		// Third, parse each move!
		while (index < text.length()) {
			events.add(parseEvent());
		}
		// Convert list of events into an array
		Event[] arrayOfMoves = events.toArray(new Event[events.size()]);
		// Create game
		return new Game(width, height, arrayOfMoves);
	}

	/**
	 * This method parses a given event in the game, and constructs an object of the
	 * appropriate type to represent it.
	 *
	 * @return Event which was parsed
	 * @throws GameError
	 */
	private Event parseEvent() {
		char moveCharacter = text.charAt(index++);
		switch (moveCharacter) {
			case '!':
				return new GameOver(true);
			case '?':
				return new GameOver(false);
			case 'U':
				return new PlayerMove(Direction.UP);
			case 'D':
				return new PlayerMove(Direction.DOWN);
			case 'L':
				return new PlayerMove(Direction.LEFT);
			case 'R':
				return new PlayerMove(Direction.RIGHT);
			default:
				syntaxError("unknown event character encountered");
				return null; // unreachable
		}
	}

	/**
	 * Print out useful debugging output, and throw a SyntaxError exception
	 *
	 * @param msg
	 */
	private void syntaxError(String msg) {
		ArrayList<String> lines = new ArrayList<>();
		int i = 0;
		int start = 0;
		int linenum = 0;
		int col = 0;
		while (i < text.length()) {
			if (text.charAt(i) == '\n') {
				String line = text.substring(start, i);
				lines.add(line);
				start = i + 1;
			}
			if (i == index) {
				linenum = lines.size();
				col = i - start;
			}
			i = i + 1;
		}
		// finally, process last line
		String line = text.substring(start, i);
		lines.add(line);
		System.err.println(msg);
		System.err.println(lines.get(linenum));
		for (i = 0; i < col; ++i) {
			System.err.print(" ");
		}
		System.err.println("^\n");
		throw new GameError(msg);
	}
}
