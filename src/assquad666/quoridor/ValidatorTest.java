package assquad666.quoridor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;




public class ValidatorTest {

	Validator v;

	
	@Before
    public void setUp () throws Exception
    {
		 v = new Validator();
    }
	
	//Pawn
	@Test
	public void outOfBoardTest(){
		assertFalse(v.check("e12 e-1"));
		assertFalse(v.check("z8 z43"));
	
	}
	
	@Test
	public void FirstMovesTest() {
		assertTrue(v.check("e8 e2"));
		assertTrue(v.check("f9 f1"));
		assertTrue(v.check("d9 d1"));
	}
	
	@Test
	public void notAdjacentTest(){
		assertFalse(v.check("e5 e4"));
	}
		
	@Test
	public void jumpTest(){
		assertTrue(v.check("e8 e2 e7 e3 e6 e4 e5 e6"));
	
	}
	
	@Test
	public void ExampleProjectTest(){
		assertTrue(v.check("e8 e2 e7 e3 e6 e4 e5 e6 e4 e7 e3 e8 e2 e9"));
		//assertTrue(Game.winner() == player2);
	}
	
	
	
	//Walls
	
	
	@Test
	public void randomWallTest(){
		assertTrue(v.check("e8h e2h"));
		assertTrue(v.check("e4v f5v"));
		//assertTrue(Game.winner() == player2);
	}
	
	
	
	//assuming wall placement h is from left to right and v is from top to bottom
	@Test
	public void crossingWalls(){
		assertFalse(v.check("e5h f4v"));

			
	}	
}
