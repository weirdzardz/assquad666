AssQuad666 Quoridor Documentation

How to run our game:

* Run the GameFactory.class file using the Java Virtual Machine.


General Display of the board:

     a   b   c   d   e   f   g   h   i
   *---*---*---*---*---*---*---*---*---*
1  |                 O                 |
   *   *   *   *   *   *   *   *   *   *
2  |                                   |
   *   *   *   *   *   *   *   *   *   *
3  |                                   |
   *   *   *   *   *   *   *   *   *   *
4  |                                   |
   *   *   *   *   *   *   *   *   *   *
5  |                                   |
   *   *   *   *   *   *   *   *   *   *
6  |                                   |
   *   *   *   *   *   *   *   *   *   *
7  |                                   |
   *   *   *   *   *   *   *   *   *   *
8  |                                   |
   *   *   *   *   *   *   *   *   *   *
9  |                 X                 |
   *---*---*---*---*---*---*---*---*---*

Valid Commands:
* "new" creates a new game.

* A move can be made using the coordinates of a tile in the board starting with the
letter, then the number, then a direction if it is a wall. A wall starts at the top
left corner of the said tile, h is used for horizontal, v for vertical.
i.e. 	e2 moves a pawn to the e2 tile. 
		e2h puts a wall horizontally starting at the top
left corner of the e2 tile.
		e2v puts a wall vertically starting at the top
left corner of the e2 tile.

* "new" "a list of moves" creates a new game and initializes it to this list of moves.
i.e. "new e8 e2 e7 e3 e2h"

* "load" "xxx" loads a game from a file. Replace "xxx" by the name of your file.

* "save" "xxx" save a game to a file. Replace "xxx" by the name of your file.

* "undo" can be used as many times as possible.

* "redo" can be used as many times as possible.

Implementation of the Min-Max algorithm:

	Go JO!



Project Requirements Tick-off:

		Demo + UI Total
	* Board Display + Game Initialisation...............done
	* Moves + User Interaction..........................done
	* Other features (save, load, undo, redo)...........done
		
		Implementation Total
	* Code quality and style............................awesome
	* Unit tests:
		- Validator.....................................done
		- Parsing ? ....................................?
	
		AI Total
	* Naive AI..........................................done
	* Good AI using min max.............................done
	* Game scoring function.............................done
	*....???
	
Any change since Final Design:

	* Nop?


