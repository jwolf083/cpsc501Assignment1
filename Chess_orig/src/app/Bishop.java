package app;

public class Bishop extends Piece {
	
	public Bishop(boolean _color) {
		super(_color);
	}
	
	public Bishop(Bishop other) {
		super(other.getColor());
	}
	
	public Bishop clonePiece() {
		return new Bishop(this);
	}
	
	public char getSymbol() {
		char symbol = 'B';
		if (super.getColor() == WHITE) {
			symbol = 'b';
		}
		return symbol;
	}
	
	public boolean canMove(Board b, int from_x, int from_y, int to_x, int to_y) {
		
		if (super.isPathClear(b, from_x, from_y, to_x, to_y)
			&& isDiagonal(from_x, from_y, to_x, to_y)
			&& canTakeDestination(b, to_x, to_y)) {
			return true;
		} else {
			return false;
		}
	}
}