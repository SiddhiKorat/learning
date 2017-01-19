package ticTacToe;

public class Cell {
	Symbols symbol;
	int row, col;

	//Cell() {}

	Cell(int row, int col) {
		this.col = col;
		this.row = row;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Symbols getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbols symbol) {
		this.symbol = symbol;
	}

}
