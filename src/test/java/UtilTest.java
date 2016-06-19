import org.junit.Assert;
import org.junit.Test;
import util.Util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sd on 6/18/16.
 */
public class UtilTest {

    @Test
    public void testConvertToInts1() throws Exception {
        String [] rawInput = new String[] {"1", "2", "3", "4", "5", "6"};
        List<Integer> convertedInput = Util.convertToInts(rawInput);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assert.assertTrue(expected.equals(convertedInput));
    }

    @Test
    public void testConvertToIntsSkipString1() throws Exception {
        String [] rawInput = new String[] {"String", "2", "3", "4", "5", "6"};
        List<Integer> convertedInput = Util.convertToInts(rawInput);
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 6);
        Assert.assertTrue(expected.equals(convertedInput));
    }

    @Test
    public void testConvertToIntsSkipString2() throws Exception {

        //test for Integer.MAX_VALUE
        String [] rawInput = new String[] {"String", "2147483647", "3", "4", "String", "6"};
        List<Integer> convertedInput = Util.convertToInts(rawInput);
        List<Integer> expected = Arrays.asList(2147483647, 3, 4, 6);
        Assert.assertTrue(expected.equals(convertedInput));
    }

    @Test
    public void testConvertToIntsSkipString3() throws Exception {

        //test for Integer.MAX_VALUE + 1, should ignore the value
        String [] rawInput = new String[] {"String", "2147483648", "3", "4", "String", "6"};
        List<Integer> convertedInput = Util.convertToInts(rawInput);
        List<Integer> expected = Arrays.asList(3, 4, 6);
        Assert.assertTrue(expected.equals(convertedInput));
    }

    @Test
    public void testConvertToIntsSkipString4() throws Exception {

        //test for negative value
        String [] rawInput = new String[] {"0", "-2", "3", "4", "5", "6"};
        List<Integer> convertedInput = Util.convertToInts(rawInput);
        List<Integer> expected = Arrays.asList(0, 3, 4, 5, 6);
        Assert.assertTrue(expected.equals(convertedInput));
    }
}
