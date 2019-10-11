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
		int change_in_x_abs = Math.abs(change_in_x);
		int change_in_y = vertDistance(from_y, to_y);
		int change_in_y_abs = Math.abs(change_in_y);
		int next_x = from_x;
		int next_y = from_y;
		
		if (change_in_x == 0 && change_in_y != 0 ) {
			while (change_in_y_abs > 0) {
				if (change_in_y > 0) {
					next_y += 1;
				} else if (change_in_y < 0) {
					next_y -= 1;
				}
				if (next_x == to_x && next_y == to_y) {
					return true;
				} else if (b.getPiece(next_x, next_y) != null) {
					return false;
				} 
				change_in_y_abs -= 1;
			}
		} else if (change_in_x != 0 && change_in_y == 0 ) {
			while (change_in_x_abs > 0) {
				if (change_in_x > 0) {
					next_x += 1;
				} else if (change_in_x < 0) {
					next_x -= 1;
				}
				if (next_x == to_x && next_y == to_y) {
					return true;
				} else if (b.getPiece(next_x, next_y) != null) {
					return false;
				} 
				change_in_x_abs -= 1;
			}
		} else if (change_in_x == change_in_y ) {
			while (change_in_y_abs > 0) {
				if (change_in_y > 0) {
					next_y += 1;
				} else if (change_in_y < 0) {
					next_y -= 1;
				}
				if (change_in_x > 0) {
					next_x += 1;
				} else if (change_in_x < 0) {
					next_x -= 1;
				}
				if (next_x == to_x && next_y == to_y) {
					return true;
				} else if (b.getPiece(next_x, next_y) != null) {
					return false;
				} 
				change_in_y_abs -= 1;
			}
		}
		return true;
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
