// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.util;

import chuckie.events.PlayerMove.Direction;

/**
 * Represents an (x,y) position on the game board.
 *
 * @author David J. Pearce
 *
 */
public final class Position {

	private final int x;
	private final int y;

	/**
	 * Construct a position on the board
	 *
	 * @param x X component
	 * @param y Y component
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Calculate a relative position after moving a number of steps in a given
	 * direction from a starting point.
	 *
	 * @param direction
	 *            --- Direction to move in
	 * @return New position in given direction
	 */
	public Position move(Direction direction) {
		int x = this.x;
		int y = this.y;
		switch (direction) {
		case UP:
			y += 1;
			break;
		case DOWN:
			y -= 1;
			break;
		case RIGHT:
			x += 1;
			break;
		case LEFT:
			x -= 1;
			break;
		}
		return new Position(x,y);
	}

	/**
	 * Get the X-coordinate of this position.
	 *
	 * @return X-coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the Y-coordinate of this position.
	 *
	 * @return Y-coordinate
	 */
	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Position other = (Position) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
