package chess;

public class Board {

	private Cell board[][];

	public Cell[][] getBoard() {
		return board;
	}

	public void setBoard(Cell[][] board) {
		this.board = board;
	}

	Board(int size) {
		board = new Cell[size][size];
		initializeGame();
	}

	private void initializeGame() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = new Cell(i, j);
			}
		}
		intializedefaultpieceArangement();
		printboard();
	}

	public void printboard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j].getPiece() == null) {
					System.out.print("--|");
				} else {

					System.out.print(board[i][j].getPiece().getName() + "|");
				}

			}
			System.out.println();
		}

	}

	private void intializedefaultpieceArangement() {
		board[0][0].setPiece(new Rook(Color.Black));
		board[0][7].setPiece(new Rook(Color.Black));
		board[0][1].setPiece(new Horse(Color.Black));
		board[0][6].setPiece(new Horse(Color.Black));
		board[0][2].setPiece(new Bishop(Color.Black));
		board[0][5].setPiece(new Bishop(Color.Black));
		board[0][3].setPiece(new King(Color.Black));
		board[0][4].setPiece(new Queen(Color.Black));

		board[7][0].setPiece(new Rook(Color.White));
		board[7][7].setPiece(new Rook(Color.White));
		board[7][1].setPiece(new Horse(Color.White));
		board[7][6].setPiece(new Horse(Color.White));
		board[7][2].setPiece(new Bishop(Color.White));
		board[7][5].setPiece(new Bishop(Color.White));
		board[7][3].setPiece(new King(Color.White));
		board[7][4].setPiece(new Queen(Color.White));

		for (int i = 0; i < 8; i++) {
			board[1][i].setPiece(new Pawn(Color.Black));
			board[6][i].setPiece(new Pawn(Color.White));
		}

	}

	public Cell getCell(int x, int y) {
		return board[x][y];
	}
}
