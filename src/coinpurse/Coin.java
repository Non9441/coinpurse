package coinpurse;

/**
 * Coin is a money with it's value and it's currency.
 * 
 * @author Non Puthikanon
 */
public class Coin extends AbstractValuable {
	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 *            is value of the coin you define.
	 */
	public Coin(double value) {
		super(value, DEFAULT_CURRENCY);
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 *            is value of the coin you define.
	 * @param currency
	 *            is a currency of the coin you define.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * return String of value and currency of this coin.
	 * 
	 * @return String of value and currency of this coin.
	 */
	public String toString() {
		if (currency.equalsIgnoreCase("sen")) {
			return value * 100 + " " + currency;
		} else
			return value + " " + currency;
	}

}
