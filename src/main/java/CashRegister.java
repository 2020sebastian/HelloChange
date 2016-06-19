import util.Util;

import java.util.List;
import java.util.Scanner;

/**
 * Created by sd on 6/18/16.
 */
public class CashRegister {

    public CashDrawer cashDrawer;

    public void loadInitialAmount(int twenties, int tens, int fives, int twos, int ones) {
        cashDrawer = new CashDrawer(twenties, tens, fives, twos, ones);
    }


    public void start() {

        Util.printHelp();

        System.out.println("Total $20 $10 $5 $2 $1");
        System.out.println(cashDrawer);
        System.out.println();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a command: ");
        while (scanner.hasNext()) {

            //get next input line and convert to lowercase to accomodate Help vs. help, etc
            String[] input = scanner.nextLine().toLowerCase().split(" ");
            String command = input[0].replace("\n", "").replace(" ", "");

            if (command.length() == 0) {
                continue; // skip empty returns
            }

            switch (command) {
                case "show":
                    cashDrawer.showCurrentState();
                    break;

                case "put":
                    List<Integer> billsToPut = Util.convertToInts(input);
                    if (billsToPut.size() != 5) {
                        System.out.println("Invalid input. Please type \"help\" for correct usage.");
                        break;
                    }
                    cashDrawer.put(billsToPut);
                    cashDrawer.showCurrentState();
                    break;

                case "take":
                    List<Integer> billsToTake = Util.convertToInts(input);
                    if (billsToTake.size() != 5) {
                        System.out.println("Invalid input. Please type \"help\" for correct usage.");
                        break;
                    }
                    cashDrawer.take(billsToTake);
                    cashDrawer.showCurrentState();
                    break;

                case "change":
                    List<Integer> changeBills = Util.convertToInts(input);
                    cashDrawer.change(changeBills);
                    break;

                case "help":
                    Util.printHelp();
                    break;

                case "quit":
                    Util.exit();
                    break;

                default:
                    System.out.println("Could not interpret command:" + command + " Please type \"help\" for correct usage");
            }

        }
    }

}
