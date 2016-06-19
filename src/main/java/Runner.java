/**
 * Created by sd on 6/18/16.
 */
public class Runner {

    public static void main(final String[] args) {

        final CashRegister register = new CashRegister();

        register.loadInitialAmount(1, 2, 3, 4, 5);

        register.start();

    }
}
