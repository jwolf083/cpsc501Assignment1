package app;


public class Pawn extends Piece {
	private final static boolean WHITE = true;
	private final static boolean BLACK = false;
	private boolean has_moved = false;
	
	public Pawn(boolean _color) {
		super(_color);
	}
	
	public Pawn(Pawn other) {
		super(other.getColor());
		this.has_moved = other.has_moved;
	}
	
	public Piece clonePiece() {
		return new Pawn(this);
	}
	
	public char getSymbol() {
		char symbol = 'P';
		if (super.getColor() == WHITE) {
			symbol = 'p';
		}
		return symbol;
	}
	
	public boolean canMove(Board b, int from_x, int from_y, int to_x, int to_y) {
		
		Piece destination = b.getPiece(to_x, to_y);
		int vert_distance = super.vertDistance(from_y, to_y);
		int vert_distance_abs = Math.abs(vert_distance);
		int horiz_distance_abs = Math.abs(super.horizDistance(from_x, to_x));
		
		if (super.isPathClear(b, from_x, from_y, to_x, to_y) 
			&& ((super.getColor() == WHITE && vert_distance < 0)
				|| super.getColor() == BLACK && vert_distance > 0)) {
			if (horiz_distance_abs == 0
				&& destination == null) {
				if (vert_distance_abs == 1
					|| (vert_distance_abs == 2 && !this.has_moved)) {
					this.has_moved = true;
					return true;
				}
			} else if (horiz_distance_abs == vert_distance_abs
					 && destination != null
					 && destination.getColor() != super.getColor()
					 && vert_distance_abs == 1) {
				this.has_moved = true;
				return true;
			}
		}
		return false;	
	}
	
}
