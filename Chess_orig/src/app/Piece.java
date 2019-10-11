package app;


public abstract class Piece {
	private final static boolean WHITE = true;
	private final static boolean BLACK = false;
	private boolean color;
	
	protected Piece(boolean _color) {
		this.color = _color;
	}
	
	public boolean getColor() {
		return this.color;
	}
	
	protected boolean isForward(int from_y, int to_y) {
		
		int change_in_y = vertDistance(from_y, to_y);
		
		if (this.color == WHITE && change_in_y < 0) {
			return true;
		} else if (this.color == BLACK && change_in_y > 0) {
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
