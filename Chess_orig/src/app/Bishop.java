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
	
	public boolean canMove(Board b, int from_x, int from_y, int to_x, int to_y) {
		
		Piece destination = b.getPiece(to_x, to_y);
		int vert_distance = Math.abs(super.vertDistance(from_y, to_y));
		int horiz_distance = Math.abs(super.horizDistance(from_x, to_x));
		
		if (super.isPathClear(b, from_x, from_y, to_x, to_y)
			&& vert_distance == horiz_distance
			&& vert_distance > 0) {
			if (destination == null) {
				return true;
			} else if (destination.getColor() != super.getColor()) {
				return true;
			}
		}
		return false;
	}
}