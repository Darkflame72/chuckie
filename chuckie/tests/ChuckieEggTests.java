// This program is copyright VUW.  You are granted permission to use it to
// construct your answer to a SWEN221 assignment. You may not distribute
// it in any other way without permission.
package chuckie.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chuckie.Game;
import chuckie.io.*;

public class ChuckieEggTests {

	/**
	 * ============================================================
	 * Part 1 --- Basic Moves
	 * ============================================================
	 */

	@Test
	public void test_01() {
		// Check player can move right
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|      O  *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_02() {
		// Check player can move left
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    O    *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_03() {
		// Check player cannot move up
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "U";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_04() {
		// Check player cannot move down
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "D";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_05() {
		// Check player can move right twice
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       O *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_06() {
		// Check player can move left twice
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       O *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_07() {
		// Check player can move up twice
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "UU";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_08() {
		// Check player can move down twice
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       O *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "DD";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       O *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_09() {
		// Check longer move sequence
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       O *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LLRRULD";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|      O  *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_10() {
		// Check longer move sequence
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|        O      |\n" +
				"4|    =====      |\n" +
				"3|               |\n" +
				"2|         *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LLLLRRRR";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|        O      |\n" +
				"4|    =====      |\n" +
				"3|               |\n" +
				"2|         *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	/**
	 * ============================================================
	 * Part 2 --- Obstructions
	 * ============================================================
	 */

	@Test
	public void test_11() {
		// Check player cannot move right (obstruction)
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|         *     |\n" +
				"2|     O=        |\n" +
				"1|    ==         |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|         *     |\n" +
				"2|     O=        |\n" +
				"1|    ==         |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_12() {
		// Check player cannot move right (obstruction)
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|         *     |\n" +
				"2|    O ====     |\n" +
				"1|    ==         |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|         *     |\n" +
				"2|     O====     |\n" +
				"1|    ==         |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_13() {
		// Check player cannot move left (obstruction)
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|    *          |\n" +
				"2|    ==O        |\n" +
				"1|      ===      |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|    *          |\n" +
				"2|    ==O        |\n" +
				"1|      ===      |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_14() {
		// Check player cannot move left (obstruction)
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|    *          |\n" +
				"2|    == O       |\n" +
				"1|      ===      |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|    *          |\n" +
				"2|    ==O        |\n" +
				"1|      ===      |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_15() {
		// Check player cannot move left (obstruction)
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|    *          |\n" +
				"2|    ==  O      |\n" +
				"1|    =======      |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LLLL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|    *          |\n" +
				"2|    ==O        |\n" +
				"1|    =======    |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_16() {
		// Check player not obstructed by egg (left)
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    *O  *      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    O   *      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_17() {
		// Check player not obstructed by egg (left)
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    * O *      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    O   *      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_18() {
		// Check player not obstructed by egg (right)
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    *  O*      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    *   O      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_19() {
		// Check player not obstructed by egg (right)
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    * O *      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    *   O      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_20() {
		// Check longer move sequence
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|   =*  O *=    |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RRRL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|   =*   O =    |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	/**
	 * ============================================================
	 * Part 3 --- Victory
	 * ============================================================
	 */

	@Test
	public void test_21() {
		// Check player wins by collecting last egg
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O *       |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR!";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|       O       |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_22() {
		// Check player wins by collecting last egg
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     O **      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RRR!";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|        O      |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_23() {
		// Check player wins by collecting last egg
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    *****O==   |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LLLLL!";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    O     ==   |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_24() {
		// Check invalid game (won) if player doesn't collect all eggs
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|     * O  ==   |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "L!";

		checkInvalid(sequence, startingBoard);
	}

	@Test
	public void test_25() {
		// Check invalid game (won) if player doesn't collect all eggs
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|    ** O  ==   |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL!";

		checkInvalid(sequence, startingBoard);
	}

	@Test
	public void test_26() {
		// Check invalid game (won) if player doesn't collect all eggs
		String startingBoard = "7|               |\n" +
				"6|   *           |\n" +
				"5|  ==           |\n" +
				"4|               |\n" +
				"3|      O*       |\n" +
				"2|    ======     |\n" +
				"1|               |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R!";

		checkInvalid(sequence, startingBoard);
	}

	@Test
	public void test_27() {
		// Check invalid game (lost) if player still alive
		String startingBoard = "7|               |\n" +
				"6|   *           |\n" +
				"5|  ==           |\n" +
				"4|               |\n" +
				"3|      O*       |\n" +
				"2|    ======     |\n" +
				"1|               |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R?";

		checkInvalid(sequence, startingBoard);
	}

	@Test
	public void test_28() {
		// Check invalid game (lost) if player still alive
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|  ==           |\n" +
				"4|               |\n" +
				"3|    O***       |\n" +
				"2|    ======     |\n" +
				"1|               |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RRR?";

		checkInvalid(sequence, startingBoard);
	}

	@Test
	public void test_29() {
		// Check invalid game if player continues after collecting all eggs
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|  ==           |\n" +
				"4|               |\n" +
				"3|     *O        |\n" +
				"2|    ======     |\n" +
				"1|               |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		checkInvalid(sequence, startingBoard);
	}

	@Test
	public void test_30() {
		// Check invalid game if player continues after collecting all eggs
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|  ==           |\n" +
				"4|               |\n" +
				"3|    O***       |\n" +
				"2|    ======     |\n" +
				"1|               |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RRRR";

		checkInvalid(sequence, startingBoard);
	}

	/**
	 * ============================================================
	 * Part 4 --- Gravity
	 * ============================================================
	 */

	@Test
	public void test_31() {
		// Check player falls
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|   O           |\n" +
				"2|  ==     *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|               |\n" +
				"3|               |\n" +
				"2|  ==O    *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_32() {
		// Check player falls further
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|   O           |\n" +
				"4|  ==           |\n" +
				"3|               |\n" +
				"2|         *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|  ==           |\n" +
				"3|               |\n" +
				"2|    O    *     |\n" +
				"1|    ======     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_33() {
		// Check player falls
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|   O           |\n" +
				"4|  ==           |\n" +
				"3|               |\n" +
				"2|    =    *     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|  ==           |\n" +
				"3|    O          |\n" +
				"2|    =    *     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_34() {
		// Check player falls multiple times
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|   O           |\n" +
				"4|  ==           |\n" +
				"3|               |\n" +
				"2|    =    *     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|  ==           |\n" +
				"3|               |\n" +
				"2|    =O   *     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_35() {
		// Check player takes egg whilst falling
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O       |\n" +
				"4|      ==       |\n" +
				"3|               |\n" +
				"2|     *   *     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|      ==       |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_36() {
		// Check player takes egg whilst falling
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O       |\n" +
				"4|      ==       |\n" +
				"3|     *         |\n" +
				"2|         *     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|      ==       |\n" +
				"3|               |\n" +
				"2|     O   *     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_37() {
		// Check player takes egg whilst falling and wins
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O       |\n" +
				"4|      ==       |\n" +
				"3|     *         |\n" +
				"2|               |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL!";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|      ==       |\n" +
				"3|     O         |\n" +
				"2|               |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_38() {
		// Check player takes egg whilst falling and wins
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O       |\n" +
				"4|      ==       |\n" +
				"3|     *         |\n" +
				"2|     *         |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LL!";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|      ==       |\n" +
				"3|               |\n" +
				"2|     O         |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_39() {
		// Check player loses by falling off board
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O       |\n" +
				"4|     ===       |\n" +
				"3|               |\n" +
				"2|     *         |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LLL?";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|               |\n" +
				"4|     ===       |\n" +
				"3|               |\n" +
				"2|     *         |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_40() {
		// Check player should lose by falling off board
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O       |\n" +
				"4|     ===       |\n" +
				"3|               |\n" +
				"2|     *         |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LLLL";

		checkInvalid(sequence, startingBoard);
	}

	/**
	 * ============================================================
	 * Part 5 --- Ladders
	 * ============================================================
	 */

	@Test
	public void test_41() {
		// Check player moves in front of ladder
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O#      |\n" +
				"4|     ===#      |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "R";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|        @      |\n" +
				"4|     ===#      |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_42() {
		// Check player moves in front of ladder and out again
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O#      |\n" +
				"4|     ===#==     |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|        #O     |\n" +
				"4|     ===#==    |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_43() {
		// Check player moves in front of ladder and out again
		String startingBoard = "7|         #     |\n" +
				"6|         #==   |\n" +
				"5|       O##     |\n" +
				"4|     ===#==    |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RR";

		String finalBoard = "7|         #     |\n" +
				"6|         #==   |\n" +
				"5|        #@     |\n" +
				"4|     ===#==    |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_44() {
		// Check player moves in front of ladder and out again
		String startingBoard = "7|         #     |\n" +
				"6|         #==   |\n" +
				"5|       O##     |\n" +
				"4|     ===#==    |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard = "7|         #     |\n" +
				"6|         #==   |\n" +
				"5|        ##O    |\n" +
				"4|     ===#==    |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_45() {
		// Check player can go down ladder
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O#      |\n" +
				"4|     ===#      |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "RD";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|        #      |\n" +
				"4|     ===@      |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_46() {
		// Check player can go up ladder
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|        #      |\n" +
				"4|     ===#      |\n" +
				"3|        #      |\n" +
				"2|     *  #O     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LUU";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|        #      |\n" +
				"4|     ===@      |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_47() {
		// Check player can go up ladder and get off
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|        #      |\n" +
				"4|     ===#      |\n" +
				"3|        #      |\n" +
				"2|     *  #O     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LUUUL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|       O#      |\n" +
				"4|     ===#      |\n" +
				"3|        #      |\n" +
				"2|     *  #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_48() {
		// Check player can traverse multiple ladders
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|      # #      |\n" +
				"4|     =#=#      |\n" +
				"3|      # #      |\n" +
				"2|     *# #O     |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		String sequence = "LUUULLDD";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|      # #      |\n" +
				"4|     =#=#      |\n" +
				"3|      @ #      |\n" +
				"2|     *# #      |\n" +
				"1|     =====     |\n" +
				"0|               |\n" +
				"  012345678901234";

		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_49() {
		// Check player can "fall off" ladder
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|      #  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|     *         |\n" +
				"1|               |\n" +
				"0|     ===       |\n" +
				"  012345678901234";

		String sequence = "LLLDDD";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|      #        |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|     *         |\n" +
				"1|      O        |\n" +
				"0|     ===       |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_50() {
		// Check player can "fall off" ladder
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|      #  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|     *#        |\n" +
				"1|      #        |\n" +
				"0|     ===       |\n" +
				"  012345678901234";

		String sequence = "LLLDDR";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|      #        |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|     *#        |\n" +
				"1|      #O       |\n" +
				"0|     ===       |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_51() {
		// Check player can "fall off" ladder and win
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|      #  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|               |\n" +
				"1|      *        |\n" +
				"0|     ===       |\n" +
				"  012345678901234";

		String sequence = "LLLDDD!";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|      #        |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|               |\n" +
				"1|      O        |\n" +
				"0|     ===       |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_52() {
		// Check player can start on ladder
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#        |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|      @        |\n" +
				"0|     ===       |\n" +
				"  012345678901234";

		String sequence = "UUUUR";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#O       |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|      #        |\n" +
				"0|     ===       |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	/**
	 * ============================================================
	 * Part 6 --- Hens
	 * ============================================================
	 */

	@Test
	public void test_53() {
		// Check hen moves right
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1| p    #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|  p   #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_54() {
		// Check hen moves right
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1| p    #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";

		String sequence = "LL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *# O      |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|   p  #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_55() {
		// Check hen moves left
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|   q  #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";

		String sequence = "L";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|  q   #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_56() {
		// Check hen moves left
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|   q  #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";

		String sequence = "LU";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1| q    #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_57() {
		// Check hen turns around
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|   q  #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";

		String sequence = "LUL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *# O      |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1| p    #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_58() {
		// Check hen turns around and continues
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|   q  #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";

		String sequence = "LULL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#O       |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|  p   #        |\n" +
				"0| ======        |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_59() {
		// Check hen turns around
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|=  q  #        |\n" +
				"0|=======        |\n" +
				"  012345678901234";

		String sequence = "LUL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *# O      |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|=p    #        |\n" +
				"0|=======        |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_60() {
		// Check hen turns around and continues
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|=  q  #        |\n" +
				"0|=======        |\n" +
				"  012345678901234";

		String sequence = "LULL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#O       |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|= p   #        |\n" +
				"0|=======        |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_61() {
		// Check hen obstructed by ladder
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|    p #        |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "LUUU";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|   q  #        |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_62() {
		// Check hen goes obstructed by ladder
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|      # q      |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "LU";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|      #p       |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_63() {
		// Check hen obstructed by egg
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1| p *  #        |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "LU";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1|  q*  #        |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_64() {
		// Check hen goes obstructed by egg
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#   O    |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1| * q  #        |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "LU";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *#  O     |\n" +
				"4|     =#====    |\n" +
				"3|      #        |\n" +
				"2|      #   ===  |\n" +
				"1| *p   #        |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_65() {
		// Check hen collision ends game
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *         |\n" +
				"4|     ======    |\n" +
				"3|               |\n" +
				"2|          ===  |\n" +
				"1|   p   O       |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "LUU?";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *         |\n" +
				"4|     ======    |\n" +
				"3|               |\n" +
				"2|          ===  |\n" +
				"1|      p        |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_66() {
		// Check cannot walk through hen
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *         |\n" +
				"4|     ======    |\n" +
				"3|               |\n" +
				"2|          ===  |\n" +
				"1|   p   O       |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "LL?";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *         |\n" +
				"4|     ======    |\n" +
				"3|               |\n" +
				"2|          ===  |\n" +
				"1|     p         |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_67() {
		// Check cannot walk through hen
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *         |\n" +
				"4|     ======    |\n" +
				"3|               |\n" +
				"2|          ===  |\n" +
				"1|    p  O       |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "LL?";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|     *         |\n" +
				"4|     ======    |\n" +
				"3|               |\n" +
				"2|          ===  |\n" +
				"1|      p        |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_68() {
		// Check hens cannot catch player
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|    #*         |\n" +
				"4|    #======    |\n" +
				"3|    #          |\n" +
				"2|    #======    |\n" +
				"1|       Oq      |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "LLL";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|    #*         |\n" +
				"4|    #======    |\n" +
				"3|    #          |\n" +
				"2|    #======    |\n" +
				"1|    Oq         |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_69() {
		// Check hens cannot catch player
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|    #*         |\n" +
				"4|    #======    |\n" +
				"3|    #          |\n" +
				"2|    #======    |\n" +
				"1| pO            |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "RRR";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|    #*         |\n" +
				"4|    #======    |\n" +
				"3|    #          |\n" +
				"2|    #======    |\n" +
				"1|    pO         |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	@Test
	public void test_70() {
		// Check multiple hens move
		String startingBoard = "7|               |\n" +
				"6|               |\n" +
				"5|    #*         |\n" +
				"4|    #======    |\n" +
				"3|    #O  q      |\n" +
				"2|    #======    |\n" +
				"1| p  #          |\n" +
				"0| ========      |\n" +
				"  012345678901234";

		String sequence = "LUUR!";

		String finalBoard = "7|               |\n" +
				"6|               |\n" +
				"5|    #O         |\n" +
				"4|    #======    |\n" +
				"3|    #p         |\n" +
				"2|    #======    |\n" +
				"1|  q #          |\n" +
				"0| ========      |\n" +
				"  012345678901234";
		checkValid(sequence, startingBoard, finalBoard);
	}

	/**
	 * ============================================================
	 * Helper Functions
	 * ============================================================
	 */

	/**
	 * This method checks whether or not the given input string is valid.
	 *
	 * ** DO NOT MODIFY THIS FUNCTION **
	 *
	 * @param sequence
	 */
	public void checkValid(String sequence, String startingBoard, String expectedFinalBoard) {
		Game game;
		System.out
				.println("===================================================");
		System.out.println("TEST " + determineTestNumber());
		System.out
				.println("===================================================");
		// Boards set to 15x8 dimension
		game = new Parser(sequence).parse(15, 8);
		game.initialiseBoard(startingBoard);
		game.run();
		// Second, create the board and apply each move to the board.
		String finalBoard = game.toString();
		if (!finalBoard.equals(expectedFinalBoard)) {
			System.out.println("EXPECTED:");
			System.out.println(expectedFinalBoard);
			System.out.println("ACTUAL:");
			System.out.println(finalBoard);
			// Using assertEquals enables result comparator in Eclipse
			assertEquals(expectedFinalBoard, finalBoard, "Invalid final board --- see the console for details");
		}
	}

	/**
	 * This method checks whether or not the given input string is invalid.
	 *
	 * ** DO NOT MODIFY THIS FUNCTION **
	 *
	 * @param sequence
	 */
	public void checkInvalid(String sequence, String startingBoard) {
		Game game;

		System.out
				.println("===================================================");
		System.out.println("TEST " + determineTestNumber());
		System.out
				.println("===================================================");

		// First, parse the list of moves
		try {
			// Boards set to 15x8 dimension
			game = new Parser(sequence).parse(15, 8);
			game.initialiseBoard(startingBoard);
			game.run();
			System.out.println("Test should have generated a GameError, but didn't");
			System.out.println("\nBOARD:");
			System.out.println(game.toString());
			fail("Test failed to throw a GameError (as expected)");
		} catch (GameError e) {
			// This is what we want to happen, since the input game is invalid.
			// Therefore, we simply exit the test correctly.
			return;
		}
	}

	/**
	 * Determine the number of the test being executed based on its method name.
	 *
	 * ** DO NOT MODIFY THIS FUNCTION **
	 *
	 * @return
	 */
	private int determineTestNumber() {
		StackTraceElement[] e = Thread.currentThread().getStackTrace();
		String line = e[3].toString();
		int numStart = line.indexOf('_') + 1;
		return Integer.valueOf(line.substring(numStart, numStart + 2));
	}
}
