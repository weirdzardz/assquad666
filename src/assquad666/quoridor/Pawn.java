package assquad666.quoridor;


public class Pawn {

	
	public int x, y;

	public Pawn()
	{
		x = 0;
		y = 0;
	}

	public Pawn(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Pawn(Pawn point)
	{
		x = point.x;
		y = point.y;
	}
	
	public void set(Pawn p)
	{
		x = p.x;
		y = p.y;
	}
	
	@Override
	public String toString()
	{
		return "{x="+x+", y="+y+"}";
	}
}
