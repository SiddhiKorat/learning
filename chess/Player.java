package chess;

public class Player {
	
	String name;
	Color color;
	
	
	public Player(String name, chess.Color color) {
		this.name = name;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	

}
