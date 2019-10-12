package app;

public class Bishop extends Piece {
	private final static boolean WHITE = true;
	private final static boolean BLACK = false;
	
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
	
	
	private boolean isDiagonal(int from_x, int from_y, int to_x, int to_y) {
		
		int change_in_x = Math.abs(horizDistance(from_x, to_x));
		int change_in_y = Math.abs(vertDistance(from_y, to_y));
		
		change_in_x *= change_in_x;
		change_in_y *= change_in_y;
		if (change_in_x != 0 
			&& change_in_x == change_in_y) {
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
			&& isDiagonal(from_x, from_y, to_x, to_y)
			&& canTakeDestination(b, to_x, to_y)) {
			return true;
		} else {
			return false;
		}
	}
}