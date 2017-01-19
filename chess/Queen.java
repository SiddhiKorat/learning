/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author lenovo
 */
public class Queen extends Ipiece {
	public Queen(Color color) {
		this.color = color;
		this.name = color.toString().substring(0, 1) + "Q";
	}

	public boolean isValidMove(Board board, Cell from, Cell to) {
		if (from == null || to == null || board == null) {
			return false;
		}
		if (from.getRow() > 7 || from.getRow() < 0 || from.getCol() > 7 || from.getCol() < 0 || to.getRow() > 7
				|| to.getRow() < 0 || to.getCol() > 7 || to.getCol() < 0) {
			return false;
		}
		if (from.getPiece() != null
				&& (to.getPiece() == null || (!to.getPiece().getColor().equals(from.getPiece().getColor())))) {
			if (from.getRow() == to.getRow() || from.getCol() == to.getCol()) {
				if (from.getRow() == to.getRow()) {
					if (from.getCol() > to.getCol()) {
						for (int i = to.getCol() + 1; i < from.getCol(); i++) {
							if (board.getCell(from.getRow(), i).getPiece() != null) {
								return false;
							}
						}
						return true;
					} else {
						for (int i = from.getCol() + 1; i < to.getCol(); i++) {
							if (board.getCell(from.getRow(), i).getPiece() != null) {
								return false;
							}
						}
						return true;
					}
				} else {
					if (from.getRow() > to.getRow() + 1) {
						for (int i = to.getRow(); i < from.getRow(); i++) {
							if (board.getCell(i, from.getCol()).getPiece() != null) {
								return false;
							}
						}
						return true;
					} else {
						for (int i = from.getRow() + 1; i < to.getRow(); i++) {
							if (board.getCell(i, from.getCol()).getPiece() != null) {
								return false;
							}
						}
						return true;
					}

				}
			} else {

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
		return false;
	}

}
