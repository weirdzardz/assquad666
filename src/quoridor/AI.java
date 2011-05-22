package quoridor;

import java.util.ArrayList;
import java.util.Random;

import quoridor.Move.MoveType;


/**
 * AI is called to generate a move based on game state and a smartness of a move.
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Generates random, intelligent, or dumb moves.</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>To be done at some point.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */

//limited number of walls not implemented
//player can go through walls
//allows players to be boxed in

public class AI {
	
	Game game;
	
	public AI(Game game){
		this.game = game;
	}
	
	public Move createMove(){
		ArrayList<Move> possibleMoves = new ArrayList<Move>();

		Move move = null;
	    
		possibleMoves = findPossibleMoves();
		
		
		move = randomMove(possibleMoves);
		//move = closestTargetMove(possibleMoves);
//		System.out.println("move: (" + move.coord().x() + ", " + move.coord.y() + ")");
//		System.out.println("type:n " + move.direction());

		return move;
	}
	
	/**
	 * Finds all the possible moves for the player
	 * @return list of possible moves
	 */
	private ArrayList<Move> findPossibleMoves() {
		ArrayList<Move> possibleMoves = new ArrayList<Move>();
		ArrayList<Move> checkList = new ArrayList<Move>();
		Point current = game.myTurn.pawn();
		
		checkList.add(new Move(current.x() + 1, current.y(), MoveType.PAWN));
		checkList.add(new Move(current.x() + 2, current.y(), MoveType.PAWN));
		checkList.add(new Move(current.x(), current.y() + 1, MoveType.PAWN));
		checkList.add(new Move(current.x(), current.y() + 2, MoveType.PAWN));
		checkList.add(new Move(current.x() - 1, current.y(), MoveType.PAWN));
		checkList.add(new Move(current.x() - 2, current.y(), MoveType.PAWN));
		checkList.add(new Move(current.x(), current.y() - 1, MoveType.PAWN));
		checkList.add(new Move(current.x(), current.y() - 2, MoveType.PAWN));
		checkList.add(new Move(current.x() - 1, current.y() - 1, MoveType.PAWN));
		checkList.add(new Move(current.x() + 1, current.y() - 1, MoveType.PAWN));
		checkList.add(new Move(current.x() - 1, current.y() + 1, MoveType.PAWN));
		checkList.add(new Move(current.x() + 1, current.y() + 1, MoveType.PAWN));
		checkList.add(new Move(current.x() - 1, current.y() + 1, MoveType.PAWN));
		
		//add walls to checklist
		if (game.myTurn().wallsLeft() > 0) {
			for (int i = 1; i < 9; i++) {
				for (int j = 1; j < 9; j++) {
					checkList.add(new Move(j, i, MoveType.HORIZONTAL));
					checkList.add(new Move(j, i, MoveType.VERTICAL));
				}
			}
		}
		
//		for (int i = 0; i < checkList.size(); i++) {
//			System.out.print("(" + checkList.get(i).coord().x() + ", " + checkList.get(i).coord().y() + ") ");
//		}
//		System.out.println();
		
		for (int i = 0; i < checkList.size(); i++) {
			if (isInBoard(checkList.get(i)) && game.isValid(checkList.get(i), game.myTurn())) {
				possibleMoves.add(checkList.get(i));
			}
		}		
		
//		for (int i = 0; i < possibleMoves.size(); i++) {
//			System.out.print("(" +possibleMoves.get(i).coord().x() + ", " + possibleMoves.get(i).coord().y() + ") ");
//		}
//		System.out.println();
		
		return possibleMoves;
	}

	/**
	 * Selects a random move out of a list of possible moves 
	 * @param possibleMoves list of possible moves
	 * @return the selected move
	 */
	private Move randomMove(ArrayList<Move> possibleMoves) {
		Random randomGenerator = new Random();
		//System.out.println(possibleMoves.size());
		int ran = randomGenerator.nextInt(possibleMoves.size());
		Move move = possibleMoves.get(ran);
		
//		System.out.println("ran = " + ran);
//		for (int i = 0; i < possibleMoves.size(); i++) {
//			System.out.print("(" +possibleMoves.get(i).coord().x() + ", " + possibleMoves.get(i).coord().y() + ") ");
//		}
//		System.out.println();
		return move;
	}
	

//	private Move closestTargetMove(ArrayList<Move> moves) {
//		Move closest = moves.get(0);
//		int lowestDis = 99;
//		int newLow;
//		
//		for (int i = 0; i < moves.size(); i++) {
//			newLow = (int) Math.sqrt(Math.pow(moves.get(i).coord().x() - 4, 2) + Math.pow(moves.get(i).coord().y() - 9, 2));
//			
//			if (newLow < lowestDis) {
//				lowestDis = newLow;
//				closest = moves.get(i);
//			}
//		}
//		
//		return closest;
//		
//	}
	
	/**
	 * Checks if the move is inside the board
	 * @return true if it is inside, otherwise false
	 */
	private boolean isInBoard(Move move) {
		int x = move.coord().x();
		int y = move.coord().y();
		
		if (x >= 0 && x < 9 && y > 0 && y <= 9) {
			return true;
		}
		
		return false;
	}
	
}
