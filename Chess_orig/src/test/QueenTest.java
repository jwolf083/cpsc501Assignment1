package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Board;
import app.Queen;

class QueenTest {
	final static boolean WHITE = true;
	final static boolean BLACK = false;
	Queen queen_white;
	Queen queen_black;
	Board b;
	@BeforeEach
	void setUp() throws Exception {
		queen_black = new Queen(BLACK);
		queen_white = new Queen(WHITE);
		b = new Board();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testQueenColorWhite() {
		boolean expected = WHITE;
		boolean actual = queen_white.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenColorBlack() {
		boolean expected = BLACK;
		boolean actual = queen_black.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenGetSymbolWhite() {
		char expected = 'q';
		char actual = queen_white.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenGetSymbolBlack() {
		char expected = 'Q';
		char actual = queen_black.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveVerticalUp() {
		boolean expected = true;
		boolean actual = queen_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveVerticalDown() {
		boolean expected = true;
		boolean actual = queen_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveHorizonalLeft() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveHorizonalRight() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveDiagonalUpLeft() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveDiagonalUpRight() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveDiagonalDownLeft() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveDiagonalDownRight() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveNonUniDirectionalOneUpTwoRight() {
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 7, 8);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveNonUniDirectionalOneDownTwoRight() {
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 7, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveNonUniDirectionalOneDownTwoLeft() {
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 3, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveNonUniDirectionalOneUpTwoLeft() {
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 3, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveNonUniDirectionalTwoUpOneLeft() {
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 4, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveNonUniDirectionalTwoUpOneRight() {
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 6, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveNonUniDirectionalTwoDownOneRight() {
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 6, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveNonUniDirectionalTwoDownOneLeft() {
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 4, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveMultipleHorizLeft() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 3, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveMultipleHorizRight() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 7, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveMultipleVertUp() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 5, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveMultipleVertDown() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 5, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveMultipleDiagonalUpLeft() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 3, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveMultipleDiagonalUpRight() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 7, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveMultipleDiagonalDownLeft() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 3, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveMultipleDiagonalDownRight() {
		boolean expected = true;
		boolean actual = queen_black.canMove(b, 5, 5, 7, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveZero() {
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 5, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeSameVerticalUp() {
		b.place(queen_white, 5, 6);
		boolean expected = false;
		boolean actual = queen_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeSameVerticalDown() {
		b.place(queen_white, 5, 4);
		boolean expected = false;
		boolean actual = queen_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeSameHorizonalLeft() {
		b.place(queen_white, 4, 5);
		boolean expected = false;
		boolean actual = queen_white.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeSameHorizonalRight() {
		b.place(queen_white, 6, 5);
		boolean expected = false;
		boolean actual = queen_white.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeSameDiagonalUpLeft() {
		b.place(queen_white, 4, 4);
		boolean expected = false;
		boolean actual = queen_white.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeSameDiagonalUpRight() {
		b.place(queen_white, 6, 4);
		boolean expected = false;
		boolean actual = queen_white.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeSameDiagonalDownLeft() {
		b.place(queen_white, 4, 6);
		boolean expected = false;
		boolean actual = queen_white.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeSameDiagonalDownRight() {
		b.place(queen_white, 6, 6);
		boolean expected = false;
		boolean actual = queen_white.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeVerticalUp() {
		b.place(queen_black, 5, 6);
		boolean expected = true;
		boolean actual = queen_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeVerticalDown() {
		b.place(queen_black, 5, 4);
		boolean expected = true;
		boolean actual = queen_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeHorizonalLeft() {
		b.place(queen_black, 4, 5);
		boolean expected = true;
		boolean actual = queen_white.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeHorizonalRight() {
		b.place(queen_black, 6, 5);
		boolean expected = true;
		boolean actual = queen_white.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeDiagonalUpLeft() {
		b.place(queen_black, 4, 4);
		boolean expected = true;
		boolean actual = queen_white.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeDiagonalUpRight() {
		b.place(queen_black, 6, 4);
		boolean expected = true;
		boolean actual = queen_white.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeDiagonalDownLeft() {
		b.place(queen_black, 4, 6);
		boolean expected = true;
		boolean actual = queen_white.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanTakeDiagonalDownRight() {
		b.place(queen_black, 6, 6);
		boolean expected = true ;
		boolean actual = queen_white.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveHorizLeftPathNotClear() {
		b.place(queen_white, 4, 5);
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 3, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveHorizRightPathNotClear() {
		b.place(queen_white, 6, 5);
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 7, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveVertUpPathNotClear() {
		b.place(queen_white, 5, 4);
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 5, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveVertDownPathNotClear() {
		b.place(queen_white, 5, 6);
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 5, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveDiagonalUpLeftPathNotClear() {
		b.place(queen_white, 4, 4);
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 3, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveDiagonalUpRightPathNotClear() {
		b.place(queen_white, 6, 4);
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 7, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveDiagonalDownLeftPathNotClear() {
		b.place(queen_white, 4, 6);
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 3, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testQueenCanMoveDiagonalDownRightPathNotClear() {
		b.place(queen_white, 6, 6);
		boolean expected = false;
		boolean actual = queen_black.canMove(b, 5, 5, 7, 7);
		assertEquals(expected, actual);
	}
}
