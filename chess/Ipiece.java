package chess;

abstract class Ipiece {
    Color color;
    String name;
    
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
   
    public boolean move(Board board,Cell from,Cell to){
    	//System.out.println(isValidMove(board, from, to));
        if(isValidMove(board,from,to)){
            board.getCell(to.row,to.col).setPiece(board.getCell(from.row,from.col).getPiece());
            board.getCell(from.row,from.col).setPiece(null);
            return true;
        }
        return false;
       
    }
    public abstract boolean isValidMove(Board board,Cell from,Cell to);
    

}
