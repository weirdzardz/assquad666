package quoridor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import quoridor.Move.MoveType;
import util.Two;


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

		//Move move = randomMove();
//		System.out.println("move: (" + move.coord().x() + ", " + move.coord.y() + ")");
//		System.out.println("type: " + move.direction());
				

		return move;
	}

	private Move randomMove() {
		ArrayList<Move> possibleMoves = findPossibleMoves();
		Random randomGenerator = new Random();
		Move move = possibleMoves.get(randomGenerator.nextInt(possibleMoves.size()));
		
		return move;
	}
	
	private Move naiveMove() {
		ArrayList<Move> possibleMoves = findPossibleMoves();
		Move move = null;
		int myValue = game.shortestPath(game.myTurn()).size();
		int highestValue = -999;
		int index = 0;

		//prints out possible moves
		System.out.println("Possbile moves = " + possibleMoves.size());
		System.out.println("myValue = " + myValue);

		//Find best move
		if (myValue >= game.shortestPath(game.players().other(game.myTurn())).size() - 1) {
			for (int i = 0; i < possibleMoves.size(); i++) {
				int value = 0;
				if (possibleMoves.get(i).direction() == MoveType.HORIZONTAL 
						|| possibleMoves.get(i).direction() == MoveType.VERTICAL) {
					
					//create temp game
					Player tempPl1 = new Human("Player 1");
					Player tempPl2 = new Human("Player 2");
					Game tempGame = new Game(Two.two(tempPl1, tempPl2));
					
					tempGame.initGame(null);
					for (int j = 0; j < game.moves.size(); j++) {
						tempGame.move(game.moves.get(j), tempGame.myTurn());
					}

					//add wall
					tempGame.move(possibleMoves.get(i), tempGame.myTurn);
					
					//tempGame.display();
					
					//find best value path
					value = tempGame.shortestPath(tempGame.myTurn).size() 
							- (tempGame.shortestPath(tempGame.players.other(tempGame.myTurn)).size() - myValue);
					
					if (value > highestValue) {
						highestValue = value;
						index = i;
					}
					
//					System.out.println("i = " + i + 
//							" (" + possibleMoves.get(i).coord().x() + ", " 
//							+ possibleMoves.get(i).coord().y() + ") " 
//							+ possibleMoves.get(i).direction());
//					System.out.println("index = " + index);
//					LinkedList<Move> path = tempGame.shortestPath(tempGame.myTurn());
//					System.out.println("Other players shortest path = " + 
//							path.size());
//					for (int u = 0; u < path.size(); u++) {
//						System.out.print("(" + path.get(u).coord().x() + ", " + path.get(u).coord().y() + ") ");
//					}
//					System.out.println();
//					
//					path = tempGame.shortestPath(tempGame.players.other(tempGame.myTurn));
//					System.out.println("My shortest path = " 
//							+ tempGame.shortestPath(tempGame.myTurn).size());
//					for (int u = 0; u < path.size(); u++) {
//						System.out.print("(" + path.get(u).coord().x() + ", " + path.get(u).coord().y() + ") ");
//					}
//					System.out.println();
//
//					System.out.println("Value = " + value);
				}
			}
			
			//System.out.println("Final index = " + index);
			move = possibleMoves.get(index);
		} else {
			move = game.shortestPath(game.myTurn()).get(1);
		}
		
		
		//System.out.print("move: (" + possibleMoves.get(index).coord().x() + ", " + possibleMoves.get(index).coord.y() + ")");
		//System.out.println(" " + possibleMoves.get(index).direction());
		
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
	
}
