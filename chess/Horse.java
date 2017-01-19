
package chess;


public class Horse extends Ipiece{
        public Horse(Color color) {
        this.color=color;
        this.name=color.toString().substring(0,1)+"H";
        }
        public boolean isValidMove(Board board,Cell from,Cell to){
        	
        	if(from==null || to==null || board==null){
    		return false;
    	}
    	if(from.getRow()>7 || from.getRow()<0 || from.getCol()>7 || from.getCol()<0 
    			|| to.getRow()>7|| to.getRow()<0 || to.getCol()>7 || to.getCol()<0)
    	{
    		return false;
    	}
    	if((to.getPiece()!=null && !to.getPiece().getColor().equals(from.getPiece().getColor()))|| to.getPiece()==null){
    		if((Math.abs(to.getRow()-from.getRow())==2 && Math.abs(to.getCol()-from.getCol())==1)||
    				(Math.abs(to.getRow()-from.getRow())==1 && Math.abs(to.getCol()-from.getCol())==2))
    			return true;
    		else
    			return false;
    		
    		
    		
    	}
            return false;
        }
    
}
