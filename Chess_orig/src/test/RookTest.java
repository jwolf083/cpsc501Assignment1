package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Board;
import app.Rook;

class RookTest {
	final static boolean WHITE = true;
	final static boolean BLACK = false;
	Rook rook_white;
	Rook rook_black;
	Board b;
	@BeforeEach
	void setUp() throws Exception {
		rook_black = new Rook(BLACK);
		rook_white = new Rook(WHITE);
		b = new Board();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testRookColorWhite() {
		boolean expected = WHITE;
		boolean actual = rook_white.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookColorBlack() {
		boolean expected = BLACK;
		boolean actual = rook_black.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookGetSymbolWhite() {
		char expected = 'r';
		char actual = rook_white.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookGetSymbolBlack() {
		char expected = 'R';
		char actual = rook_black.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveVerticalUp() {
		boolean expected = true;
		boolean actual = rook_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveVerticalDown() {
		boolean expected = true;
		boolean actual = rook_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveHorizonalLeft() {
		boolean expected = true;
		boolean actual = rook_black.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveHorizonalRight() {
		boolean expected = true;
		boolean actual = rook_black.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveDiagonalUpLeft() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveDiagonalUpRight() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveDiagonalDownLeft() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveDiagonalDownRight() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveNonUniDirectionalOneUpTwoRight() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 7, 8);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveNonUniDirectionalOneDownTwoRight() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 7, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveNonUniDirectionalOneDownTwoLeft() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 3, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveNonUniDirectionalOneUpTwoLeft() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 3, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveNonUniDirectionalTwoUpOneLeft() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 4, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveNonUniDirectionalTwoUpOneRight() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 6, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveNonUniDirectionalTwoDownOneRight() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 6, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveNonUniDirectionalTwoDownOneLeft() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 4, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveMultipleHorizLeft() {
		boolean expected = true;
		boolean actual = rook_black.canMove(b, 5, 5, 3, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveMultipleHorizRight() {
		boolean expected = true;
		boolean actual = rook_black.canMove(b, 5, 5, 7, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveMultipleVertUp() {
		boolean expected = true;
		boolean actual = rook_black.canMove(b, 5, 5, 5, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveMultipleVertDown() {
		boolean expected = true;
		boolean actual = rook_black.canMove(b, 5, 5, 5, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveZero() {
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 5, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanTakeSameVerticalUp() {
		b.place(rook_white, 5, 6);
		boolean expected = false;
		boolean actual = rook_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanTakeSameVerticalDown() {
		b.place(rook_white, 5, 4);
		boolean expected = false;
		boolean actual = rook_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanTakeSameHorizonalLeft() {
		b.place(rook_white, 4, 5);
		boolean expected = false;
		boolean actual = rook_white.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanTakeSameHorizonalRight() {
		b.place(rook_white, 6, 5);
		boolean expected = false;
		boolean actual = rook_white.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanTakeVerticalUp() {
		b.place(rook_black, 5, 6);
		boolean expected = true;
		boolean actual = rook_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanTakeVerticalDown() {
		b.place(rook_black, 5, 4);
		boolean expected = true;
		boolean actual = rook_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanTakeHorizonalLeft() {
		b.place(rook_black, 4, 5);
		boolean expected = true;
		boolean actual = rook_white.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanTakeHorizonalRight() {
		b.place(rook_black, 6, 5);
		boolean expected = true;
		boolean actual = rook_white.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveHorizLeftPathNotClear() {
		b.place(rook_white, 4, 5);
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 3, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveHorizRightPathNotClear() {
		b.place(rook_white, 6, 5);
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 7, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveVertUpPathNotClear() {
		b.place(rook_white, 5, 4);
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 5, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testRookCanMoveVertDownPathNotClear() {
		b.place(rook_white, 5, 6);
		boolean expected = false;
		boolean actual = rook_black.canMove(b, 5, 5, 5, 7);
		assertEquals(expected, actual);
	}
	
}
