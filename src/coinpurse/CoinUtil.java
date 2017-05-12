package coinpurse;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 */
public class CoinUtil {
	
	public static <E extends Comparable<? super E>> E max(E ...a) {
		E max = a[0];
		for(int i = 0 ; i < a.length ; i++){
			if(a[i].compareTo(max)>0) {
				max = a[i];
			}
		} return max;
	}

	/**
	 * Method that examines all the coins in a List and returns
	 * only the coins that have a currency that matches the parameter value.
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coin list
	 *     that have the requested currency.  
	 */
	public static <E extends Valuable>List<E> filterByCurrency(final List<E> moneylist, String currency) {
		Predicate<E> sameCurrency = (e) -> (e.getCurrency()==currency);
		return moneylist.stream().filter(sameCurrency).collect(Collectors.toList());
		
	}
	

	/**
	 * Method to sort a list of coins by currency.
	 * On return, the list (coins) will be ordered by currency.
	 * @param coins is a List of Coin objects we want to sort. 
	 *
	 * TODO:
	 * 1. Write a Comparator<Coin> (you can write the class at the end of this file.
	 *    Declare it as "class CompareByCurrency" without the "public").
	 *    You can also write Comparator as an anonymous class, if you know how.
	 *    The compare method should order coins by currency.
	 * 2. Create a comparator instance and use it to sort the coins.
	 */
	public static void sortByCurrency(List<? extends Valuable> money) {
		money.sort(new Comparator<Valuable>(){
			public int compare(Valuable m1, Valuable m2){
				return m1.getCurrency().compareToIgnoreCase(m2.getCurrency());
			}
		});
	}
	
	/**
	 * Sum coins by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * For example: 
	 * coins = { Coin(1,"Baht"), Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") }
	 * then sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht
	 * 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> money) {
		Map<String, Double> currencymap = new HashMap<String, Double>();
		for(Valuable x : money){
			if(currencymap.containsKey(x.getCurrency()))
			{
				currencymap.put(x.getCurrency(), currencymap.get(x.getCurrency())+x.getValue());
			}
			else
			{
				currencymap.put(x.getCurrency(), x.getValue());
			}
		}
		for(String currency : currencymap.keySet()){
			System.out.println(currencymap.get(currency)+" : "+currency);
		}

	}
	
	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of "+currency);
		List<Valuable> money = makeInternationalCoins();
		int size = money.size();
		System.out.print(" INPUT: "); printList(money," ");
		List<Valuable> rupees = filterByCurrency(money, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (money.size() != size) System.out.println("Error: you changed the original list.");
		
		System.out.println("\nSort coins by currency");
		money = makeInternationalCoins();
		System.out.print(" INPUT: "); printList(money," ");
		sortByCurrency(money);
		System.out.print("RESULT: "); printList(money," ");
		
		System.out.println("\nSum coins by currency");
		money = makeInternationalCoins();
		System.out.print("coins= "); printList(money," ");
		sumByCurrency(money);
//		List<BankNote> c = Arrays.asList(new BankNote(20,"",10000), new BankNote(100,"Bath",1000));
//		List<BankNote> co = CoinUtil.filterByCurrency(c, "Bath");
//		
//		Valuable max = CoinUtil.max(new Coin(5), new Coin(10), new Coin(2), new BankNote(20,"Bath",10000));
//		System.out.println(max.getValue());
		
		
	}
	
	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}
	
	/** Make a list of coins using given values. */ 
	public static List<Coin> makeCoins(String currency, double ... values) {
		List<Coin> list = new ArrayList<Coin>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}
	
	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);
			
		}
		System.out.println(); // end the line
	}
}
