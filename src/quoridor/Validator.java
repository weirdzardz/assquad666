package quoridor;

import java.util.LinkedList;
import util.Two;

/**
 * Validator is in charge of deciding if a move or a serie of moves is valid according to the games' rules. 
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Given a move and a Game state, or a serie of moves, decides if it is Valid or not.</li>
 * <li>Storing a command.</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>To do. Was half implemented during lab10, but conditions and arguments changed since then.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */

public class Validator {

	
	Game game;
	Player tempPl1 = new Human("Player 1");
	Player tempPl2 = new Human("Player 2");
	
	public Validator () {
		game = new Game(Two.two(tempPl1, tempPl2));
		game.initGame(null);
	}
	
	/**
	 * Check the validity of a given sequence of moves.
	 * The sequence is valid if and only if each (space separated)
	 * move in the list is valid,
	 * starting from the initial position of the game.
	 * When the game has been won, no further moves are valid.
	 * // TODO@param moves a list of successive moves
	 * @return validity of the list of moves
	 */
	public boolean check(LinkedList<Move> moves){
		for(Move move: moves){
			//System.out.println(move.toString());

			if(!game.isValid(move, game.myTurn)){
				return false;
			}
			game.move(move, game.myTurn);
		}
		return true;
	}

	public boolean check(String string){
		return false;
	}
	

}