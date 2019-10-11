package app;

import java.util.Scanner;

public class Board {
	
	private final static int MAX_ROWS = 8;
	private final static int MAX_COLLUMNS = 8;
	private final static boolean WHITE = true;
	private final static boolean BLACK = false;
	private final static int MIN_X = 0;
	private final static int MIN_Y = 0; 

	private Piece board[][] = new Piece[MAX_ROWS][MAX_COLLUMNS];
	
	public void clearBoard() {
		this.board = new Piece[MAX_ROWS][MAX_COLLUMNS];
	}
	
	public boolean place(Piece p, int x, int y) {
		boolean placed = false;
		if (validCoords(x, y)
			&& !isOccupied(x, y)) {
			board[y][x] = p;
			placed = true;
		}
		return placed;
	}
	
	public boolean remove(int x, int y) {
		boolean removed = false;
		if (validCoords(x, y)
			&& isOccupied(x, y)) {
			board[y][x] = null;
			removed = true;
		}
			return removed;
	}
	
	public boolean move(boolean player_color, int from_x, int from_y, int to_x, int to_y) {
		Piece selected_piece = this.getPiece(from_x, from_y);
		
		if (validCoords(to_x, to_y)
			&& selected_piece != null
			&& selected_piece.getColor() == player_color
			&& selected_piece.canMove(this, from_x, from_y, to_x, to_y)) {
			remove(from_x, from_y);
			if (isOccupied(to_x, to_y)) {
				remove(to_x, to_y);
			}
			return place(selected_piece, to_x, to_y);
		}
		
		return false;
	}
	
	public Piece getPiece(int x, int y) {
		if (validCoords(x, y)
			&& isOccupied(x, y)) {
			return board[y][x].clonePiece();
		} else {
			return null;
		}
	}
	
	private boolean isOccupied(int x, int y) {
		boolean occupied = false;
		if (this.board[y][x] != null) {
			occupied = true;
		}
		return occupied;
	}
	
	private boolean validCoords(int x, int y) {
		boolean valid = false;
		if (x >= MIN_X
			&& x < MAX_COLLUMNS
			&& y >= MIN_Y
			&& y < MAX_ROWS) {
			valid = true;
		}
		return valid;
	}
	
	public void printBoard() {
		String collumn_nums = "    ";
		String square_divider = "  +";
		
		for (int i = 0; i < MAX_COLLUMNS; i+=1) {
			collumn_nums += Integer.toString(i);
			collumn_nums += "   ";
			square_divider += "---+";
		}
		System.out.println(collumn_nums);
		System.out.println(square_divider);
		
		for (int row = 0; row < MAX_ROWS; row+=1) {
			System.out.print(Integer.toString(row) + " |");
			for (int collumn = 0; collumn < MAX_COLLUMNS; collumn+=1) {
				if (this.board[row][collumn] != null) {
					System.out.print(" " + this.board[row][collumn].getSymbol() + " |");
				} else {
					System.out.print("   |");
				}
			}
			System.out.println("\n" + square_divider);
		}
	}
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean curr_player = WHITE;
		String input;
		String coords[];
		int from_x;
		int from_y;
		int to_x;
		int to_y;
		Board b1 = initBoard();
		Piece target;
	
		do {
			b1.printBoard();
			printInputPrompt(curr_player);
			input = keyboard.nextLine();
			input = input.replaceAll("\\s+", "");
			coords = input.split(",");
			from_x = Integer.parseInt(coords[0]);
			from_y = Integer.parseInt(coords[1]);
			System.out.println("Select the destination coordinates correct board: ");
			input = keyboard.nextLine();
			input = input.replaceAll("\\s+", "");
			coords = input.split(",");
			to_x = Integer.parseInt(coords[0]);
			to_y = Integer.parseInt(coords[1]);
			target = b1.getPiece(to_x, to_y);
			if (target != null
				&& (target.getSymbol() == 'k' || target.getSymbol() == 'K')
				&& b1.move(curr_player, from_x, from_y, to_x, to_y)) {
				System.out.println("Congratulations, you have won!");
				coords[0] = "-1";
				coords[1] = "-1";
			} else if (b1.move(curr_player, from_x, from_y, to_x, to_y)) {
				curr_player = !curr_player;
			} else {
				System.out.println("Incorrect piece/destination coordinates selected, please try again.");
			}
		} while (!coords[0].equals("-1")
				&& !coords[1].equals("-1"));
		
	}
	
	private static Board initBoard() {
		Board b = new Board();
		Piece init_pieces_b[] = {
			new Rook(BLACK),
			new Knight(BLACK),
			new Bishop(BLACK),
			new King(BLACK),
			new Queen(BLACK),
			new Bishop(BLACK),
			new Knight(BLACK),
			new Rook(BLACK)
		};
		
		Piece init_pieces_w[] = {
				new Rook(WHITE),
				new Knight(WHITE),
				new Bishop(WHITE),
				new King(WHITE),
				new Queen(WHITE),
				new Bishop(WHITE),
				new Knight(WHITE),
				new Rook(WHITE)
			};
		
		for (int i = 0; i < MAX_COLLUMNS; i+=1) {
			b.place(init_pieces_b[i], i, 0);
			b.place(init_pieces_w[i], i, MAX_ROWS - 1);
			b.place(new Pawn(BLACK), i, 1);
			b.place(new Pawn(WHITE), i, MAX_ROWS - 2);
		}
		
		return b;
	}
	
	private static void printInputPrompt(boolean _player) {
		String player;
		if (_player) {
			player = "Player White";
		} else {
			player = "Player Black";
		}
		
		System.out.println("\n You are " + player + 
				" select the piece you wish to move: ");
	}
	

}
