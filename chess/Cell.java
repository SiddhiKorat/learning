package chess;

public class Cell {
	private Ipiece piece;
	private Color color;
	int row, col;
	
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	public Ipiece getPiece() {
		return piece;
	}

	
	public void setPiece(Ipiece piece) {
		this.piece = piece;
	}
}
