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

	// TODO complete this class using your project code
	// you must implement the no-arg constructor and the check method
	
	// you may add extra fields and methods to this class
	// but the ProvidedTests code will only call the specified methods
	
	Game game;
	Player tempPl1 = new Human("Player 1");
	Player tempPl2 = new Human("Player 2");
	
	public Validator (Game game) {
		if (game == null){
			game = new Game(Two.two(tempPl1, tempPl2));
		} else{
			this.game = game;
		}
	}
	
	
	/**
	 * Check the validity of a move in a particular game state stored in this Validator.
	 * @param move the move to be checked for validity
	 * @return validity of this move.
	 */
	public boolean checkMove(Move move, Player p){
		//TODO
		return isValidJump(move, p) || isValidWallPlace(move) || (isAdjacent(move, p) && isNotBlocked(move,p));
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
	public boolean checkList(LinkedList<Move> moves){
		//TODO
		return false;
	}

	

	
	/**
	 * Checks if a wall placement is valid or not.
	 * @param move A move (wall placement) to be checked for validity.
	 * @return True if this wall placement is valid according to Game state, False if not.
	 */
	public boolean isValidWallPlace(Move move){
		if(move.direction() != move.PAWN){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checks if a pawn move is a valid jump move.
	 * @param move A move to be checked for validity.
	 * @return True if this move is a valid jump, False if not.
	 */
	public boolean isValidJump(Move move, Player p){
		return false;
	}
	
	
	
	/**
	 * Checks if a Pawn move is adjacent to its previous position.
	 * @param move A move to be checked for validity.
	 * @return True if this move is adjacent to pawn's previous position, False if not.
	 */
	public boolean isAdjacent(Move move, Player p){
		boolean isAdjLetter = Math.abs(move.coord().let() - p.pawn().let()) == 1;
		boolean isSameLetter = move.coord().let() == p.pawn().let();
		boolean isAdjNumber = Math.abs(move.coord().num() - p.pawn().num()) == 1;
		boolean isSameNumber = move.coord().num() == p.pawn().num();
		
		return  (isAdjLetter && isSameNumber) || (isSameLetter && isAdjNumber) ;
	}
	
	
	/**
	 * Checks whether a pawn can't make a move because there is a wall in between previous and wanted position.
	 * It assumes the move is adjacent because it is used in combination ("&&") with isAdjacent anyway.
	 * @param move the move to be made
	 * @param p the player making the move
	 * @return true if path is clear, false if there is a wall
	 */
	private boolean isNotBlocked(Move move, Player p) {
		if(move.coord().let() - p.pawn().let() == 1 && game.isWallAt(move.coord().let(), move.coord().num(), game.VERTICAL)){
			return false;
		} else if (move.coord().let() - p.pawn().let() == -1 && game.isWallAt(p.pawn().let(), move.coord().num(), game.VERTICAL)) {
			return false;
		} else if (move.coord().num() - p.pawn().num() == 1 && game.isWallAt(move.coord().let(), move.coord().num(), game.HORIZONTAL)) {
			return false;
		} else if (move.coord().num() - p.pawn().num() == -1 && game.isWallAt(move.coord().let(), p.pawn().num(), game.VERTICAL)) {
			return false;
		} else {
			return true;
		}
	}
	
	
	
	public boolean check(String string){
		return false;
	}
	
	



}