package assquad666.quoridor;

import java.util.LinkedList;

/**
 * @author Sachou
 *
 */
public class Game {
	
	
	
	/**
	 * Players playing the Game
	 */
	Player playerOne;
	Player playerTwo;
	
	Pawn plOne;
	Pawn plTwo;
	
	int size = 9;
	
	LinkedList<Wall> walls = new LinkedList<Wall>();
	
	public Game(/*String pl1, String pl2*/){
		
		
		
	}
	
	
	public void initGame() {
		plOne = new Pawn('e' - 'a', 1);
		plTwo = new Pawn('e' - 'a', 9);	
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

	public void move(Move myMove) {
		// TODO Auto-generated method stub
		
	}

	public void placeWall(Move myMove) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isValid(Move myMove){
		
		return false;
	}
}
