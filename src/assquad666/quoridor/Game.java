package assquad666.quoridor;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Sachou
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
	Player playerOne;
	Player playerTwo;
	
	Point plOne;
	Point plTwo;
	
	int size = 9;
	
	LinkedList<Wall> walls = new LinkedList<Wall>();
	LinkedList<Move> moves = new LinkedList<Move>();
	
	
	public Game(/*String pl1, String pl2*/){
		
		
	}
	
	
	public void initGame() {
		plOne = new Point('e' - 'a', 1);
		plTwo = new Point('e' - 'a', 9);	
	}
	
	public boolean isPawnAt(int x, int y){
		
		
		return (plOne.let() == x && plOne.num() == y) || (plTwo.let() == x && plTwo.num() == y);
	}
	
	public Player whosePawnAt(int x, int y){
		
		return null;
	}
	
	
	
	public int width(){	
		return size;
	}
	
	public int height(){
		return size;
	}
	
	
	public boolean isNew(){
		
		return false;
	}
	
	public boolean isOver(){
		
		return false;
	}
	
	public Player winner(){
		
		return null;
	}
	
	public Player loser(){
		
		return null;
	}
	
	public Player playerOne(){
		
		return this.playerOne;
	}
	
	public Player playerTwo(){
		
		return this.playerTwo;
	}

	public void move(Move move, Player p) {
		// TODO Auto-generated method stub
		if(move.direction() == PAWN){
			placePawn(move, p);
		} else{
			placeWall(move);
		}
		
	}

	public void placePawn(Move move, Player p){
		plOne = new Point(move.coord().let(), move.coord().num());
	}
	
	
	public void placeWall(Move move) {
		walls.add(new Wall(move.coord(), move.direction()));
	}
	
	public boolean isValid (Move move){
		
		return false;
	}


	public void play() {
		
		initGame();
		while(!isOver()){
			
			display();
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
				move(command.move(), null); //null =>player who's turn it is
				moves.add(command.move());
				
			} else if(command.type() == SAVE_GAME){
				save();
				return; // a retirer
			}
		}
		
		System.out.println("Game Over. Winner is blahblah");
	}
	
	
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("Saving a game...");
		String line = "";
		for(Move myMove: moves){
			line +=  myMove.toString() + " ";
		}
		System.out.println(line);

	}


	public String getInput(){
		Scanner input = new Scanner (System.in);	
		String line = input.nextLine ().toLowerCase ();
		return line;
	}
	
	
	
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
				if((( i == 0 || i == 9) && j != 0)  || false  ) //TODO ADD the walls
					
					temp = "---"; 
				else
					temp = "   ";
				line += temp + "*";
				
			}
			strings.add(line);
			if(i < 9){
				line = (i+1)+ "  |";  //print number index
				for(k=0;k<9;k++){
					//TODO ADD the PAWNS and vertical walls

					if(isPawnAt(k,i+1)) //check if pawn  at (k,i)
						if(true) // check if player 1
							temp = " X ";
						else  // else player 2
							temp = " O ";
					else
						temp = "   ";
					
					line +=temp;
					if(false || k == 8) //check vertical wall
						line += "|";
					else
						line += " ";
				}
				strings.add(line);
			}
		}
		for(String myString : strings) {
			System.out.println(myString);
		}	
	}
}
