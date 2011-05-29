package quoridor;

import java.util.Comparator;

/**
 * WeightedMoveComparator compares Weighted Moves based only on the weight
 * 
 * <h2>Implementation</h2>
 * <ul>
 * <li> Override the compare method to compare only the weight
 * </ul>
 */


public class WeightedMoveComparator implements Comparator<WeightedMove>{

	@Override
	public int compare(WeightedMove arg0, WeightedMove arg1) {
		int difference = arg0.weight() - arg1.weight();
		return difference;
	}

}
