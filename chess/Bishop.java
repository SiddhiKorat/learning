
package chess;

public class Bishop extends Ipiece {
	public Bishop(Color color) {
		this.color = color;
		this.name = color.toString().substring(0, 1) + "B";
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean isValidMove(Board board, Cell from, Cell to) {
		if (to == null || from == null || board == null) {
			return false;
		}
		if (to.getCol() > 7 || to.getCol() < 0 || to.getRow() > 7 || to.getRow() < 0 || from.getCol() > 7
				|| from.getCol() < 0 || from.getRow() > 7 || from.getRow() < 0) {

			return false;
		}

		if(from.getPiece()!=null){

			if (to.getRow() < from.getRow() && to.getCol() < from.getCol()
					&& (to.getCol() - to.getRow() == from.getCol() - from.getRow())) {
				for (int i = to.getRow() + 1; i < from.getRow(); i++) {
					for (int j = to.getCol() + 1; j < from.getCol(); j++) {
						if (to.getCol() - to.getRow() == j - i) {
							if (board.getCell(i, j).getPiece() != null) {
								return false;
							}
						}
					}
				}
				return true;
			} else if (to.getRow() > from.getRow() && to.getCol() > from.col
					&& (to.getCol() - to.getRow() == from.getCol() - from.getRow())) {
				for (int i = from.getRow() + 1; i < to.getRow(); i++) {
					for (int j = from.getCol() + 1; j < to.getCol(); j++) {
						if (to.getCol() - to.getRow() == j - i) {
							if (board.getCell(i, j).getPiece() != null) {
								return false;
							}
						}
					}
				}
				return true;
			} else if (to.getRow() < from.getRow() && to.getCol() > from.getCol()
					&& (to.getCol() + to.getRow() == from.getCol() + from.getRow())) {
				for (int i = to.getRow() + 1; i < from.getRow(); i++) {
					for (int j = from.getCol() + 1; j < to.getCol(); j++) {
						if (to.getCol() + to.getRow() == j + i) {
							if (board.getCell(i, j).getPiece() != null) {
								return false;
							}
						}
					}
				}
				return true;
			} else if (to.getRow() > from.getRow() && to.getCol() < from.getCol()
					&& (to.getRow() + to.getCol() == from.getRow() + from.getCol())) {
				for (int i = from.getRow() + 1; i < to.getRow(); i++) {
					for (int j = to.getCol() + 1; j < from.getCol(); j++) {
						if (to.getCol() + to.getRow() == j + i) {
							if (board.getCell(i, j).getPiece() != null) {
								return false;
							}
						}
					}
				}
				return true;
			}
		}

		return false;
	}
}
