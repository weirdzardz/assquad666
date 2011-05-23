package quoridor;

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
		int weight;
		if (this.gcost == Integer.MAX_VALUE) {
			weight = gcost;
		} else {
			weight = gcost + hcost;
		}
		return weight;
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
