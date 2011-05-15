package quoridor;

/**
 * Wall represents a wall in the Game.
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Represents a wall.</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>A wall is defined by two variables:</li>
 * <li>A Point which has coordinates, and represents a square in the game. The wall will start from the top left corner of this square.</li>
 * <li>A direction which specifies is the wall is going horizontally or vertically.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */

public class Wall {
	
	public Point pos;
	public int dir;
	
	
	/**
	 * Constructor. Creates a wall when called.
	 * @param pos The position from which the wall will be drawn (top left corner of the square having this position on the board).
	 * @param dir The direction of the wall (horizontal or vertical).
	 */
	public Wall(Point pos, int dir){
		this.pos = pos;
		this.dir = dir;
	}
	
	
	/**
	 * The position from which the wall will be drawn (top left corner of the square having this position on the board).
	 * @return The position from which the wall will be drawn (top left corner of the square having this position on the board).
	 */
	public Point pos(){
		return this.pos;
	}
	
	/**
	 * The direction of the wall (horizontal or vertical).
	 * @return The direction of the wall (horizontal or vertical).
	 */
	public int dir(){
		return this.dir;
	}
	
}
