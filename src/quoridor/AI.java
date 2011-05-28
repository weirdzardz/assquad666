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
		Move move = null;
		
		if (game.myTurn().level().equals("random")) {
			move = randomMove();
		} else if (game.myTurn().level().equals("naive")) {
			move = naiveMove();
		} else if (game.myTurn().level().equals("pro")) {
			move = proMove();
		}

//		System.out.println("move: (" + move.coord().x() + ", " + move.coord.y() + ")");
//		System.out.println("type: " + move.direction());

		return move;
	}

	private Move proMove() {
		// TODO Auto-generated method stub
		return null;
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
		
		//if other player has no more walls and ur shortestPath < his.. MOVE
		
		System.out.println("My path length = " + game.shortestPath(game.myTurn()));
		System.out.println("Their path length = " + game.shortestPath(game.players.other(game.myTurn())));

		if (myValue >= game.shortestPath(game.players().other(game.myTurn())).size() - 1) {
			for (int i = 0; i < possibleMoves.size(); i++) {
				int value = 0;
				if (possibleMoves.get(i).direction() == MoveType.HORIZONTAL 
						|| possibleMoves.get(i).direction() == MoveType.VERTICAL) {
					
					Game tempGame = createTempGame();

					//add wall
					tempGame.move(possibleMoves.get(i), tempGame.myTurn);
												
					//find best value path
					value = (tempGame.shortestPath(tempGame.myTurn).size() - 1)
							- (tempGame.shortestPath(tempGame.players.other(tempGame.myTurn)).size() - myValue)
							- wallDistance(possibleMoves.get(i));
						
					if (isAdjacent(possibleMoves.get(i))) {
						//value = value + 2;
						value++;
					}
						
					if (value > highestValue) {
						highestValue = value;
						index = i;
					}
						
				}
				
				move = game.shortestPath(game.myTurn()).get(1);
			}	
		} else {
			move = game.shortestPath(game.myTurn()).get(1);
		}
		
		//System.out.print("move: (" + possibleMoves.get(index).coord().x() + ", " + possibleMoves.get(index).coord.y() + ")");
		//System.out.println(" " + possibleMoves.get(index).direction());
		
		return move;
	}	
	
	private boolean isAdjacent(Move move) {
		Point player = game.players().other(game.myTurn()).pawn();
		int direction;
		
		if (game.myTurn().equals(game.players()._1())) {
			direction = 1;
		} else {
			direction = -1;
		}
		
		if (direction == -1) {
			if (move.coord().x() == player.x() && move.coord().y() == player.y() 
					||	(move.coord().x() == player.x() - 1 && move.coord().y() == player.y()
							&& move.direction() == MoveType.HORIZONTAL)
					||	(move.coord().x() == player.x() && move.coord().y() == player.y() - 1 
							&& move.direction() == MoveType.VERTICAL)
					||	(move.coord().x() == player.x() + 1 && move.coord().y() == player.y() 
							&& move.direction() == MoveType.VERTICAL)
					||	(move.coord().x() == player.x() + 1 && move.coord().y() == player.y() - 1
							&& move.direction() == MoveType.VERTICAL)) {
				
				return true;
			}
		} else {
			if ((move.coord().x() == player.x() && move.coord().y == player.y() - 1
							&& move.direction() == MoveType.VERTICAL)
					||	(move.coord().x() == player.x() && move.coord().y == player.y()
							&& move.direction() == MoveType.VERTICAL)
					||	(move.coord().x() == player.x() + 1 && move.coord().y == player.y() - 1
							&& move.direction() == MoveType.VERTICAL)
					||	(move.coord().x() == player.x() + 1 && move.coord().y == player.y()
							&& move.direction() == MoveType.VERTICAL)
					||	(move.coord().x() == player.x() - 1 && move.coord().y() == player.y()
							&& move.direction() == MoveType.HORIZONTAL)
					||	(move.coord().x() == player.x() && move.coord().y() == player.y() + 1
							&& move.direction() == MoveType.HORIZONTAL)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	private int wallDistance(Move move) {
			Point otherPlayer = game.players().other(game.myTurn()).pawn();
			
		return (int) Math.sqrt(Math.pow((otherPlayer.x() - move.coord().x()), 2)
				+ Math.pow((otherPlayer.y() - move.coord().y()), 2));
	}

	private Game createTempGame() {
		//create temp game
		Player tempPl1 = new Human("Player 1");
		Player tempPl2 = new Human("Player 2");
		Game tempGame = new Game(Two.two(tempPl1, tempPl2));
		
		tempGame.initGame(null);
		for (int j = 0; j < game.moves.size(); j++) {
			tempGame.move(game.moves.get(j), tempGame.myTurn());
		}
		
		return tempGame;
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