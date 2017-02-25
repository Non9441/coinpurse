package coinpurse;

public abstract class MoneyFactory {
	protected long nextSerialNumber = 999999;
	private static MoneyFactory factory;

	protected MoneyFactory() {

	}

	public static MoneyFactory getInstance() {
		return factory;
	}
	
	public static void setMoneyFactory(MoneyFactory fac){
		factory = fac;
	}

	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) {
		try {
			return createMoney(Double.parseDouble(value));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();

		}

	}

}
