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

	public Pawn subtract(Pawn vec)
	{
		return new Pawn(x-vec.x, y-vec.y);
	}

	public Pawn add(int dx, int dy)
	{
		return new Pawn(x+dx, y+dy);
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

	public Pawn add(Pawn d)
	{
		return new Pawn(x+d.x, y+d.y);
	}
}
