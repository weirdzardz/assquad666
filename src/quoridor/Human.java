package quoridor;

/**
 * Human extends Player and represents a Human Player, which will be prompted for input to move.
 * 
 * <h2>Goals</h2>
 * <ul>
 * <li>Represents a Human Player.</li>
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

public class Human extends Player{

	public Human(String string) {
		this.name =string;
	}

	@Override
	public String type() {
		return "Human";
	}

	@Override
	public String level() {
		return "noLevel";
	}

}
