package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Bishop;
import app.Board;

class BishopTest {
	final static boolean WHITE = true;
	final static boolean BLACK = false;
	Bishop bishop_white;
	Bishop bishop_black;
	Board b;
	@BeforeEach
	void setUp() throws Exception {
		bishop_black = new Bishop(BLACK);
		bishop_white = new Bishop(WHITE);
		b = new Board();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testBishopColorWhite() {
		boolean expected = WHITE;
		boolean actual = bishop_white.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopColorBlack() {
		boolean expected = BLACK;
		boolean actual = bishop_black.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopGetSymbolWhite() {
		char expected = 'b';
		char actual = bishop_white.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopGetSymbolBlack() {
		char expected = 'B';
		char actual = bishop_black.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveVerticalUp() {
		boolean expected = false;
		boolean actual = bishop_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveVerticalDown() {
		boolean expected = false;
		boolean actual = bishop_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveHorizonalLeft() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveHorizonalRight() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveDiagonalUpLeft() {
		boolean expected = true;
		boolean actual = bishop_black.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveDiagonalUpRight() {
		boolean expected = true;
		boolean actual = bishop_black.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveDiagonalDownLeft() {
		boolean expected = true;
		boolean actual = bishop_black.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveDiagonalDownRight() {
		boolean expected = true;
		boolean actual = bishop_black.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveNonUniDirectionalOneUpTwoRight() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 7, 8);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveNonUniDirectionalOneDownTwoRight() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 7, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveNonUniDirectionalOneDownTwoLeft() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 3, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveNonUniDirectionalOneUpTwoLeft() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 3, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveNonUniDirectionalTwoUpOneLeft() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 4, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveNonUniDirectionalTwoUpOneRight() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 6, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveNonUniDirectionalTwoDownOneRight() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 6, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveNonUniDirectionalTwoDownOneLeft() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 4, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveMultipleDiagonalUpLeft() {
		boolean expected = true;
		boolean actual = bishop_black.canMove(b, 5, 5, 3, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveMultipleDiagonalUpRight() {
		boolean expected = true;
		boolean actual = bishop_black.canMove(b, 5, 5, 7, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveMultipleDiagonalDownLeft() {
		boolean expected = true;
		boolean actual = bishop_black.canMove(b, 5, 5, 3, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveMultipleDiagonalDownRight() {
		boolean expected = true;
		boolean actual = bishop_black.canMove(b, 5, 5, 7, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveZero() {
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 5, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanTakeSameDiagonalUpLeft() {
		b.place(bishop_white, 4, 4);
		boolean expected = false;
		boolean actual = bishop_white.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanTakeSameDiagonalUpRight() {
		b.place(bishop_white, 6, 4);
		boolean expected = false;
		boolean actual = bishop_white.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanTakeSameDiagonalDownLeft() {
		b.place(bishop_white, 4, 6);
		boolean expected = false;
		boolean actual = bishop_white.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanTakeSameDiagonalDownRight() {
		b.place(bishop_white, 6, 6);
		boolean expected = false;
		boolean actual = bishop_white.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanTakeDiagonalUpLeft() {
		b.place(bishop_black, 4, 4);
		boolean expected = true;
		boolean actual = bishop_white.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanTakeDiagonalUpRight() {
		b.place(bishop_black, 6, 4);
		boolean expected = true;
		boolean actual = bishop_white.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanTakeDiagonalDownLeft() {
		b.place(bishop_black, 4, 6);
		boolean expected = true;
		boolean actual = bishop_white.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanTakeDiagonalDownRight() {
		b.place(bishop_black, 6, 6);
		boolean expected = true ;
		boolean actual = bishop_white.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveDiagonalUpLeftPathNotClear() {
		b.place(bishop_white, 4, 4);
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 3, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveDiagonalUpRightPathNotClear() {
		b.place(bishop_white, 6, 4);
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 7, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveDiagonalDownLeftPathNotClear() {
		b.place(bishop_white, 4, 6);
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 3, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testBishopCanMoveDiagonalDownRightPathNotClear() {
		b.place(bishop_white, 6, 6);
		boolean expected = false;
		boolean actual = bishop_black.canMove(b, 5, 5, 7, 7);
		assertEquals(expected, actual);
	}
}
