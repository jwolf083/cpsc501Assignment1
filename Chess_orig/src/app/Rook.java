package app;

public class Rook extends Piece {
	
	public Rook(boolean _color) {
		super(_color);
	}
	
	public Rook(Rook other) {
		super(other.getColor());
	}
	
	public Rook clonePiece() {
		return new Rook(this);
	}
	
	public char getSymbol() {
		char symbol = 'R';
		if (super.getColor() == WHITE) {
			symbol = 'r';
		}
		return symbol;
	}
	
	public boolean canMove(Board b, int from_x, int from_y, int to_x, int to_y) {
		 
		if (super.isPathClear(b, from_x, from_y, to_x, to_y)
			&& (isHorizontal(from_x, from_y, to_x, to_y)
				|| isVertical(from_x, from_y, to_x, to_y))
			&& canTakeDestination(b, to_x, to_y)) {
			return true;
		} else {
			return false;
		}
	}
}