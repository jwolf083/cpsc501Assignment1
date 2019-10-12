package app;


public abstract class Piece {
	protected static final boolean WHITE = true;
	protected static final boolean BLACK = false;
	
	private boolean color;
	
	protected Piece(boolean _color) {
		this.color = _color;
	}
	
	public boolean getColor() {
		return this.color;
	}
	
	
	protected boolean isVertical(int from_x, int from_y, int to_x, int to_y) {
		
		if (horizDistance(from_x, to_x) == 0
			&& vertDistance(from_y, to_y) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isHorizontal(int from_x, int from_y, int to_x, int to_y) {
		
		if (vertDistance(from_y, to_y) == 0
			&& horizDistance(from_x, to_x) != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean canTakeDestination(Board b, int to_x, int to_y) {
		
		Piece destination = b.getPiece(to_x, to_y);
		
		if (destination != null
			&& destination.getColor() == this.color) {
			return false;
		} else {
			return true;
		}
		
	}
	
	protected boolean isDiagonal(int from_x, int from_y, int to_x, int to_y) {
		
		int change_in_x = horizDistance(from_x, to_x);
		int change_in_y = vertDistance(from_y, to_y);
		
		change_in_x *= change_in_x;
		change_in_y *= change_in_y;
		if (change_in_x != 0 
			&& change_in_x == change_in_y) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isPathClear(Board b, int from_x, int from_y, int to_x, int to_y) {
		
		int change_in_x = horizDistance(from_x, to_x);
		int change_in_y = vertDistance(from_y, to_y);
		int next_x = from_x;
		int next_y = from_y;
		
		if (change_in_x != 0) {
			next_x += (1 * change_in_x) / Math.abs(change_in_x);
		}
		if (change_in_y != 0) {
			next_y += (1 * change_in_y) / Math.abs(change_in_y);
		}
		
		if (horizDistance(next_x, to_x) == 0
			&& vertDistance(next_y, to_y) == 0) {
			return true;
		} else if (b.getPiece(next_x, next_y) != null) {
			return false;
		} else {
			return isPathClear(b, next_x, next_y, to_x, to_y);
		}
	}
	
	protected int vertDistance(int from_y, int to_y) {
		
		return to_y - from_y;
	}
	
	protected int horizDistance(int from_x, int to_x) {
		
		return to_x - from_x;
	}

	protected abstract char getSymbol();

	protected abstract Piece clonePiece();

	protected abstract boolean canMove(Board board, int from_x, int from_y, int to_x, int to_y);
	
	
}
