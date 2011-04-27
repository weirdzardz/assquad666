package assquad666.quoridor;


public class Point {

	
	public int x, y;

	public Point()
	{
		x = 0;
		y = 0;
	}

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public Point(Point point)
	{
		x = point.x;
		y = point.y;
	}

	public Point subtract(Point vec)
	{
		return new Point(x-vec.x, y-vec.y);
	}

	public Point add(int dx, int dy)
	{
		return new Point(x+dx, y+dy);
	}
	
	public void set(Point p)
	{
		x = p.x;
		y = p.y;
	}

	@Override
	public String toString()
	{
		return "{x="+x+", y="+y+"}";
	}

	public Point add(Point d)
	{
		return new Point(x+d.x, y+d.y);
	}
}
