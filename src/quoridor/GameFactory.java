package quoridor;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Game factory is in charge of input, creating games, loading games. 
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Get Input.</li>
 * <li>Send the Input to get parsed.</li>
 * <li>Creates games and is able to load them from a file or initialize them from a list of moves.</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>Main Class of the program. Display prompts and ask for input.</li>
 * <li>Uses the Command class to parse a String into an actual Command.</li>
 * <li>Creates new and loaded Games, and initializes them with a Command.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */

public class GameFactory {
	
	//Different types of command
	final static int INVALID = 0;
	final static int NEW_GAME = 1;
	final static int LOAD_GAME = 2;
	final static int SAVE_GAME = 3;
	final static int NEW_WITH_MOVES = 4;
	final static int MOVE = 5;
	
	
	
	/**
	 * Main Function of the program. It's where it all start.
	 * @param args Arguments passed to the main function of the program to trigger specific use of the program. Not used here.
	 */
	public static void main(String[] args){
		
		System.out.println("Welcome to Quoridor AssQuad666 !");
		System.out.println("Input a command:");
		Command command = new Command(getInput());
		
		while(command.type() == INVALID || command.type() == MOVE || command.type() == SAVE_GAME) {
			if (command.type() == MOVE){
				System.out.println("You need to make a new game before making a move, try again:");
			} else if(command.type() == SAVE_GAME){
				System.out.println("You need to make a new game before saving, try again:");
			} else{
				System.out.println("Input a command:");
			}
			command = new Command(getInput());
		}
		
		if(command.type() == NEW_GAME){
			newGame();
			
		} else if(command.type() == LOAD_GAME){
			loadGame(command.fileName());
			
		} else if(command.type() == NEW_WITH_MOVES){
			newGameWithMoves(command.moves());	
		} 
		
		
	}
	
	
	/**
	 * Simply scan the stdin to get a line the user typed.
	 * @return The String the user input in the command line.
	 */
	public static String getInput(){
		Scanner input = new Scanner (System.in);	
		String line = input.nextLine ().toLowerCase ();
		return line;
	}
	
	/**
	 * Creates a new Game. Initializes it.
	 */
	public static void newGame() {
		System.out.println("Making a new game...");
		Game game = new Game();
		game.play();
	}
	
	/**
	 * Creates a Game. Initializes it to the state given in the file.
	 * @param fileName The name of the file from which the game will be loaded.
	 */
	public static void loadGame(String fileName){
		System.out.println("Loading a game...");

	}
	
	/**
	 * Creates a Game. Initializes it to the state given by a list of moves input in stdin.
	 * @param moves The moves input to which the game should be initialized.
	 */
	public static void newGameWithMoves(LinkedList<Move> moves){
		System.out.println("Making a new game with initialisation...");

		
	}
	
}
