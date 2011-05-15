package quoridor;

/**
 * AIPlayer extends Player and represents an AI Player, which will generate moves.
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Represents an AI Player.</li>
 * </ul> 
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li>Simply Overrides the type() function defined in the Player class.</li>
 * </ul>
 * 
 * 
 * @author Sacha BŽraud <sacha.beraud@gmail.com>
 *
 */

public class AIPlayer extends Player{

	@Override
	public String type() {
		return "AI";
	}

}
