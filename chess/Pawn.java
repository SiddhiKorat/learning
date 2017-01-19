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
public class Pawn extends Ipiece {
     public Pawn(Color color) {
        this.color=color;
        this.name=color.toString().substring(0,1)+"P";
    }
    public boolean isValidMove(Board board,Cell from,Cell to){
    	
    	if(from==null || to==null || board== null){
    		return false;
    	}
    	if(from.getRow()>7 || from.getRow()<0 || from.getCol()>7 || from.getCol()<0 
    			|| to.getRow()>7|| to.getRow()<0 || to.getCol()>7 || to.getCol()<0)
    	{
    		return false;
    	}
    	if(from.getPiece().getColor()==chess.Color.Black){
    		if(to.getRow()-from.getRow()>2){
    			return false;
    		}else 
    			if(to.getRow()-from.getRow()==2 && from.getRow()==1 && to.getCol()==from.getCol()){
    				return true;
    				
    			}else
    				if(to.getRow()-from.getRow()==1 && to.getCol()==from.getCol())
    				{
    					return true;
    				}else
    					if(to.getRow()-from.getRow()==1 && to.getPiece()!=null && to.getPiece().getColor()!=from.getPiece().getColor()){
    						return true;
    					}
    				
    	}else
    		if(from.getPiece().getColor()==chess.Color.White){
    			if(from.getRow()-to.getRow()>2){
    				return false;
    			}else
    			if(from.getRow()-to.getRow()==2 && from.getRow()==6 && to.getCol()==from.getCol()){
    				return true;
    			}else
    				if(from.getRow()-to.getRow()==1 && to.getCol()==from.getCol()){
    					return true;
    				}else
    					if(from.getRow()-to.getRow()==1 && to.getPiece()!=null && to.getPiece().getColor()!=from.getPiece().getColor()){
    						return true;
    					}
    			
    		}
    	return false;
    	    }
    
}
