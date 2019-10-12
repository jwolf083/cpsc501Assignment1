package app;

public class Knight extends Piece {
	
	public Knight(boolean _color) {
		super(_color);
	}
	
	public Knight(Knight other) {
		super(other.getColor());
	}
	
	public Knight clonePiece() {
		return new Knight(this);
	}
	
	public char getSymbol() {
		char symbol = 'N';
		if (super.getColor() == WHITE) {
			symbol = 'n';
		}
		return symbol;
	}
	
	private boolean isKnightDistance(int from_x, int from_y, int to_x, int to_y) {
		int vert_distance = Math.abs(super.vertDistance(from_y, to_y));
		int horiz_distance = Math.abs(super.horizDistance(from_x, to_x));
		
		if ((vert_distance == 1 && horiz_distance == 2)
				|| (vert_distance == 2 && horiz_distance == 1)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean canMove(Board b, int from_x, int from_y, int to_x, int to_y) {
	
		
		if (isKnightDistance(from_x, from_y, to_x, to_y)
			&& canTakeDestination(b, to_x, to_y)) {
			return true;
		} else {
			return false;
		}
	}
}