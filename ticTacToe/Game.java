package ticTacToe;

import java.util.*;

public class Game {
	List<Player> players = new ArrayList<>();
	Player currentPlayer;
	Scanner scanner;
	Board board;
	Player player1;
	Player player2;

	Game() {
		intializeGame();
	}

	private void intializeGame() {
		// TODO Auto-generated method stub
		board = new Board(3);
		startGame();
	}

	private void startGame() {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		System.out.println("Enter the name of player1:");
		player1 = new Player(scanner.nextLine());
		System.out.println("Enter the name of player2:");
		player2 = new Player(scanner.nextLine());
		System.out.println(player1.getName() + " is leading o.");
		System.out.println(player2.getName() + " is leading x.");
		players.add(player1);
		player1.setSymbol(Symbols.o);
		player2.setSymbol(Symbols.x);
		players.add(player2);
		currentPlayer = player1;
		move(board);
	}

	private void move(Board board) {
		// TODO Auto-generated method stub
		if (isPlayerWin(board)) {
			if (currentPlayer.getSymbol() == Symbols.o) {
				System.out.println(players.get(1).getName() + " win..");
			} else {
				System.out.println(players.get(0).getName() + " win..");
			}
			// System.exit(0);
			System.out.println("Do you want to play again? y or n");
			if (scanner.next().equals("y")) {
				intializeGame();
			} else {
				System.exit(0);
			}
		}
		if (isGameOver(board)) {
			System.out.println("Game Over");
			System.out.println("Do you want to play again? y or n");
			if (scanner.next().equals("y")) {
				intializeGame();
			} else {
				System.exit(0);
			}
			// System.exit(0);
		}
		System.out.println(currentPlayer.getName() + " is playing");
		System.out.println("select the cell in x y manner");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		if ((x >= 0 && x <= 2) && (y >= 0 && y <= 2)) {
			if (board.getcell(x, y).getSymbol() == null) {
				board.getcell(x, y).setSymbol(currentPlayer.getSymbol());
				changePlayer();
			} else {
				System.out.println("select empty cell");
			}
		} else {
			System.out.println("enter valid cell");
		}
		board.printBoard();
		move(board);
	}

	private boolean isGameOver(Board board) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board.getcell(i, j).getSymbol() == null) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isPlayerWin(Board board) {
		// TODO Auto-generated method stub
		boolean isWinner = false;
		for (int i = 0; i < 3; i++) {
			int j = 0;
			if (board.getcell(i, j).getSymbol() != null
					&& board.getcell(i, j).getSymbol() == board.getcell(i, j + 1).getSymbol()
					&& board.getcell(i, j + 1).getSymbol() == board.getcell(i, j + 2).getSymbol()) {
				isWinner = true;
			}
		}
		for (int j = 0; j < 3; j++) {
			int i = 0;
			if (board.getcell(i, j).getSymbol() != null
					&& board.getcell(i, j).getSymbol() == board.getcell(i + 1, j).getSymbol()
					&& board.getcell(i + 1, j).getSymbol() == board.getcell(i + 2, j).getSymbol()) {
				isWinner = true;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0 && j == 0) {
					if (board.getcell(i, j).getSymbol() != null
							&& board.getcell(i, j).getSymbol() == board.getcell(i + 1, j + 1).getSymbol()
							&& board.getcell(i + 1, j + 1).getSymbol() == board.getcell(i + 2, j + 2).getSymbol()) {
						isWinner = true;
					}
				}
				if (i == 0 && j == 2) {
					if (board.getcell(i, j).getSymbol() != null
							&& board.getcell(i, j).getSymbol() == board.getcell(i + 1, j - 1).getSymbol()
							&& board.getcell(i + 1, j - 1).getSymbol() == board.getcell(i + 2, j - 2).getSymbol()) {
						isWinner = true;
					}
				}
			}
		}

		return isWinner;
	}

	private void changePlayer() {
		// TODO Auto-generated method stub
		if (currentPlayer.getSymbol() == Symbols.o) {

			currentPlayer = players.get(1);
		} else {
			currentPlayer = players.get(0);
		}

	}
}
