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
public class King extends Ipiece {
	public King(Color color) {
		this.color = color;
		this.name = color.toString().substring(0, 1) + "K";
	}

	public boolean isValidMove(Board board, Cell from, Cell to) {
		if (from == null || to == null || board == null) {
			return false;
		}
		if (from.getRow() > 7 || from.getRow() < 0 || from.getCol() > 7 || from.getCol() < 0 || to.getRow() > 7
				|| to.getRow() < 0 || to.getCol() > 7 || to.getCol() < 0) {
			return false;
		}
		if (to.getPiece() == null || !to.getPiece().getColor().equals(from.getPiece().getColor())) {
			if (Math.abs(from.getRow() - to.getRow()) > 1 || Math.abs(from.getCol() - to.getCol()) > 1)
				return false;
			else {
				return true;
			}
		} else
			return false;
	}

}
