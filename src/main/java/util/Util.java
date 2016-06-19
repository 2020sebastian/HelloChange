package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sd on 6/18/16.
 */
public class Util {

    public static void printHelp() {
        System.out.println("--------------- Usage ------------------");
        System.out.println(" $> show                                 - shows current state in total and each denomination ");
        System.out.println(" $> put <int> <int> <int> <int> <int>    - put bills in each denomination: #$20 #$10 #$5 #$2 #$1 ");
        System.out.println(" Example: > put 1 2 3 0 5                - will insert 1 x $20, 2 x $10, 3 x $5, 0 x $2, 5 x $1");
        System.out.println(" $> take <int> <int> <int> <int> <int>   - take bills in each denomination: #$20 #$10 #$5 #$2 #$1");
        System.out.println(" Example: > take 1 4 3 0 10              - will take 1 x $20, 4 x $10, 3 x $5, 0 x $2, 10 x $1");
        System.out.println(" $> change 11                            - will remove that amount from the register");
        System.out.println(" $> quit                                 - will exit the program");
        System.out.println(" $> help                                 - will show this list of commands");
        System.out.println("----------------------------------------");
        System.out.println();
    }

    public static void exit() {
        System.out.println("Exiting ...");
        System.exit(0);
    }

    /**
     * util method which will convert an array of inputs to Integers
     * Any values which are not positive integers will be ignored
     * @param values
     * @return List of Integers
     */
    public static List<Integer> convertToInts(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            try{
                int value = Integer.parseInt(values[i]);
                if (value >= 0){
                    result.add(value);
                }
            } catch (NumberFormatException e ){
                //skip anything that's not an integer
            }
        }
        return result;
    }

    public static int subtract(int current, int value){
        if (value < 0){
            System.out.println("Invalid input: " + value + ". Please provide a positive value");
            return current;
        }
        int result;
        if ((result = current - value) >= 0){
            current = result;
        }
        return current;
    }

    public static int add(int current, int value){
        if (value < 0){
            System.out.println("Invalid input: " + value + ". Please provide a positive value");
            return current;
        }
        return current + value;
    }
}
