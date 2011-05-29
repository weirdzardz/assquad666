package quoridor;

/**
 * WeightedMove extends move to add a gcost and hcost so that a move can be prioritised in a collection
 * 
 * The default equals method has been replaced with a method that uses the superclass Move's equals method
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li> Adds arguments to the constructor to set the weightings
 * </ul>
 */


public class WeightedMove extends Move {
	int gcost;
	int hcost;
	
	WeightedMove parent;
	
	
	public WeightedMove(int x, int y, MoveType dir, int turns, Player player, WeightedMove newparent) {
		super(x, y, dir);
		this.hcost = Math.abs(player.goal() -  y);
		this.gcost = turns;
		this.parent = newparent;
	}
	
	public int weight() {
		return gcost + hcost;
	}
	
	public int hcost() {
		return this.hcost;
	}
	
	public int gcost() {
		return this.gcost;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public WeightedMove parent() {
		return parent;
	}
	
}
