package quoridor;

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
	
	public Validator () {
		// TODO
	}

	
	/**
	 * Checks if a wall placement is valid or not.
	 * @param move A move (wall placement) to be checked for validity.
	 * @return True if this wall placement is valid according to Game state, False if not.
	 */
	public boolean isValidWallPlace(Move move){
		
		return false;
	}
	
	/**
	 * Checks if a pawn move is a valid jump move.
	 * @param move A move to be checked for validity.
	 * @return True if this move is a valid jump, False if not.
	 */
	public boolean isValidJump(Move move){
		return false;
	}
	
	
	
	/**
	 * Checks if a Pawn move is adjacent to its previous position.
	 * @param move A move to be checked for validity.
	 * @return True if this move is adjacent to pawn's previous position, False if not.
	 */
	public boolean isAdjacent(Move move){
		
		return false;
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
	public boolean check (String moves) {
		assert moves != null;
		boolean valid = true;
		char c;
		char lastc = ' ';
		
		Game temp = new Game();
		
/*
		
		for (int i = 0; i < moves.length() && valid == true; i++) {
			c = moves.charAt (i);
			if (c != ' ') {
				if (Character.isLetter(c) && (c - 'a' < width)) {
					if (lastc != ' ') {
						valid = false;
					}
				} else if (Character.isDigit(c - 1) && c < height) {
					if (!Character.isLetter(lastc)) {
						valid = false;
					} else {
						if ((i < (moves.length() - 1)) && (moves.charAt(i+1) == 'h' || moves.charAt(i+1) == 'v')) {
							if (i % 2 == 0) {
							//	temp.placeWall(c,lastc - 'a', moves.charAt(i+1), temp.playerOne());
							} else {
							//	temp.placeWall(c,lastc - 'a', moves.charAt(i+1), temp.playerTwo());
							}
							i++;
						} else {
							if (i % 2 == 0) {
							//	temp.move(c,(lastc - 'a'), temp.playerOne());
							} else {
							//	temp.move(c,(lastc - 'a'), temp.playerTwo());
							}
						}
					//	valid = temp.valid();
						
					}
				} else {
					valid = false;
				}
			}
			lastc = c;
		}
	
		
		return valid ;*/
		return false;
	}

}