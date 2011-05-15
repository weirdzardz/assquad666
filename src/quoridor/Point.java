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
	public int let(){
		return this.x;
	}
	
	/**
	 * The number coordinate of this Point.
	 * @return The number coordinate of this Point.
	 */
	public int num(){
		return this.y;
	}
	
	//not really useful
	@Override
	public String toString()
	{
		return "{x="+x+", y="+y+"}";
	}
}
