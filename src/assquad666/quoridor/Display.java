package assquad666.quoridor;

import java.util.LinkedList;

public class Display {

	public static LinkedList<String> strings = new LinkedList<String>();
	
	
	public static Game myGame;
/*
	public static void main(String[] args){
		
		myGame = new Game();
		myGame.initGame();
		Command myCommand = new Command();
		myCommand.fillCommand();
		
		display(myGame);
		
	}
	
	*/
	public static void display(Game game) {
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

					if(game.isPawnAt(k,i+1)) //check if pawn  at (k,i)
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
