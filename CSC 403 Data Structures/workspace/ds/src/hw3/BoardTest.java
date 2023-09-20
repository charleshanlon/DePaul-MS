package hw3;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void test10Draw() {
		Board b = new Board();
		assertTrue(b.play(1));
		assertFalse(b.gameOver());
		assertTrue(b.play(2));
		assertFalse(b.gameOver());
		assertTrue(b.play(1));
		assertFalse(b.gameOver());
		assertTrue(b.play(2));
		assertFalse(b.gameOver());
		assertTrue(b.play(3));
		assertFalse(b.gameOver());
		assertTrue(b.play(4));
		assertFalse(b.gameOver());
		assertTrue(b.play(3));
		assertFalse(b.gameOver());
		assertTrue(b.play(4));
		assertFalse(b.gameOver());
		assertTrue(b.play(5));
		assertFalse(b.gameOver());
		assertTrue(b.play(6));
		assertFalse(b.gameOver());
		assertTrue(b.play(5));
		assertFalse(b.gameOver());
		assertTrue(b.play(6));
		assertFalse(b.gameOver());
		assertTrue(b.play(7));
		assertFalse(b.gameOver());
		assertTrue(b.play(1));
		assertFalse(b.gameOver());
		assertTrue(b.play(2));
		assertFalse(b.gameOver());
		assertTrue(b.play(1));
		assertFalse(b.gameOver());
		assertTrue(b.play(2));
		assertFalse(b.gameOver());
		assertTrue(b.play(3));
		assertFalse(b.gameOver());
		assertTrue(b.play(4));
		assertFalse(b.gameOver());
		assertTrue(b.play(3));
		assertFalse(b.gameOver());
		assertTrue(b.play(4));
		assertFalse(b.gameOver());
		assertTrue(b.play(5));
		assertFalse(b.gameOver());
		assertTrue(b.play(6));
		assertFalse(b.gameOver());
		assertTrue(b.play(5));
		assertFalse(b.gameOver());
		assertTrue(b.play(6));
		assertFalse(b.gameOver());
		assertTrue(b.play(7));
		assertFalse(b.gameOver());
		assertTrue(b.play(1));
		assertFalse(b.gameOver());
		assertTrue(b.play(2));
		assertFalse(b.gameOver());
		assertTrue(b.play(1));
		assertFalse(b.gameOver());
		assertTrue(b.play(2));
		assertFalse(b.gameOver());
		assertTrue(b.play(3));
		assertFalse(b.gameOver());
		assertTrue(b.play(4));
		assertFalse(b.gameOver());
		assertTrue(b.play(3));
		assertFalse(b.gameOver());
		assertTrue(b.play(4));
		assertFalse(b.gameOver());
		assertTrue(b.play(5));
		assertFalse(b.gameOver());
		assertTrue(b.play(6));
		assertFalse(b.gameOver());
		assertTrue(b.play(5));
		assertFalse(b.gameOver());
		assertTrue(b.play(6));
		assertFalse(b.gameOver());
		assertTrue(b.play(7));
		assertFalse(b.gameOver());
		assertTrue(b.play(7));
		assertFalse(b.gameOver());
		assertTrue(b.play(7));
		assertFalse(b.gameOver());
		assertTrue(b.play(7));
		assertTrue(b.gameOver());
		assertEquals(' ', b.winner());
	}

	@Test
	public void test10HorizontalXWin() {
		Board b1 = new Board();
		Board b2 = new Board();
		Board b3 = new Board();

		// X wins along bottom row
		assertTrue(b1.play(1));
		assertTrue(b1.play(7));
		assertTrue(b1.play(7));
		assertTrue(b1.play(7));
		assertTrue(b1.play(2));
		assertTrue(b1.play(1));
		assertFalse(b1.gameOver());
		assertTrue(b1.play(4));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(5));
		assertTrue(b1.play(3));
		assertTrue(b1.gameOver());
		assertEquals('X', b1.winner());

		// X wins along top row
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(3));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertFalse(b2.gameOver());
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(7));
		assertTrue(b2.play(5));
		assertTrue(b2.play(5));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(4));
		assertTrue(b2.play(7));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertTrue(b2.gameOver());
		assertEquals('X', b2.winner());

		// X wins in a center row
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(4));
		assertTrue(b3.play(1));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertFalse(b3.gameOver());
		assertTrue(b3.play(5));
		assertTrue(b3.gameOver());
		assertEquals('X', b3.winner());
	}

	@Test
	public void test10HorizontalOWin() {
		Board b1 = new Board();
		Board b2 = new Board();
		Board b3 = new Board();

		// X wins along bottom row
		assertTrue(b1.play(6));
		assertTrue(b1.play(1));
		assertTrue(b1.play(7));
		assertTrue(b1.play(7));
		assertTrue(b1.play(7));
		assertTrue(b1.play(2));
		assertTrue(b1.play(1));
		assertTrue(b1.play(4));
		assertTrue(b1.play(6));
		assertFalse(b1.gameOver());
		assertTrue(b1.play(6));
		assertTrue(b1.play(5));
		assertTrue(b1.play(3));
		assertTrue(b1.gameOver());
		assertEquals('O', b1.winner());

		// O wins along top row
		assertTrue(b2.play(2));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(3));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(7));
		assertTrue(b2.play(5));
		assertTrue(b2.play(5));
		assertFalse(b2.gameOver());
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(4));
		assertTrue(b2.play(7));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertTrue(b2.gameOver());
		assertEquals('O', b2.winner());

		// O wins in a center row
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(4));
		assertTrue(b3.play(1));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertFalse(b3.gameOver());
		assertTrue(b3.play(5));
		assertTrue(b3.gameOver());
		assertEquals('O', b3.winner());
	}

	@Test
	public void test10VerticalXWin() {
		Board b1 = new Board();
		Board b2 = new Board();
		Board b3 = new Board();

		// X wins along left column
		assertTrue(b1.play(1));
		assertTrue(b1.play(2));
		assertTrue(b1.play(1));
		assertTrue(b1.play(3));
		assertTrue(b1.play(4));
		assertFalse(b1.gameOver());
		assertTrue(b1.play(2));
		assertTrue(b1.play(1));
		assertTrue(b1.play(7));
		assertTrue(b1.play(6));
		assertTrue(b1.play(7));
		assertTrue(b1.play(1));
		assertTrue(b1.gameOver());
		assertEquals('X', b1.winner());

		// X wins along right column
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(5));
		assertTrue(b2.play(7));
		assertTrue(b2.play(5));
		assertTrue(b2.play(5));
		assertFalse(b2.gameOver());
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(2));
		assertTrue(b2.play(7));
		assertTrue(b2.gameOver());
		assertEquals('X', b2.winner());

		// X wins in center column
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(4));
		assertTrue(b3.play(2));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(4));
		assertTrue(b3.play(7));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(5));
		assertTrue(b3.play(5));
		assertFalse(b3.gameOver());
		assertTrue(b3.play(4));
		assertTrue(b3.gameOver());
		assertEquals('X', b3.winner());
	}

	@Test
	public void test10VerticalOWin() {
		Board b1 = new Board();
		Board b2 = new Board();
		Board b3 = new Board();

		// O wins along left column
		assertTrue(b1.play(1));
		assertTrue(b1.play(1));
		assertTrue(b1.play(2));
		assertTrue(b1.play(1));
		assertTrue(b1.play(3));
		assertTrue(b1.play(4));
		assertFalse(b1.gameOver());
		assertTrue(b1.play(2));
		assertTrue(b1.play(1));
		assertTrue(b1.play(7));
		assertTrue(b1.play(6));
		assertTrue(b1.play(7));
		assertTrue(b1.play(1));
		assertTrue(b1.gameOver());
		assertEquals('O', b1.winner());

		// O wins along right column
		assertTrue(b2.play(1));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(5));
		assertTrue(b2.play(7));
		assertTrue(b2.play(5));
		assertTrue(b2.play(5));
		assertFalse(b2.gameOver());
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(2));
		assertTrue(b2.play(7));
		assertTrue(b2.gameOver());
		assertEquals('O', b2.winner());

		// O wins in center column
		assertTrue(b3.play(2));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(4));
		assertTrue(b3.play(2));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(4));
		assertTrue(b3.play(7));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(5));
		assertTrue(b3.play(5));
		assertFalse(b3.gameOver());
		assertTrue(b3.play(4));
		assertTrue(b3.gameOver());
		assertEquals('O', b3.winner());
	}

	@Test
	public void test10DiagonalUpXWin() {
		Board b1 = new Board();
		Board b2 = new Board();
		Board b3 = new Board();

		// X wins in bottom left
		assertTrue(b1.play(1));
		assertTrue(b1.play(2));
		assertTrue(b1.play(2));
		assertTrue(b1.play(3));
		assertTrue(b1.play(3));
		assertFalse(b1.gameOver());
		assertTrue(b1.play(4));
		assertTrue(b1.play(4));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(4));
		assertTrue(b1.play(4));
		assertTrue(b1.play(4));
		assertTrue(b1.play(3));
		assertTrue(b1.gameOver());
		assertEquals('X', b1.winner());

		// X wins in top right
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(5));
		assertTrue(b2.play(1));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertFalse(b2.gameOver());
		assertTrue(b2.play(4));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertTrue(b2.play(1));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(5));
		assertTrue(b2.gameOver());
		assertEquals('X', b2.winner());

		// X wins in middle
		assertTrue(b3.play(3));
		assertTrue(b3.play(1));
		assertTrue(b3.play(3));
		assertTrue(b3.play(1));
		assertTrue(b3.play(4));
		assertTrue(b3.play(4));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(6));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(6));
		assertTrue(b3.play(2));
		assertTrue(b3.play(4));
		assertTrue(b3.play(2));
		assertFalse(b3.gameOver());
		assertTrue(b3.play(5));
		assertTrue(b3.gameOver());
		assertEquals('X', b3.winner());
	}

	@Test
	public void test10DiagonalUpOWin() {
		Board b1 = new Board();
		Board b2 = new Board();
		Board b3 = new Board();

		// O wins in bottom left
		assertTrue(b1.play(5));
		assertTrue(b1.play(1));
		assertTrue(b1.play(2));
		assertTrue(b1.play(2));
		assertTrue(b1.play(3));
		assertTrue(b1.play(3));
		assertFalse(b1.gameOver());
		assertTrue(b1.play(7));
		assertTrue(b1.play(4));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(4));
		assertTrue(b1.play(3));
		assertTrue(b1.play(4));
		assertTrue(b1.play(4));
		assertTrue(b1.gameOver());
		assertEquals('O', b1.winner());

		// O wins in top right
		assertTrue(b2.play(3));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(5));
		assertTrue(b2.play(1));
		assertTrue(b2.play(5));
		assertFalse(b2.gameOver());
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertTrue(b2.play(1));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(5));
		assertTrue(b2.gameOver());
		assertEquals('O', b2.winner());

		// O wins in middle
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(1));
		assertTrue(b3.play(3));
		assertTrue(b3.play(1));
		assertTrue(b3.play(4));
		assertTrue(b3.play(4));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(6));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(6));
		assertTrue(b3.play(2));
		assertTrue(b3.play(4));
		assertTrue(b3.play(2));
		assertFalse(b3.gameOver());
		assertTrue(b3.play(5));
		assertTrue(b3.gameOver());
		assertEquals('O', b3.winner());
	}

	@Test
	public void test10DiagonalDownXWin() {
		Board b1 = new Board();
		Board b2 = new Board();
		Board b3 = new Board();

		// X wins in bottom left
		assertFalse(b1.gameOver());
		assertTrue(b1.play(1));
		assertTrue(b1.play(1));
		assertTrue(b1.play(7));
		assertTrue(b1.play(2));
		assertTrue(b1.play(3));
		assertTrue(b1.play(5));
		assertTrue(b1.play(3));
		assertTrue(b1.play(1));
		assertTrue(b1.play(1));
		assertTrue(b1.play(6));
		assertTrue(b1.play(4));
		assertTrue(b1.play(5));
		assertTrue(b1.play(5));
		assertTrue(b1.play(6));
		assertTrue(b1.play(4));
		assertTrue(b1.play(2));
		assertTrue(b1.play(1));
		assertTrue(b1.play(3));
		assertTrue(b1.play(2));
		assertTrue(b1.gameOver());
		assertEquals('X', b1.winner());

		// X wins in top right
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertFalse(b2.gameOver());
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertTrue(b2.gameOver());
		assertEquals('X', b2.winner());

		// X wins in middle
		assertTrue(b3.play(5));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(4));
		assertTrue(b3.play(4));
		assertTrue(b3.play(6));
		assertTrue(b3.play(3));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(2));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(3));
		assertTrue(b3.play(2));
		assertTrue(b3.play(1));
		assertTrue(b3.play(1));
		assertTrue(b3.play(1));
		assertTrue(b3.play(1));
		assertFalse(b3.gameOver());
		assertTrue(b3.play(2));
		assertTrue(b3.gameOver());
		assertEquals('X', b3.winner());
	}

	@Test
	public void test10DiagonalDownOWin() {
		Board b1 = new Board();
		Board b2 = new Board();
		Board b3 = new Board();

		// O wins in bottom left
		assertFalse(b1.gameOver());
		assertTrue(b1.play(7));
		assertTrue(b1.play(1));
		assertTrue(b1.play(1));
		assertTrue(b1.play(7));
		assertTrue(b1.play(2));
		assertTrue(b1.play(3));
		assertTrue(b1.play(5));
		assertTrue(b1.play(3));
		assertTrue(b1.play(1));
		assertTrue(b1.play(1));
		assertTrue(b1.play(6));
		assertTrue(b1.play(4));
		assertTrue(b1.play(5));
		assertTrue(b1.play(5));
		assertTrue(b1.play(6));
		assertTrue(b1.play(4));
		assertTrue(b1.play(2));
		assertTrue(b1.play(1));
		assertTrue(b1.play(3));
		assertTrue(b1.play(2));
		assertTrue(b1.gameOver());
		assertEquals('O', b1.winner());

		// O wins in top right
		assertTrue(b2.play(1));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(7));
		assertTrue(b2.play(6));
		assertTrue(b2.play(6));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(4));
		assertFalse(b2.gameOver());
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertTrue(b2.gameOver());
		assertEquals('O', b2.winner());

		// O wins in middle
		assertTrue(b3.play(6));
		assertTrue(b3.play(5));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(4));
		assertTrue(b3.play(4));
		assertTrue(b3.play(6));
		assertTrue(b3.play(3));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(2));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(3));
		assertTrue(b3.play(2));
		assertTrue(b3.play(1));
		assertTrue(b3.play(1));
		assertTrue(b3.play(1));
		assertTrue(b3.play(1));
		assertFalse(b3.gameOver());
		assertTrue(b3.play(2));
		assertTrue(b3.gameOver());
		assertEquals('O', b3.winner());
	}

	@Test
	public void test05IllegalMove() {
		Board b1 = new Board();
		Board b2 = new Board();
		assertEquals('X', b1.currentPlayer());
		assertEquals('X', b2.currentPlayer());
		assertFalse(b1.play(-5));
		assertTrue(b1.play(3));
		assertEquals('O', b1.currentPlayer());
		assertEquals('X', b2.currentPlayer());
		assertTrue(b1.play(4));
		assertFalse(b1.play(-2));
		assertEquals('X', b1.currentPlayer());
		assertEquals('X', b2.currentPlayer());
		assertFalse(b1.play(8));
		assertTrue(b1.play(1));
		assertEquals('O', b1.currentPlayer());
		assertEquals('X', b2.currentPlayer());
		assertTrue(b2.play(1));
		assertFalse(b1.play(8));
		assertEquals('O', b1.currentPlayer());
		assertEquals('O', b2.currentPlayer());
		assertTrue(b2.play(2));
		assertEquals('O', b1.currentPlayer());
		assertEquals('X', b2.currentPlayer());
		assertTrue(b2.play(4));
		assertTrue(b1.play(4));
		assertEquals('X', b1.currentPlayer());
		assertEquals('O', b2.currentPlayer());
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertFalse(b1.play(6));
	}

	@Test
	public void test05Exception() {
		Board b1 = new Board();
		Board b2 = new Board();
		Board b3 = new Board();


		assertTrue(b1.play(1));
		assertTrue(b1.play(7));
		assertTrue(b1.play(7));
		assertTrue(b1.play(7));
		assertTrue(b1.play(2));
		assertTrue(b1.play(1));
		assertFalse(b1.gameOver());
		assertTrue(b1.play(4));
		assertTrue(b1.play(6));
		assertTrue(b1.play(6));
		assertTrue(b1.play(5));
		assertTrue(b1.play(3));
		// GAME OVER, X won
		try {
			b1.play(1);
			fail("Game was over, RuntimeException should have been thrown");
		} catch (RuntimeException e) {
		}

	
		
		assertTrue(b2.play(2));
		assertTrue(b2.play(1));
		assertTrue(b2.play(2));
		assertTrue(b2.play(3));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(6));
		assertTrue(b2.play(7));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertTrue(b2.play(2));
		assertTrue(b2.play(7));
		assertTrue(b2.play(1));
		assertTrue(b2.play(4));
		assertTrue(b2.play(7));
		assertTrue(b2.play(4));
		assertTrue(b2.play(5));
		assertTrue(b2.play(5));
		assertTrue(b2.play(5));
		assertTrue(b2.play(4));
		// GAME OVER, O WON
		try {
			b1.play(7);
			fail("Game was over, RuntimeException should have been thrown");
		} catch (RuntimeException e) {
		}


		
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(1));
		assertTrue(b3.play(2));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(3));
		assertTrue(b3.play(4));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(5));
		assertTrue(b3.play(6));
		assertTrue(b3.play(7));
		assertTrue(b3.play(7));
		assertTrue(b3.play(7));
		assertTrue(b3.play(7));

		// GAME OVER, it's a draw
		System.out.println(b3);
		try {
			b3.play(4);
			fail("Game was over, RuntimeException should have been thrown");
		} catch (RuntimeException e) {
		}
	}
}
