package optimalchange;

import java.util.List;

/**
 * Created by sd on 6/18/16.
 */
public interface OptimalChangeAlgorithm {

    List<Integer> getOptimalChange(final int chargeAmount, final List<Integer> currentBills);

}
