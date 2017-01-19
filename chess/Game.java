package chess;

import java.util.*;

public class Game {
	List<Player> players = new ArrayList<>();
	Player currentPlayer;
	Board board;
	private Scanner scanner;

	public int whiteKingColIndex = 3, whiteKingRowIndex = 7;
	public int blackKingColIndex = 3, blackKingRowIndex = 0;

	public Game() {
		initializeGame();
	}

	private void initializeGame() {
		board = new Board(8);
		startGame();

	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void nextMove(Board board) {

		if (isGameOver(board)) {
			System.out.println(currentPlayer.getName() + " lost...");
			if (currentPlayer.getColor() == Color.Black) {
				System.out.println(players.get(1).getName() + " win...");

			} else {
				System.out.println(players.get(0).getName() + " win...");
			}
			System.out.println("Game Over");
			System.exit(0);
		}

		System.out.println(currentPlayer.getName() + " is playing..");
		System.out.println("select source and destination {x1 y1 x2 y2}");

		int x1, x2, y1, y2;

		x1 = scanner.nextInt();
		y1 = scanner.nextInt();
		x2 = scanner.nextInt();
		y2 = scanner.nextInt();
		Ipiece selectedPiece = board.getCell(x1, y1).getPiece();

		// to track the position of white or black king when it moves
		if (selectedPiece != null) {
			if (selectedPiece instanceof King) {
				if (selectedPiece.isValidMove(board, board.getCell(x1, y1), board.getCell(x2, y2))) {
					if (currentPlayer.getColor() == Color.Black) {
						blackKingRowIndex = x2;
						blackKingColIndex = y2;
					} else {
						whiteKingRowIndex = x2;
						whiteKingColIndex = y2;
					}
				}
			}
		}

		// to check if the king is under Threat or not ( Check )
		if (selectedPiece != null && currentPlayer.getColor() == selectedPiece.getColor()) {
			if (!isKingUnderCheck()) {
				if (selectedPiece.move(board, board.getCell(x1, y1), board.getCell(x2, y2))) {

					changePlayer();

				} else {
					System.out.println("Invalid move");
					// nextMove(board);
				}
			} else if (selectedPiece instanceof King) {
				// if king is under check or threat , only king is allowed to
				// move

				if (selectedPiece.move(board, board.getCell(x1, y1), board.getCell(x2, y2))) {

					changePlayer();
					// change player
				} else {
					System.out.println("Invalid move");
					// nextMove(board);
				}

			}
		} else {
			System.out.println("select valid piece");

		}
		board.printboard();
		nextMove(board);
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public void changePlayer() {

		if (currentPlayer.getColor() == Color.Black)
			currentPlayer = players.get(1);
		else
			currentPlayer = players.get(0);

	}

	public void startGame() {
		scanner = new Scanner(System.in);
		System.out.println("enter the name of player1:");
		Player player1 = new Player(scanner.nextLine(), Color.Black);
		System.out.println("enter the name of player2:");
		Player player2 = new Player(scanner.nextLine(), Color.White);
		players.add(player1);
		players.add(player2);
		currentPlayer = player1;
		nextMove(board);
	}

	public boolean isKingUnderCheck() {
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (board.getCell(i, j).getPiece() != null) {
					if (board.getCell(i, j).getPiece().getColor() != currentPlayer.getColor()) {
						Cell kingCell;
						if (currentPlayer.getColor() == Color.Black) {

							kingCell = board.getCell(blackKingRowIndex, blackKingColIndex);
						} else
							kingCell = board.getCell(whiteKingRowIndex, whiteKingColIndex);
						if (board.getCell(i, j).getPiece().isValidMove(board, board.getCell(i, j), kingCell)) {
							return true;
						}

					}
				}
			}

		}
		return false;

	}

	public boolean isKingUnderCheck(Cell kingCell) {
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (board.getCell(i, j).getPiece() != null) {
					if (board.getCell(i, j).getPiece().getColor() != currentPlayer.getColor()) {

						if (board.getCell(i, j).getPiece().isValidMove(board, board.getCell(i, j), kingCell)) {
							return true;
						}

					}
				}
			}

		}
		return false;

	}

	public boolean isGameOver(Board board) {
		if (isKingUnderCheck()) {
			Cell kingCell;
			if (currentPlayer.getColor() == Color.Black) {
				kingCell = board.getCell(blackKingRowIndex, blackKingColIndex);
			} else {
				kingCell = board.getCell(whiteKingRowIndex, whiteKingColIndex);
			}
			boolean a, b, c, d, e, f, g, h;
			if (kingCell.getRow() != 7) {
				a = isKingUnderCheck(board.getCell(kingCell.getRow() + 1, kingCell.getCol()));
			} else {
				a = true;
			}
			if (kingCell.getRow() != 7 && kingCell.getCol() != 7) {
				b = isKingUnderCheck(board.getCell(kingCell.getRow() + 1, kingCell.getCol() + 1));
			} else {
				b = true;
			}
			if (kingCell.getCol() != 7) {
				c = isKingUnderCheck(board.getCell(kingCell.getRow(), kingCell.getCol() + 1));
			} else {
				c = true;
			}
			if (kingCell.getRow() != 0) {
				d = isKingUnderCheck(board.getCell(kingCell.getRow() - 1, kingCell.getCol()));
			} else {
				d = true;
			}
			if (kingCell.getRow() != 0 && kingCell.getCol() != 0) {
				e = isKingUnderCheck(board.getCell(kingCell.getRow() - 1, kingCell.getCol() - 1));
			} else {
				e = true;
			}
			if (kingCell.getCol() != 0) {
				f = isKingUnderCheck(board.getCell(kingCell.getRow(), kingCell.getCol() - 1));
			} else {
				f = true;
			}
			if (kingCell.getRow() != 7 && kingCell.getCol() != 0) {
				g = isKingUnderCheck(board.getCell(kingCell.getRow() + 1, kingCell.getCol() - 1));
			} else {
				g = true;
			}
			if (kingCell.getRow() != 0 && kingCell.getCol() != 7) {
				h = isKingUnderCheck(board.getCell(kingCell.getRow() - 1, kingCell.getCol() + 1));
			} else {
				h = true;
			}
			if (a && b && b && c && d && e && f && g && h) {
				return true;
			}

			return false;
		}

		return false;
	}
}
