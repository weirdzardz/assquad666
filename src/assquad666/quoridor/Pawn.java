package assquad666.quoridor;


public class Pawn {

	
	public int x, y;

	public Pawn(int x, int y)
	{
		this.x = x;
		this.y = y;
	}


	
	public int let(){
		return x;
	}
	
		public int num(){
		return y;
	}
	
	@Override
	public String toString()
	{
		return "{x="+x+", y="+y+"}";
	}
}
