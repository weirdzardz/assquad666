package assquad666.quoridor;

import java.util.LinkedList;

public class Display {

	public static LinkedList<String> strings = new LinkedList<String>();
	
	public static void main(String[] args){
		
		display(null);
		
	}
	
	
	public static void display(Game game) {
		String line;
		String temp;
		int i,j,k;
		temp = "   ";
		line = temp + "  a" + temp +"b" + temp +"c" +temp +"d" +temp + "e" +temp +"f" +temp +"g" +temp +"h" +temp +"i";
		strings.add(line);
		
		for(i=0;i<10;i++){

			line = "";
			
			for(j=0;j<10;j++){
				if(( i == 0 || i == 9) && j != 0) //TODO ADD the walls
					temp = "---"; 
				else
					temp = "   ";
				line += temp + "*";
				
			}
			strings.add(line);
			if(i < 9){
				temp = "     ";
				line = (i+1)+ "  |";
				for(k=0;k<7;k++){
					//TODO ADD the PAWNS
					
					
					line +=temp;
				}
				line += "|";
				strings.add(line);
			}
		}
		for(String myString : strings) {
			System.out.println(myString);
		}	
	}
}
