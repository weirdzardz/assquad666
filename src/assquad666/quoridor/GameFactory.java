package assquad666.quoridor;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * User Interface is in charge of input, creating games, displaying them and updating them. 
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Parses Input.</li>
 * <li>Creates and stores Game states.</li>
 * <li>Display.</li>
 * <li>Returns moves.</li>
 * </ul> 
 * 
 *  <h2>Implementation</h2>
 * <ul>
 * <li>What's inside.</li>
 * </ul>
 * 
 * 
 * @author Sachou
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
	
	public static String getInput(){
		Scanner input = new Scanner (System.in);	
		String line = input.nextLine ().toLowerCase ();
		return line;
	}
	
	
	public static void newGame() {
		System.out.println("Making a new game...");
		Game game = new Game();
		game.play();
	}
	
	public static void loadGame(String fileName){
		System.out.println("Loading a game...");

	}
	
	public static void newGameWithMoves(LinkedList<Move> moves){
		System.out.println("Making a new game with initialisation...");

		
	}
	
}
