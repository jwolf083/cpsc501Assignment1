package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import app.Board;
import app.Pawn;

class PawnTest {
	final static boolean WHITE = true;
	final static boolean BLACK = false;
	Pawn pawn_white;
	Pawn pawn_black;
	Board b;
	@BeforeEach
	void setUp() throws Exception {
		pawn_black = new Pawn(BLACK);
		pawn_white = new Pawn(WHITE);
		b = new Board();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPawnColorWhite() {
		boolean expected = WHITE;
		boolean actual = pawn_white.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnColorBlack() {
		boolean expected = BLACK;
		boolean actual = pawn_black.getColor();
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnGetSymbolWhite() {
		char expected = 'p';
		char actual = pawn_white.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnGetSymbolBlack() {
		char expected = 'P' ;
		char actual = pawn_black.getSymbol();
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMoveBackwardWhite() {
		boolean expected = false ;
		boolean actual = pawn_white.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMoveBackwardBlack() {
		boolean expected = false ;
		boolean actual = pawn_black.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMoveHorizonalLeft() {
		boolean expected = false ;
		boolean actual = pawn_black.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
		actual = pawn_white.canMove(b, 5, 5, 4, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMoveHorizonalRight() {
		boolean expected = false ;
		boolean actual = pawn_black.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
		actual = pawn_white.canMove(b, 5, 5, 6, 5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMoveDiagonalNoTake() {
		boolean expected = false ;
		boolean actual = pawn_black.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
		actual = pawn_black.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
		actual = pawn_white.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
		actual = pawn_white.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMoveDiagonalTake() {
		b.place(pawn_white, 4, 6);
		b.place(pawn_white, 6, 6);
		b.place(pawn_black, 6, 4);
		b.place(pawn_black, 4, 4);
		boolean expected = true;
		boolean actual = pawn_black.canMove(b, 5, 5, 4, 6);
		assertEquals(expected, actual);
		actual = pawn_black.canMove(b, 5, 5, 6, 6);
		assertEquals(expected, actual);
		actual = pawn_white.canMove(b, 5, 5, 6, 4);
		assertEquals(expected, actual);
		actual = pawn_white.canMove(b, 5, 5, 4, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMoveForwardOne() {
		boolean expected = true;
		boolean actual = pawn_black.canMove(b, 5, 5, 5, 6);
		assertEquals(expected, actual);
		actual = pawn_white.canMove(b, 5, 5, 5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMoveForwardTwo() {
		boolean expected = true;
		boolean actual = pawn_black.canMove(b, 5, 5, 5, 7);
		assertEquals(expected, actual);
		actual = pawn_white.canMove(b, 5, 5, 5, 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMoveForwardTwoAlreadyMoved() {
		boolean expected = false;
		pawn_black.canMove(b, 3, 3, 3, 5);
		boolean actual = pawn_black.canMove(b, 5, 5, 5, 7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testPawnCanMovePieceInPath() {
		boolean expected = false;
		b.place(pawn_white, 5, 6);
		boolean actual = pawn_black.canMove(b, 5, 5, 5, 7);
		assertEquals(expected, actual);
	}
	

}
