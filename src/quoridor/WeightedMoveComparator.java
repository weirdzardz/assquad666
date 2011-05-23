package quoridor;

import java.util.Comparator;

public class WeightedMoveComparator implements Comparator<WeightedMove>{

	@Override
	public int compare(WeightedMove arg0, WeightedMove arg1) {
		int difference = arg0.weight() - arg1.weight();
		return difference;
	}

}
