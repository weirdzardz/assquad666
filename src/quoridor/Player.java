package quoridor;

import java.util.LinkedList;

/**
 * Player reprensents an abstract Player in the Game: it can be a human, or an AI.
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Represents a Player, human or AI.</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>The variables that are common to all players are defined here (Pawn coordinates, name).</li>
 * <li>An abstract type() function is overridden in the specific extending classes to defines the type of Player this is:</li>
 * <li>Human or AI.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */

public abstract class Player {

	Point pawn;
	int goal;
	String name;
	int wall = 10;
	String level;
	LinkedList<Point> positions = new LinkedList<Point>();
	
	/**
	 * A Point representing the coordinates of the Pawn of a Player.
	 * @return A Point representing the coordinates of the Pawn of a Player.
	 */
	public Point pawn(){
		return this.pawn;
	}
	
	/**
	 * A String, the name of a Player.
	 * @return A String, the name of a Player.
	 */
	public String name(){
		return this.name;
	}
	
	/**
	 * The list of positions the player had during the game.
	 * @return the list of positions the player had during the game
	 */
	public LinkedList<Point> positions(){
		return this.positions;
	}
	/**
	 * A String, the type of Player this is.
	 * @return A String, the type of Player this is.
	 */
	public abstract String type();
	
	/**
	 * Represents the number of walls left a player can place.
	 * @return the number of walls left a player can place
	 */
	public int wallsLeft() {
		return wall;
	}
	
	/**
	 * Remove a wall from the player's stack because it has been placed.
	 */
	public void deductWall() {
		wall--;
	}
	
	/**
	 * An integer, the straight line distance from the goal zone
	 * @return An integer, the straight line distance from the goal zone
	 */
	public int goalDistance() {
		return Math.abs(goal - pawn.y());
	}
	
	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	public int goal() {
		return goal;
	}

	/**
	 * The level of an AI player.
	 * @return the level of an AI player.
	 */
	public abstract String level();
	
	
}
