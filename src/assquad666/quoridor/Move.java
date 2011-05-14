package assquad666.quoridor;

/**
 * Move is in charge of storing moves informations(coordinates, if it's a wall, it's direction). 
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Stores moves informations.</li>
 * <li>Gives moves as a String, so that it can be used to save the game as a sequence of moves.</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>A move has coordinates, stored as a Point.</li>
 * <li>A move has a direction, used for wall directions, and equal to 0 in the case of a pawn movement.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */

public class Move {

	
	//Different moves informations
	final int PAWN = 0;
	final int HORIZONTAL = 1;
	final int VERTICAL = 2;
	
	int direction;
	Point coord;	
	
	/** 
	 * Constructor. Stores move informations.
	 * @param x the letter coordinate.
	 * @param y the number coordinate.
	 * @param dir the direction of the wall, or 0 for pawn movement.
	 */
	public Move(int x, int y, int dir){
		this.coord = new Point(x,y);
		this.direction = dir;
	}
	
	
	/**
	 * The direction of the wall, or 0 for pawn movement.
	 * @return The direction of the wall, or no direction (0) for pawn movemement.
	 */
	public int direction(){
		return direction;
	}
	
	/**
	 * The Point representing the coordinates of the move.
	 * @return The Point representing the coordinates of the move.
	 */
	public Point coord(){
		return coord;
	}
	
	@Override
	public String toString() {
		String line = "";
		char c = 'a';
		c += this.coord.let();
		line += c;
		line += this.coord.num();
		if (direction == HORIZONTAL)
			line += "h";
		else if (direction == VERTICAL)
			line += "v";
		return line;
	}
	
}
