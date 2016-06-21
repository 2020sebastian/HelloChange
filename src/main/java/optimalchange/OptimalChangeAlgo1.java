package optimalchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sd on 6/18/16.
 */
public class OptimalChangeAlgo1 implements OptimalChangeAlgorithm {

    /**
     * This algorithm starts out in an iterative way trying to return change using the largest bills first
     * If it does not succeed, and there are multiple bills available of several kinds it will remove one bill from the
     * largest pile and will recurse with that input until it finds a good combination.
     * Returns null if no change can be made
     *
     * @param chargeAmount
     * @param currentBills
     * @return List<Integer> representing the optimal combination of change for given amount and available bills
     */
    public List<Integer> getOptimalChange(final int chargeAmount, final List<Integer> currentBills) {

        List<Integer> billsSupported = Arrays.asList(20, 10, 5, 2, 1);
        List<Integer> result         = Arrays.asList( 0,  0, 0, 0, 0);
        ArrayList<Integer> idx = new ArrayList<>();

        int changeLeft = chargeAmount;

        for (int i = 0; i < billsSupported.size(); i++){
            //check if we have at least one available bill of that type, else mark it as unavailable (0)
            final Integer numberOfBillsAvailable = currentBills.get(i);
            final int currentBillValue = numberOfBillsAvailable != 0 ? billsSupported.get(i) : 0;

            if (changeLeft == 0) {
                return result;
            }
            else if (currentBillValue == 0){
                //no bill available, skip
                continue;
            }
            //if we need change for $11 but current bill is 20, skip
            else if (changeLeft >= currentBillValue){
                final int billsNeeded = changeLeft / currentBillValue;
                //get the number of bills needed as long as there are bills available, else set however many there are available
                final int bills = billsNeeded <= numberOfBillsAvailable ? billsNeeded : numberOfBillsAvailable;
                result.set(i, bills);

                // keep track for using later in different change combinations
                if (bills >= 1){
                    idx.add(i);
                }
                changeLeft -= currentBillValue * bills;
            }
        }
        if (changeLeft != 0){
            //try a different change combination
            // instead of trying to build change in a greedy way, first time there is a slot with more than 2 available bills,
            // remove one bill and try to make up the difference with smaller bills

            if (idx.size() > 0){
                for (Integer i : idx) {
                    currentBills.set(i, currentBills.get(i) - 1);
                    return getOptimalChange(chargeAmount, currentBills);
                }
            } else {
                //base case for recursion
                return null;
            }
        }
        return result;
    }
}
