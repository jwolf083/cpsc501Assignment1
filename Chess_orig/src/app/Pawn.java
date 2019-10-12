package app;


public class Pawn extends Piece {
	
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
	
	private boolean canTakeDestinationPawn(Board b, int to_x, int to_y) {
		
		Piece destination = b.getPiece(to_x, to_y);
		
		if (destination != null
			&& destination.getColor() != super.getColor()) {
			return true;
		} else {
			return false;
		}
	}
		
	private boolean isForward(int from_y, int to_y) {
			
		int change_in_y = vertDistance(from_y, to_y);
		
		if (super.getColor() == WHITE && change_in_y < 0) {
			return true;
		} else if (super.getColor() == BLACK && change_in_y > 0) {
			return true;
		} else {
			return false;
		}
	}
		
	public boolean canMove(Board b, int from_x, int from_y, int to_x, int to_y) {
		
		Piece destination = b.getPiece(to_x, to_y); 
		int vert_distance = Math.abs(super.vertDistance(from_y, to_y));
		
		if (super.isPathClear(b, from_x, from_y, to_x, to_y)
			&& isForward(from_y, to_y)) {
			if (isVertical(from_x, from_y, to_x, to_y)
				&& destination == null) {
				if (vert_distance == 1
					|| (vert_distance == 2 && !this.has_moved)) {
					this.has_moved = true;
					return true;
				}
			} else if (isDiagonal(from_x, from_y, to_x, to_y) 
					   && canTakeDestinationPawn(b, to_x, to_y)
					   && vert_distance == 1) {
				this.has_moved = true;
				return true;
			}
		}
		return false;
	}

	
}
