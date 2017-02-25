package coinpurse;
 
/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Non Puthikanon
 */
public class Main {
	
	private static int CAPACITY = 10;
    /**
     * Configure and start the application.
     * @param args not used
     */
    public static void main( String[] args ) {
        // 1. create a Purse
    	Purse purse = new Purse(CAPACITY);
    	MoneyFactory factory = new MalayMoneyFactory();
    	MoneyFactory.setMoneyFactory(factory);
        // 2. create a ConsoleDialog with a reference to the Purse object
    	ConsoleDialog ui = new ConsoleDialog(purse,factory);
        // 3. run the ConsoleDialog
    	ui.run();

    }
}
