package assquad666.quoridor;

public class Validator {

	// TODO complete this class using your project code
	// you must implement the no-arg constructor and the check method
	
	// you may add extra fields and methods to this class
	// but the ProvidedTests code will only call the specified methods
	
	public Validator () {
		// TODO
	}

	public boolean isInBoard(String move){
		
		return false;
	}
	
	
	public boolean isAdjacent(String move){
		
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
		
		int width = temp.width();
		int height = temp.height();
		
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
	
		
		return valid ;
	}

}