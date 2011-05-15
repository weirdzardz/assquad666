package quoridor;

import java.util.LinkedList;
import java.util.Scanner;

import util.Two;


/**
 * Game is in charge of storing Game states, asking for input to update them, playing, saving and displaying Games. 
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Stores Games States.</li>
 * <li>Asks for input or asks for move generation to play Games.</li>
 * <li>Updates Game States (makes moves).</li>
 * <li>Plays Games.</li>
 * <li>Displays Games.</li>
 * <li>Saves Games.</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>See different functions for now. Implementation is not final yet, </li>
 * <li>so I'm waiting for something more stable before I feel comfortable talking about how this class is implemented.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */


public class Game {
	
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
	
	/**
	 * Players playing the Game
	 */
	public final Two <Player> players;
	public Player myTurn;
	
	int size = 9;
	
	LinkedList<Wall> walls = new LinkedList<Wall>();
	LinkedList<Move> moves = new LinkedList<Move>();
	
	
    public Two <Player> players ()
    {
        return players;
    }
	
    public Player myTurn(){    	
    	return myTurn;
    }
    
    public void changeTurn(){
    	myTurn = players.other(myTurn);
    }
    
	/**
	 * Constructor, creates the players based on names sent by factory.
	 */
	public Game(Two<Player> players){
		this.players = players;
	}
	
	
	/**
	 * Initializes the Game based on information from a load file or input on the command line.
	 */
	public void initGame() {
		players._1.pawn = new Point('e' - 'a', 9);
		players._2.pawn = new Point('e' - 'a', 1);
		myTurn = players._1();
	}
	
	
	/**
	 * Checks if a Player's Pawn is at coordinates x,y.
	 * @param x the letter coordinate on the board.
	 * @param y the number coordinate on the board.
	 * @return The Player whose Pawn is at (x,y).
	 */
	public Player pawnAt(int x, int y){
		
		if(players._1.pawn.let() == x && players._1.pawn.num() == y){
			return players._1();
		} else if(players._2.pawn.let() == x && players._2.pawn.num() == y) {
			return players._2();
		} else {
			return null;
		}
	}
	
	
	/**
	 * Checks if a wall is at coordinates x,y and with direction dir.
	 * @param x the letter coordinate on the board.
	 * @param y the number coordinate on the board.
	 * @param dir the direction of the wall.
	 * @return True if a wall is at coordinates x,y and with direction dir, false otherwise.
	 */
	public boolean isWallAt(int x, int y, int dir){
		boolean returnValue = false;
		
		for(Wall myWall : walls){
			
			if(dir == HORIZONTAL){
				if(myWall.dir() == dir && (myWall.pos().let() == x || myWall.pos().let() == x - 1) && myWall.pos().num() == y)
					returnValue = true;
			} else if (dir == VERTICAL){
				if(myWall.dir() == dir && myWall.pos().let() == x && (myWall.pos().num() == y || myWall.pos().num() == y - 1))
					returnValue = true;
			}
			
		}	
		return returnValue;
	}
	
	
	/**
	 * Soon to be erased, probably.
	 * @param x
	 * @param y
	 * @return
	 */
	public Player whosePawnAt(int x, int y){
		
		return null;
	}
	
	
	/**
	 * Checks if a Game is new. not used for now.
	 * @return True if this game is new, false otherwise.
	 */
	public boolean isNew(){
		
		return false;
	}
	
	/**
	 * Checks if a game is over, soon to be done.
	 * @return True if a game is over (pos of player at the otherside of the board blah blah...), false if not.
	 */
	public boolean isOver(){	
		return (players._1().pawn().num() == 1 || players._2().pawn().num() == 9);
	}
	
	/**
	 * @return The winner of the Game.
	 */
	public Player winner(){
		if(players._1().pawn().num() == 1){
			return players._1();
		} else {
			return players._2();
		}
	}
	
	/**
	 * @return The loser of the Game.
	 */
	public Player loser(){
		if(players._1().pawn().num() == 1){
			return players._2();
		} else {
			return players._1();
		}
	}

	/**
	 * Moves a pawn from a position to another, or place a wall.
	 * @param move The move with coordinates a player is making.
	 * @param p the player making the move.
	 */
	public void move(Move move, Player p) {
		// TODO Auto-generated method stub
		if(move.direction() == PAWN){
			placePawn(move, p);
		} else{
			placeWall(move);
		}
		changeTurn();
	}

