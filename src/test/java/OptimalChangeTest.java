import optimalchange.OptimalChangeAlgo1;
import optimalchange.OptimalChangeAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sd on 6/18/16.
 */
public class OptimalChangeTest {

    OptimalChangeAlgorithm algo = new OptimalChangeAlgo1();

    @Test
    public void testOptimalChange1() throws Exception {
        CashDrawer cashDrawer = new CashDrawer(1, 1, 1, 1, 1);
        List<Integer> optimalChange = algo.getOptimalChange(38, cashDrawer.getCurrentBills());
        List<Integer> expected = Arrays.asList(1, 1, 1, 1, 1); // = 38
        Assert.assertEquals(expected, optimalChange);
    }

    @Test
    public void testOptimalChange2() throws Exception {

        CashDrawer cashDrawer = new CashDrawer(1, 1, 1, 1, 1);
        //Take one $20 bill out
        cashDrawer.take(Arrays.asList(1, 0, 0, 0, 0));

        Assert.assertEquals(Arrays.asList(0, 1, 1, 1, 1), cashDrawer.getCurrentBills());

        //No $20 bills available
        List<Integer> optimalChange = algo.getOptimalChange(18, cashDrawer.getCurrentBills());
        List<Integer> expected = Arrays.asList(0, 1, 1, 1, 1); // = 38
        Assert.assertEquals(expected, optimalChange);

    }

    @Test
    public void testOptimalChange3() throws Exception {

        CashDrawer cashDrawer = new CashDrawer(1, 1, 1, 1, 1);
        //Take one $20 bill out
        cashDrawer.take(Arrays.asList(0, 0, 0, 0, 1));

        Assert.assertEquals(Arrays.asList(1, 1, 1, 1, 0), cashDrawer.getCurrentBills());
        //No $20 bills available
        List<Integer> optimalChange = algo.getOptimalChange(3, cashDrawer.getCurrentBills());
        Assert.assertEquals(null, optimalChange);
    }

    @Test
    public void testOptimalChange4() throws Exception {
        CashDrawer cashDrawer = new CashDrawer(1, 0, 3, 4, 0);
        List<Integer> optimalChange = algo.getOptimalChange(11, cashDrawer.getCurrentBills());
        List<Integer> expected = Arrays.asList(0, 0, 1, 3, 0); // 11
        Assert.assertEquals(expected, optimalChange);
    }

    @Test
    public void testOptimalChange5() throws Exception {
        CashDrawer cashDrawer = new CashDrawer(1, 1, 3, 4, 0);
        List<Integer> optimalChange = algo.getOptimalChange(3, cashDrawer.getCurrentBills());
        Assert.assertEquals(null, optimalChange);
    }
}
