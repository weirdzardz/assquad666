package quoridor;

/**
 * Point is in charge of storing the coordinates of a square on the board. 
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Stores coordinates of a squares on the board</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>x represents a letter (but is a number) on the board letter axis.</li>
 * <li>y represents a number on the board number axis.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */

public class Point {

	
	public int x, y;

	/**
	 * Constructor, stores the coordinates.
	 * @param x the letter coordinate
	 * @param y the number coordinate
	 */
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}


	
	/**
	 * The letter coordinate of this Point.
	 * @return The letter coordinate of this Point.
	 */
	public int x(){
		return this.x;
	}
	
	/**
	 * The number coordinate of this Point.
	 * @return The number coordinate of this Point.
	 */
	public int y(){
		return this.y;
	}
	
	//not really useful
	@Override
	public String toString()
	{
		return "{x="+x+", y="+y+"}";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
