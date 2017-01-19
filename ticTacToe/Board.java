package ticTacToe;

public class Board {
	Cell board[][];
	
	Board(int size){
		board=new Cell[size][size];
		intializeBoard();
		
		
	}
	
	public void intializeBoard(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				board[i][j]=new Cell(i,j);
				board[i][j].setSymbol(null);
			}
		}
		printBoard();
	}
	public void printBoard(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				if(board[i][j].getSymbol()==null){
					System.out.print("---|");
				}else{
					System.out.print(" "+board[i][j].getSymbol()+" |");
				}
			}
			System.out.println();
		}
	}

	public Cell[][] getBoard() {
		return board;
	}

	public void setBoard(Cell[][] board) {
		this.board = board;
	}
	public Cell getcell(int x,int y){
		return board[x][y];
	}

}
