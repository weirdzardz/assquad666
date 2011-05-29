package quoridor;

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

	public enum MoveType {PAWN, HORIZONTAL, VERTICAL};



	MoveType direction;
	Point coord;	

	/** 
	 * Constructor. Stores move informations.
	 * @param x the letter coordinate.
	 * @param y the number coordinate.
	 * @param dir the direction of the wall, or 0 for pawn movement.
	 */
	public Move(int x, int y, MoveType dir){
		this.coord = new Point(x,y);
		this.direction = dir;
	}


	/**
	 * The direction of the wall, or 0 for pawn movement.
	 * @return The direction of the wall, or no direction (0) for pawn movemement.
	 */
	public MoveType direction(){
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
		c += this.coord.x();
		line += c;
		line += this.coord.y();
		if (direction == MoveType.HORIZONTAL)
			line += "h";
		else if (direction == MoveType.VERTICAL)
			line += "v";
		return line;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coord == null) ? 0 : coord.hashCode());
		result = prime * result
		+ ((direction == null) ? 0 : direction.hashCode());
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
		Move other = (Move) obj;
		if (coord == null) {
			if (other.coord != null)
				return false;
		} else if (!coord.equals(other.coord))
			return false;
		if (direction != other.direction)
			return false;
		return true;
	}

}
