package app;

public class Rook extends Piece {
	private final static boolean WHITE = true;
	private final static boolean BLACK = false;
	
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
	
	private boolean isVertical(int from_x, int from_y, int to_x, int to_y) {
		
		if (horizDistance(from_x, to_x) == 0
			&& vertDistance(from_y, to_y) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isHorizontal(int from_x, int from_y, int to_x, int to_y) {
		
		if (vertDistance(from_y, to_y) == 0
			&& horizDistance(from_x, to_x) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean canTakeDestination(Board b, int to_x, int to_y) {
		
		Piece destination = b.getPiece(to_x, to_y);
		
		if (destination != null
			&& destination.getColor() == super.getColor()) {
			return false;
		} else {
			return true;
		}
		
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