package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Board;
import app.King;

class KingTest {
	final static boolean WHITE = true;
	final static boolean BLACK = false;
	King king_white;
	King king_black;
	Board b;
	@BeforeEach
	void setUp() throws Exception {
		king_black = new King(BLACK);
		king_white = new King(WHITE);
		b = new Board();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testKingColorWhite() {
		boolean expected = WHITE;
		boolean actual = king_white.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingColorBlack() {
		boolean expected = BLACK;
		boolean actual = king_black.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingGetSymbolWhite() {
		char expected = 'k';
		char actual = king_white.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingGetSymbolBlack() {
		char expected = 'K';
		char actual = king_black.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveVerticalUp() {
		boolean expected = true;
		boolean actual = king_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveVerticalDown() {
		boolean expected = true;
		boolean actual = king_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveHorizonalLeft() {
		boolean expected = true;
		boolean actual = king_black.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveHorizonalRight() {
		boolean expected = true;
		boolean actual = king_black.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveDiagonalUpLeft() {
		boolean expected = true;
		boolean actual = king_black.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveDiagonalUpRight() {
		boolean expected = true;
		boolean actual = king_black.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveDiagonalDownLeft() {
		boolean expected = true;
		boolean actual = king_black.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveDiagonalDownRight() {
		boolean expected = true;
		boolean actual = king_black.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveNonUniDirectionalOneUpTwoRight() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 7, 8);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveNonUniDirectionalOneDownTwoRight() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 7, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveNonUniDirectionalOneDownTwoLeft() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 3, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveNonUniDirectionalOneUpTwoLeft() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 3, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveNonUniDirectionalTwoUpOneLeft() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 4, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveNonUniDirectionalTwoUpOneRight() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 6, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveNonUniDirectionalTwoDownOneRight() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 6, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveNonUniDirectionalTwoDownOneLeft() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 4, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveMultipleHorizLeft() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 3, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveMultipleHorizRight() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 7, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveMultipleVertUp() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 5, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveMultipleVertDown() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 5, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveMultipleDiagonalUpLeft() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 3, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveMultipleDiagonalUpRight() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 7, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveMultipleDiagonalDownLeft() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 3, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveMultipleDiagonalDownRight() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 7, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanMoveZero() {
		boolean expected = false;
		boolean actual = king_black.canMove(b, 5, 5, 5, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeSameVerticalUp() {
		b.place(king_white, 5, 6);
		boolean expected = false;
		boolean actual = king_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeSameVerticalDown() {
		b.place(king_white, 5, 4);
		boolean expected = false;
		boolean actual = king_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeSameHorizonalLeft() {
		b.place(king_white, 4, 5);
		boolean expected = false;
		boolean actual = king_white.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeSameHorizonalRight() {
		b.place(king_white, 6, 5);
		boolean expected = false;
		boolean actual = king_white.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeSameDiagonalUpLeft() {
		b.place(king_white, 4, 4);
		boolean expected = false;
		boolean actual = king_white.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeSameDiagonalUpRight() {
		b.place(king_white, 6, 4);
		boolean expected = false;
		boolean actual = king_white.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeSameDiagonalDownLeft() {
		b.place(king_white, 4, 6);
		boolean expected = false;
		boolean actual = king_white.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeSameDiagonalDownRight() {
		b.place(king_white, 6, 6);
		boolean expected = false;
		boolean actual = king_white.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeVerticalUp() {
		b.place(king_black, 5, 6);
		boolean expected = true;
		boolean actual = king_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeVerticalDown() {
		b.place(king_black, 5, 4);
		boolean expected = true;
		boolean actual = king_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeHorizonalLeft() {
		b.place(king_black, 4, 5);
		boolean expected = true;
		boolean actual = king_white.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeHorizonalRight() {
		b.place(king_black, 6, 5);
		boolean expected = true;
		boolean actual = king_white.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeDiagonalUpLeft() {
		b.place(king_black, 4, 4);
		boolean expected = true;
		boolean actual = king_white.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeDiagonalUpRight() {
		b.place(king_black, 6, 4);
		boolean expected = true;
		boolean actual = king_white.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeDiagonalDownLeft() {
		b.place(king_black, 4, 6);
		boolean expected = true;
		boolean actual = king_white.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testKingCanTakeDiagonalDownRight() {
		b.place(king_black, 6, 6);
		boolean expected = true ;
		boolean actual = king_white.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
	}
}
