package assquad666.quoridor;


public class Point {

	
	public int x, y;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}


	
	public int let(){
		return this.x;
	}
	
	public int num(){
		return this.y;
	}
	
	@Override
	public String toString()
	{
		return "{x="+x+", y="+y+"}";
	}
}
