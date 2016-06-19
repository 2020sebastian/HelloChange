import optimalchange.OptimalChangeAlgo1;
import optimalchange.OptimalChangeAlgorithm;
import util.Util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sd on 6/18/16.
 */
public class CashDrawer {

    private OptimalChangeAlgorithm algo = new OptimalChangeAlgo1();

    private int twenties;
    private int tens;
    private int fives;
    private int twos;
    private int ones;

    public CashDrawer(int twenties, int tens, int fives, int twos, int ones) {
        this.twenties = twenties;
        this.tens = tens;
        this.fives = fives;
        this.twos = twos;
        this.ones = ones;
    }

    public void put(List<Integer> bills) {
        if (bills.size() != 5){
            System.out.println("Invalid input. Please type \"help\" for correct usage.");
            return;
        }
        twenties = Util.add(twenties, bills.get(0));
        tens = Util.add(tens, bills.get(1));
        fives = Util.add(fives, bills.get(2));
        twos = Util.add(twos, bills.get(3));
        ones = Util.add(ones, bills.get(4));
    }

    public void take(List<Integer> bills) {
        twenties = Util.subtract(twenties, bills.get(0));
        tens = Util.subtract(tens, bills.get(1));
        fives = Util.subtract(fives, bills.get(2));
        twos = Util.subtract(twos, bills.get(3));
        ones = Util.subtract(ones, bills.get(4));
    }

    public void change(List<Integer> integers) {
        int amount = integers.get(0);

        List<Integer> optimalChange = algo.getOptimalChange(amount, getCurrentBills());

        if (optimalChange == null){
            System.out.println("Sorry, no change can be made.");
        }
        else {
            printOptimalChange(optimalChange);
            take(optimalChange);
        }

    }

    private int total() {
        return twenties * 20 + tens * 10 + fives * 5 + twos * 2 + ones;
    }

    public List<Integer> getCurrentBills(){
        return Arrays.asList(twenties, tens, fives, twos, ones);
    }

    public void showCurrentState() {
        System.out.println(this);
    }

    private void printOptimalChange(List<Integer> list){
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "$" + total() + " " + twenties + " " + tens + " " + fives + " " + twos + " " + ones;
    }
}
