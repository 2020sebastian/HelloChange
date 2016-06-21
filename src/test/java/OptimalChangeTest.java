import optimalchange.OptimalChangeAlgo1;
import optimalchange.OptimalChangeAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

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
    @Test
    public void testOptimalChange6() throws Exception {
        CashDrawer cashDrawer = new CashDrawer(1, 0, 3, 4, 0);
        List<Integer> optimalChange = algo.getOptimalChange(8, cashDrawer.getCurrentBills());
        List<Integer> expected = Arrays.asList(0, 0, 0, 4, 0);
        Assert.assertEquals(expected, optimalChange);
    }

    @Test
    public void testOptimalChangeRand3() throws Exception {

        int counter = 0;

        while (counter < 1000) {
            //random numbers between 0 - 10
            int twenty = new Random().nextInt(11);
            int ten = new Random().nextInt(11);
            int five = new Random().nextInt(11);
            int two = new Random().nextInt(10)+1; // 1 - 10
            int one = new Random().nextInt(10)+3; // 3 - 10

            CashDrawer cashDrawer = new CashDrawer(twenty, ten, five, two, one);
            System.out.println(cashDrawer);

            List<Integer> optimalChange = algo.getOptimalChange(3, cashDrawer.getCurrentBills());
            System.out.println(optimalChange);

            List<Integer> expected1 = Arrays.asList(0, 0, 0, 1, 1); // 3 in change
            List<Integer> expected2 = Arrays.asList(0, 0, 0, 0, 3); // 3 in change

            assertTrue(expected1.equals(optimalChange) || expected2.equals(optimalChange));
            counter++;
        }

    }


    @Test
    public void testOptimalChangeRand6() throws Exception {

        int counter = 0;

        while (counter < 1000) {
            //random numbers between 0 - 10
            int twenty = new Random().nextInt(11);
            int ten = new Random().nextInt(11);
            int five = new Random().nextInt(2); // 0 or 1
            int two = new Random().nextInt(2); // 1 or 2
            int one = new Random().nextInt(5)+6; // 6 - 10

            CashDrawer cashDrawer = new CashDrawer(twenty, ten, five, two, one);
            System.out.println(cashDrawer);

            List<Integer> optimalChange = algo.getOptimalChange(6, cashDrawer.getCurrentBills());
            System.out.println(optimalChange);

            List<Integer> expected1 = Arrays.asList(0, 0, 1, 0, 1); // 6 in change
            List<Integer> expected2 = Arrays.asList(0, 0, 0, 0, 6); // 6 in change
            List<Integer> expected3 = Arrays.asList(0, 0, 0, 3, 0); // 6 in change
            List<Integer> expected4 = Arrays.asList(0, 0, 0, 2, 2); // 6 in change
            List<Integer> expected5 = Arrays.asList(0, 0, 0, 1, 4); // 6 in change

            assertTrue(expected1.equals(optimalChange) ||
                       expected2.equals(optimalChange) ||
                       expected3.equals(optimalChange) ||
                       expected4.equals(optimalChange) ||
                       expected5.equals(optimalChange));

            counter++;
        }

    }




}