	/**
	 * Moves a pawn from a position to another.
	 * @param move The move with coordinates a player is making.
	 * @param p The player making the move.
	 */
	public void placePawn(Move move, Player p){
		p.pawn = new Point(move.coord().let(), move.coord().num());
	}
	
	
	/**
	 * Places a wall
	 * @param move The coordinates and direction of the wall to be placed.
	 */
	public void placeWall(Move move) {
		walls.add(new Wall(move.coord(), move.direction()));
	}
	
	/**
	 * well its gonna call validator or something, soon to be done.
	 * @param move The move with coordinates a player is making.
	 * @return True if the move is valid, false if not.
	 */
	public boolean isValid (Move move){
		
		return false;
	}


	/**
	 * Plays the Game. With a !isOver() loop. keeps asking for prompts for now and displaying.
	 * Soon will be AI and stuff.
	 */
	public void play() {
		
		initGame();
		display();
		System.out.println("Make a move "+ myTurn().name +": ");
		while(!isOver()){
			
			Command command = new Command(getInput());
			
			while(command.type() == INVALID) {
				command = new Command(getInput());
			}
			
			if(command.type() == NEW_GAME){
				GameFactory.newGame();
				return;
				
			} else if(command.type() == LOAD_GAME){
				GameFactory.loadGame(command.fileName());
				return;
				
			} else if(command.type() == NEW_WITH_MOVES){
				GameFactory.newGameWithMoves(command.moves());
				return;
				
			} else if(command.type() == MOVE){
				//if(isValid(command.move(),null))
				Validator v = new Validator(this);
				if(v.checkMove(command.move(), myTurn())){
					move(command.move(), myTurn()); //null =>player who's turn it is
					moves.add(command.move());
				} else {
					System.out.println("Invalid move noob, try again: ");

				}
				
				
			} else if(command.type() == SAVE_GAME){
				save();
				return; // a retirer
			}
			display();
			System.out.println("Make a move "+ myTurn().name +": ");
		}
		
		System.out.println("GG. Winner is " + winner().name + ".");
	}
	
	
	/**
	 * Saves a Game. right now it just prints all the moves that have been done.
	 */
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("Saving a game...");
		String line = "";
		for(Move myMove: moves){
			line +=  myMove.toString() + " ";
		}
		System.out.println(line); // to change to print to file and it's GG, I think

	}


	/**
	 * Used to get the users moves and commands.
	 * @return String that the user input on the command line.
	 */
	public String getInput(){
		Scanner input = new Scanner (System.in);	
		String line = input.nextLine ().toLowerCase ();
		return line;
	}
	
	
	
	/**
	 * Displays the game (the board with the pawns and walls).
	 */
	public void display() {
		LinkedList<String> strings = new LinkedList<String>();
		String line;
		String temp;
		int i,j,k;
		
		//letters index
		temp = "   ";
		line = temp + "  a" + temp +"b" + temp +"c" +temp +"d" +temp + "e" +temp +"f" +temp +"g" +temp +"h" +temp +"i";
		strings.add(line);
		
		for(i=0;i<10;i++){

			line = "";
			
			for(j=0;j<10;j++){
				if( ((i == 0) || (i == 9) || (isWallAt(j-1,i+1,HORIZONTAL))) && j !=0  ) //TODO ADD the walls
					
					temp = "---"; 
				else
					temp = "   ";
				line += temp + "*";
				
			}
			strings.add(line);
			if(i < 9){
				line = (i+1)+ "  |";  //print number index
				for(k=0;k<9;k++){
					Player p = pawnAt(k,i+1);
					if( p != null) //check if pawn at (k,i)
						if(p == players._1()) // check if player 1
							temp = " X ";
						else  // else player 2
							temp = " O ";
					else
						temp = "   ";
					
					line +=temp;
					if(isWallAt(k+1,i+1,VERTICAL) || k == 8) //check if vertical wall
						line += "|";
					else
						line += " ";
				}
				strings.add(line);
			}
		}
		
		//Actually prints everything
		for(String myString : strings) {
			System.out.println(myString);
		}	
	}
}
