package assquad666.quoridor;

public class Move {

	
	//Different moves informations
	final int PAWN = 0;
	final int HORIZONTAL = 1;
	final int VERTICAL = 2;
	
	int direction;
	Point coord;	
	
	public Move(int x, int y, int dir){
		this.coord = new Point(x,y);
		this.direction = dir;
	}
	
	
	public int direction(){
		return direction;
	}
	
	public Point coord(){
		return coord;
	}
	
	@Override
	public String toString() {
		String line = "";
		char c = 'a';
		c += this.coord.let();
		line += c;
		line += this.coord.num();
		if (direction == HORIZONTAL)
			line += "h";
		else if (direction == VERTICAL)
			line += "v";
		return line;
	}
	
}
