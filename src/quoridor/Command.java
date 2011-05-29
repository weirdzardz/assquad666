package quoridor;

import java.util.LinkedList;


import quoridor.Move.MoveType;

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
	
	public enum CommandType {INVALID, NEW_GAME, LOAD_GAME, SAVE_GAME, NEW_WITH_MOVES, MOVE, UNDO, REDO, MOVES,HELP};	
	CommandType type;
	String fileName;		
	LinkedList<Move> moves = new LinkedList<Move>();
	
	/**
	 * The type of Command (new, load, save, new(with moves) or a move).
	 * @return The type of Command (new, load, save, new(with moves) or a move). 
	 */
	public CommandType type(){
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
		String[] bits = input.split("\\s+");
		
		if(bits[0].equals("load")){			
			if(bits.length == 2){
				fileName = bits[1];
				this.type = CommandType.LOAD_GAME;
			} else {
				System.out.println("You need to specify a file to load.");
				this.type = CommandType.INVALID;
			}			
		} else if (bits[0].equals("new")){			
			if (bits.length > 1){	
				for(int j = 1; j<bits.length;j++){
					Move temp = parseBit(bits[j]);
					if(temp != null){
						moves.add(temp);
						this.type = CommandType.NEW_WITH_MOVES;
					} else {
						this.type = CommandType.INVALID;
						return;
					}
				}
			} else {
				this.type = CommandType.NEW_GAME;
			}			
		} else if (bits[0].equals("save")){			
			if(bits.length == 2){
				fileName = bits[1];
				this.type = CommandType.SAVE_GAME;
			} else {
				System.out.println("You need to specify a file name to save the game in.");
				this.type = CommandType.INVALID;
			}		
		} else if (bits[0].equals("undo")){			
				this.type = CommandType.UNDO;				
		} else if (bits[0].equals("redo")){			
				this.type = CommandType.REDO;
		} else if(bits[0].equals("help")){
				printHelp();
				this.type = CommandType.HELP;
				return;
		} else {
			
			if (bits.length > 1){	
				for(int j = 0; j<bits.length;j++){
					Move temp = parseBit(bits[j]);
					if(temp != null){
						moves.add(temp);
						this.type = CommandType.MOVES;
					} else {
						this.type = CommandType.INVALID;
						return;
					}
				}
			} else {
				Move temp = parseBit(bits[0]);
				if(temp != null){
					moves.add(temp);
					this.type = CommandType.MOVE;
				} else {
					this.type = CommandType.INVALID;
					return;
				}
			}
		}	
	}

	private void printHelp() {
		System.out.println("Quoridor Help");
		System.out.println("Valid Commands:");
		System.out.println("\"new\" creates a new game.");
		System.out.println("\"new\" \"a list of moves\" creates a new game and initializes it to this list of moves.");
		System.out.println("i.e. \"new e8 e2 e7 e3 e2h\"");
		System.out.println("\"load\" \"xxx\" loads a game from a file. Replace \"xxx\" by the name of your file.");
		System.out.println("\"save\" \"xxx\" save a game to a file. Replace \"xxx\" by the name of your file.");
		System.out.println("You can use \"undo\" as many times as you want.");
		System.out.println("Same thing for \"redo\".");

	}

	private Move parseBit(String bit) {
			
		if(bit.length() == 2){
			if(Character.isLetter(bit.charAt(0)) 
				&& Character.isDigit(bit.charAt(1))){
				return new Move(bit.charAt(0) - 'a', bit.charAt(1) - '0', MoveType.PAWN);
			} else {
				System.out.println(bit + " is not a valid move.");
				return null;
			}
		} else if (bit.length() == 3){
			if(Character.isLetter(bit.charAt(0)) 
					&& Character.isDigit(bit.charAt(1))){
				if(bit.charAt(2) == 'h'){
						return new Move(bit.charAt(0) - 'a', bit.charAt(1) - '0', MoveType.HORIZONTAL);
				} else if(bit.charAt(2) == 'v'){
						return new Move(bit.charAt(0) - 'a', bit.charAt(1) - '0', MoveType.VERTICAL);
				} else {
					System.out.println(bit + " is not a valid move.");
					return null;
				}
			} else {
				System.out.println(bit + " is not a valid move.");
				return null;
			}
			
			
		} else {
			System.out.println(bit + " is not a valid command.");
			return null;
		}
	}
	
	
	
	
}





/* backup
 * 
 * 
 * if(bit.length() == 2){
			if(Character.isLetter(bit.charAt(0)) && ((bit.charAt(0) - 'a') < size) 
				&& Character.isDigit(bit.charAt(1)) && (bit.charAt(1) - '0' <= size && bit.charAt(1) - '0' > 0)){
				return new Move(bit.charAt(0) - 'a', bit.charAt(1) - '0', MoveType.PAWN);
			} else {
				System.out.println(bit + " is not a valid move.");
				return null;
			}
		} else if (bit.length() == 3){
			if(Character.isLetter(bit.charAt(0)) && ((bit.charAt(0) - 'a') < size) 
					&& Character.isDigit(bit.charAt(1)) && (bit.charAt(1) - '0' <= size && bit.charAt(1) - '0' > 0)){
				if(bit.charAt(2) == 'h'){
					if(bit.charAt(0) == 'i' || bit.charAt(1) == '1'){
						System.out.println(bit + " is not a valid move.");
						return null;
					} else {
						return new Move(bit.charAt(0) - 'a', bit.charAt(1) - '0', MoveType.HORIZONTAL);
					}
				} else if(bit.charAt(2) == 'v'){
					if(bit.charAt(1) == '9' || bit.charAt(0) == 'a'){
						System.out.println(bit + " is not a valid move.");
						return null;
					} else {
						return new Move(bit.charAt(0) - 'a', bit.charAt(1) - '0', MoveType.VERTICAL);
					}
				} else {
					System.out.println(bit + " is not a valid move.");
					return null;
				}
			} else {
				System.out.println(bit + " is not a valid move.");
				return null;
			}
			
			
		} else {
			System.out.println(bit + " is not a valid command.");
			return null;
		}
	}
 * 
 * 
 * 
 * 
 */
 

