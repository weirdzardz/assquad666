package assquad666.quoridor;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Command is in charge of parsing a String of input and storing it into itself. 
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Parsing Input.</li>
 * <li>Storing a command.</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>Command's constructor needs a String as an argument.</li>
 * <li>This String is parsed and stored as different variables right away.</li>
 * <li>There are 5 types of Commands: new, load, save, new(with moves), a move.</li>
 * <li>A Command can be invalid in which case it will be ignored by the class creating it.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */
public class Command {

	//Different types of command
	final int INVALID = 0;
	final int NEW_GAME = 1;
	final int LOAD_GAME = 2;
	final int SAVE_GAME = 3;
	final int NEW_WITH_MOVES = 4;
	final int MOVE = 5;

	
	//Different moves informations
	final int PAWN = 0;
	final int HORIZONTAL = 1;
	final int VERTICAL = 2;
	
	
	int type;
	String fileName;
		
	LinkedList<Move> moves = new LinkedList<Move>();
	
	/**
	 * The type of Command (new, load, save, new(with moves) or a move).
	 * @return The type of Command (new, load, save, new(with moves) or a move). 
	 */
	public int type(){
		return type;
	}
	
	/**
	 * The name of the file to be loaded if it is a load Command.
	 * @return The name of the file to be loaded if it is a load Command.
	 */
	public String fileName(){
		return fileName;
	}
	
	/**
	 * The move to be done if it is a move Command.
	 * @return The move to be done if it is a move Command.
	 */
	public Move move(){
		assert moves != null;
		return moves.getFirst();
	}
	
	/**
	 * The list of the moves to be done if it is a new(with moves) Command.
	 * @return The list of the moves to be done if it is a new(with moves) Command.
	 */
	public LinkedList<Move> moves(){
		
		return moves;
	}
	
	
	/**
	 * Constructor function. Parses and stores input.
	 * @param input The String input into stdin that this class has to parse and store.
	 */
	public Command(String input){
		char c;
		char lastc = ' ';
		char lastlastc = ' ';
		int size = 9;
		int startChar = 0;
		int movCount = 0;
		fileName = "";
		
		if ("\n".startsWith (input)) {
			this.type = INVALID;
			System.out.println("Error: Empty input.");
			return;
		} else if ("new".startsWith (input)){
			this.type = NEW_GAME;
			startChar = 4;
	/*		if(input.charAt(startChar - 1) != ' ' && input.charAt(startChar - 1) != '\n'){
				this.type = INVALID;
				System.out.println("Error: A space is expected after \"new\".");
				return;
			}*/
		} else if ("load".startsWith (input)){
			this.type = LOAD_GAME;
			startChar = 5;
		} else if ("save".startsWith (input)){
			this.type = SAVE_GAME;
		} 
		

		
		
		c = input.charAt(0);

		for(int i = startChar; i<input.length(); i++){
			c = input.charAt(i);
		//	System.out.println("les characters: "+lastlastc+" "+lastc+" "+c);
			if(Character.isLetter(lastlastc) && ((lastlastc - 'a') < size) 
					&& Character.isDigit(lastc) && (lastc - '0' <= size && lastc - '0' >0)){
				if(c == 'h'){
					this.moves.add(new Move(lastlastc - 'a', lastc - '0', HORIZONTAL));
				} else if (c == 'v'){
					this.moves.add(new Move(lastlastc - 'a', lastc - '0', VERTICAL));
				} else if (c == ' '){
					this.moves.add(new Move(lastlastc - 'a', lastc -'0', PAWN));
				}
				movCount++;
			}
			
			lastlastc = lastc;
			lastc = c;
		}
		
		//	System.out.println("les characters: "+lastlastc+" "+lastc+" "+c);

		if(Character.isLetter(lastlastc) && ((lastlastc - 'a') < size) 
				&& Character.isDigit(lastc) && (lastc - '0' <= size && lastc - '0' > 0)){
			this.moves.add(new Move(lastlastc - 'a', lastc - '0', PAWN));
			movCount++;
		}
		
		if(movCount == 1){
			this.type = MOVE;
		} else if (movCount >1 ){
			this.type = NEW_WITH_MOVES;
		}
		
		
	}
}
