package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Board;
import app.Knight;

class KnightTest {
	final static boolean WHITE = true;
	final static boolean BLACK = false;
	final static int MIN = 0;
	final static int MAX = 8;
	Knight knight_white;
	Knight knight_black;
	Board b;
	Board filled;
	@BeforeEach
	void setUp() throws Exception {
		knight_black = new Knight(BLACK);
		knight_white = new Knight(WHITE);
		b = new Board();
		filled = new Board();
		for (int i = 0; i < MAX; i+=1) {
			for (int n = 0; n < MAX; n+=1) {
				filled.place(knight_white, n, i);
			}
		}
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testKnightColorWhite() {
		boolean expected = WHITE;
		boolean actual = knight_white.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightColorBlack() {
		boolean expected = BLACK;
		boolean actual = knight_black.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightGetSymbolWhite() {
		char expected = 'n';
		char actual = knight_white.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightGetSymbolBlack() {
		char expected = 'N';
		char actual = knight_black.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveVerticalUp() {
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveVerticalDown() {
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveHorizonalLeft() {
		boolean expected = false;
		boolean actual = knight_black.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveHorizonalRight() {
		boolean expected = false;
		boolean actual = knight_black.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveDiagonalUpLeft() {
		boolean expected = false;
		boolean actual = knight_black.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveDiagonalUpRight() {
		boolean expected = false;
		boolean actual = knight_black.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveDiagonalDownLeft() {
		boolean expected = false;
		boolean actual = knight_black.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveDiagonalDownRight() {
		boolean expected = false;
		boolean actual = knight_black.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveNonUniDirectionalOneUpTwoRight() {
		boolean expected = true;
		boolean actual = knight_black.canMove(b, 5, 5, 7, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveNonUniDirectionalOneDownTwoRight() {
		boolean expected = true;
		boolean actual = knight_black.canMove(b, 5, 5, 7, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveNonUniDirectionalOneDownTwoLeft() {
		boolean expected = true;
		boolean actual = knight_black.canMove(b, 5, 5, 3, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveNonUniDirectionalOneUpTwoLeft() {
		boolean expected = true;
		boolean actual = knight_black.canMove(b, 5, 5, 3, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveNonUniDirectionalTwoUpOneLeft() {
		boolean expected = true;
		boolean actual = knight_black.canMove(b, 5, 5, 4, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveNonUniDirectionalTwoUpOneRight() {
		boolean expected = true;
		boolean actual = knight_black.canMove(b, 5, 5, 6, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveNonUniDirectionalTwoDownOneRight() {
		boolean expected = true;
		boolean actual = knight_black.canMove(b, 5, 5, 6, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveNonUniDirectionalTwoDownOneLeft() {
		boolean expected = true;
		boolean actual = knight_black.canMove(b, 5, 5, 4, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveZero() {
		boolean expected = false;
		boolean actual = knight_black.canMove(b, 5, 5, 5, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeNonUniDirectionalOneUpTwoRight() {
		b.place(knight_black, 7, 8);
		boolean expected = true;
		boolean actual = knight_white.canMove(b, 5, 5, 7, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeNonUniDirectionalOneDownTwoRight() {
		b.place(knight_black, 7, 4);
		boolean expected = true;
		boolean actual = knight_white.canMove(b, 5, 5, 7, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeNonUniDirectionalOneDownTwoLeft() {
		b.place(knight_black, 3, 4);
		boolean expected = true;
		boolean actual = knight_white.canMove(b, 5, 5, 3, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeNonUniDirectionalOneUpTwoLeft() {
		b.place(knight_black, 3, 6);
		boolean expected = true;
		boolean actual = knight_white.canMove(b, 5, 5, 3, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeNonUniDirectionalTwoUpOneLeft() {
		b.place(knight_black, 4, 3);
		boolean expected = true;
		boolean actual = knight_white.canMove(b, 5, 5, 4, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeNonUniDirectionalTwoUpOneRight() {
		b.place(knight_black, 6, 3);
		boolean expected = true;
		boolean actual = knight_white.canMove(b, 5, 5, 6, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeNonUniDirectionalTwoDownOneRight() {
		b.place(knight_black, 6, 7);
		boolean expected = true;
		boolean actual = knight_white.canMove(b, 5, 5, 6, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeNonUniDirectionalTwoDownOneLeft() {
		b.place(knight_black, 4, 7);
		boolean expected = true;
		boolean actual = knight_white.canMove(b, 5, 5, 4, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeSameNonUniDirectionalOneUpTwoRight() {
		b.place(knight_white, 7, 6);
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 7, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeSameUniDirectionalOneDownTwoRight() {
		b.place(knight_white, 7, 4);
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 7, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeSameNonUniDirectionalOneDownTwoLeft() {
		b.place(knight_white, 3, 4);
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 3, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeSameNonUniDirectionalOneUpTwoLeft() {
		b.place(knight_white, 3, 6);
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 3, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeSameNonUniDirectionalTwoUpOneLeft() {
		b.place(knight_white, 4, 3);
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 4, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeSameNonUniDirectionalTwoUpOneRight() {
		b.place(knight_white, 6, 3);
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 6, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeSameNonUniDirectionalTwoDownOneRight() {
		b.place(knight_white, 6, 7);
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 6, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanTakeSameUniDirectionalTwoDownOneLeft() {
		b.place(knight_white, 4, 7);
		boolean expected = false;
		boolean actual = knight_white.canMove(b, 5, 5, 4, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMoveNonUniDirectionalOneUpTwoRightPathNotClear() {
		boolean expected = true;
		boolean actual = knight_black.canMove(filled, 5, 5, 7, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMovePathNotClearNonUniDirectionalOneDownTwoRight() {
		boolean expected = true;
		boolean actual = knight_black.canMove(filled, 5, 5, 7, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMovePathNotClearNonUniDirectionalOneDownTwoLeft() {
		boolean expected = true;
		boolean actual = knight_black.canMove(filled, 5, 5, 3, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMovePathNotClearNonUniDirectionalOneUpTwoLeft() {
		boolean expected = true;
		boolean actual = knight_black.canMove(filled, 5, 5, 3, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMovePathNotClearNonUniDirectionalTwoUpOneLeft() {
		boolean expected = true;
		boolean actual = knight_black.canMove(filled, 5, 5, 4, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMovePathNotClearNonUniDirectionalTwoUpOneRight() {
		boolean expected = true;
		boolean actual = knight_black.canMove(filled, 5, 5, 6, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMovePathNotClearNonUniDirectionalTwoDownOneRight() {
		boolean expected = true;
		boolean actual = knight_black.canMove(filled, 5, 5, 6, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKnightCanMovePathNotClearNonUniDirectionalTwoDownOneLeft() {
		boolean expected = true;
		boolean actual = knight_black.canMove(filled, 5, 5, 4, 7);
		assertEquals(expected, actual);
	}
}
