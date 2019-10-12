package app;


public class Queen extends Piece {
	private final static boolean WHITE = true;
	private final static boolean BLACK = false;
	
	public Queen(boolean _color) {
		super(_color);
	}
	
	public Queen(Queen other) {
		super(other.getColor());
	}
	
	public Queen clonePiece() {
		return new Queen(this);
	}
	
	public char getSymbol() {
		char symbol = 'Q';
		if (super.getColor() == WHITE) {
			symbol = 'q';
		}
		return symbol;
	}
	
	public boolean canMove(Board b, int from_x, int from_y, int to_x, int to_y) {
		 
		if (super.isPathClear(b, from_x, from_y, to_x, to_y)
			&& (isVertical(from_x, from_y, to_x, to_y)
				|| isHorizontal(from_x, from_y, to_x, to_y)
				|| isDiagonal(from_x, from_y, to_x, to_y))
			&& canTakeDestination(b, to_x, to_y)) {
			return true;
		} else {
			return false;
		}
	}
}
