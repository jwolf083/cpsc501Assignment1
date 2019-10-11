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
	
	public boolean canMove(Board b, int from_x, int from_y, int to_x, int to_y) {

		Piece destination = b.getPiece(to_x, to_y);
		int vert_distance = Math.abs(super.vertDistance(from_y, to_y));
		int horiz_distance = Math.abs(super.horizDistance(from_x, to_x));
		
		if (super.isPathClear(b, from_x, from_y, to_x, to_y)
			&& ((vert_distance > 0 && horiz_distance == 0)
				|| (vert_distance == 0 && horiz_distance > 0))) {
			if (destination == null) {
				return true;
			} else if (destination.getColor() != super.getColor()) {
				return true;
			}
		}
		return false;
	}
}