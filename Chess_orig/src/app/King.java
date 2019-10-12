package app;


public class King extends Piece {
	
	private final static boolean WHITE = true;
	private final static boolean BLACK = false;
	
	public King(boolean _color) {
		super(_color);
	}
	
	public King(King other) {
		super(other.getColor());
	}
	
	public Piece clonePiece() {
		return new King(this);
	}
	
	public char getSymbol() {
		char symbol = 'K';
		if (super.getColor() == WHITE) {
			symbol = 'k';
		}
		return symbol;
	}
	
	public boolean canMove(Board b, int from_x, int from_y, int to_x, int to_y) {
		
		int vert_distance = Math.abs(super.vertDistance(from_y, to_y));
		int horiz_distance = Math.abs(super.horizDistance(from_x, to_x));
		
		if ((vert_distance == 1 || horiz_distance == 1)
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
