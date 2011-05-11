package assquad666.quoridor;

public class Wall {
	
	
	//position and direction
	//example e2h: the wall starts at the top left corner of the e2 square, and goes horizontally to the right for two squares
	public int pos;
	public int dir;
	
	public Wall(int pos, int dir){
		this.pos = pos;
		this.dir = dir;
	}
	
	public int pos(){
		return this.pos;
	}
	
	public int dir(){
		return this.dir;
	}
	
}
