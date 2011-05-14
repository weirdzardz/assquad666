package assquad666.quoridor;

public class Wall {
	
	
	//position and direction
	//example e2h: the wall starts at the top left corner of the e2 square, and goes horizontally to the right for two squares
	public Point pos;
	public int dir;
	
	public Wall(Point pos, int dir){
		this.pos = pos;
		this.dir = dir;
	}
	
	public Point pos(){
		return this.pos;
	}
	
	public int dir(){
		return this.dir;
	}
	
}
