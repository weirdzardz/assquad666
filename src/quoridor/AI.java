package quoridor;

import java.util.ArrayList;
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

		//Move move = naiveMove();
//		System.out.println("move: (" + move.coord().x() + ", " + move.coord.y() + ")");
//		System.out.println("type: " + move.direction());
		move = new Move(3, 1, MoveType.VERTICAL);
		
		System.out.println("Placing d1v valid = " + game.isValid(move, game.myTurn));
		
		System.out.print("Walls = ");
		for (int i = 0; i < game.walls.size(); i++) {
			System.out.print("(" + game.walls.get(i).pos.x + ", " + game.walls.get(i).pos.y + ") ");
		}
		
		System.out.println();
	
		return move;
	}

	private Move randomMove() {
		ArrayList<Move> possibleMoves = findPossibleMoves();
		Random randomGenerator = new Random();
		Move move = possibleMoves.get(randomGenerator.nextInt(possibleMoves.size()));
		
//		for (int i = 0; i < game.walls.size(); i++) {
//			System.out.print("(" + game.walls.get(i).pos.x + ", " + game.walls.get(i).pos.y + ") ");
//		}
//		System.out.println();
		
		
		return move;
	}
	
	private Move naiveMove() {
		ArrayList<Move> possibleMoves = findPossibleMoves();
		int myValue = game.shortestPath(game.myTurn()).size();
		int highestValue = -999;
		int index = 0;

		System.out.println(possibleMoves.size());

		//Find best move
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
				//System.out.println(possibleMoves.get(i).direction());
				
				//tempGame.display();
				
				//find best value path
				value = tempGame.shortestPath(tempGame.players.other(tempGame.myTurn)).size() 
						- (tempGame.shortestPath(tempGame.myTurn).size() - myValue);
				
				if (value > highestValue) {
					highestValue = value;
					index = i;
				}
			}
		}
		
		System.out.println("move: (" + possibleMoves.get(index).coord().x() + ", " + possibleMoves.get(index).coord.y() + ")");
		System.out.println("type: " + possibleMoves.get(index).direction());
		for (int i = 0; i < game.walls.size(); i++) {
			System.out.print("(" + game.walls.get(i).pos.x + ", " + game.walls.get(i).pos.y + ") ");
		}
		System.out.println();

		System.out.println(game.isValid(possibleMoves.get(index), game.myTurn()));
		
		return possibleMoves.get(index);
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
