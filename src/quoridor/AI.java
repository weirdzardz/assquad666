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
		Move move = randomMove();

		//move = naiveMove();
//		System.out.println("move: (" + move.coord().x() + ", " + move.coord.y() + ")");
//		System.out.println("type: " + move.direction());

		return move;
	}
	
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
		
		for (int i = 0; i < checkList.size(); i++) {
			if (game.isValid(checkList.get(i), game.myTurn())) {
				possibleMoves.add(checkList.get(i));
			}
		}		
		
		return possibleMoves;
	}

	private Move randomMove() {
		ArrayList<Move> possibleMoves = findPossibleMoves();
		Random randomGenerator = new Random();
		Move move = possibleMoves.get(randomGenerator.nextInt(possibleMoves.size()));
		
		return move;
	}
	
//	private Move naiveMove() {
//		ArrayList<Move> possibleMoves = findPossibleMoves();
//		int highestValue = game.shortestPath(game.myTurn).size();
//		Player player = game.myTurn();
//		int index = 0;
//
//		//placing walls
//		for (int i = 0; i < possibleMoves.size(); i++) {
//			int value = 0;
//			if (possibleMoves.get(i).direction() == MoveType.HORIZONTAL 
//					|| possibleMoves.get(i).direction() == MoveType.VERTICAL) {
//				//add wall to game
//
//
//				//Game tempGame = game;
//				
//				System.out.println(game.myTurn);
//				if (!game.myTurn().equals(player)) {
//					game.changeTurn();
//				}
//				
//				System.out.println(game.myTurn);
//				//tempGame.move(possibleMoves.get(i), tempGame.myTurn);
//				game.move(possibleMoves.get(i), game.myTurn);
//				System.out.println(possibleMoves.get(i).direction());
//				System.out.println(game.myTurn().wallsLeft());
//				//tempGame.display();
//				
//				//System.out.println(tempGame.myTurn);
//
//				//find shortest path
//				value = game.shortestPath(game.players.other(game.myTurn)).size() 
//						- game.shortestPath(game.myTurn).size();
//				if (value > highestValue) {
//					highestValue = value;
//					index = i;
//					//System.out.println("move: (" + possibleMoves.get(index).coord().x() + ", " + possibleMoves.get(index).coord.y() + ")");
//
//				}
//				
//				game.undo();
//				System.out.println(game.myTurn().wallsLeft());
//
//			}
//		}
//		
//		System.out.println(highestValue);
//		return possibleMoves.get(index);
//	}	
	
}
