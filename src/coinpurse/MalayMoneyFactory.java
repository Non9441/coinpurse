package coinpurse;

public class MalayMoneyFactory extends MoneyFactory{
	private static String currency = "Ringgit";
	private static String subCurrency = "Sen";
	private Double[] existValue = {0.05,0.10,0.20,0.50,1.0,2.0,5.0,10.0,20.0,50.0,100.0};

	@Override
	public Valuable createMoney(double value) {
		boolean isExist = false;
		for (double x : existValue) {
			if (x == value) {
				isExist = true;
			}
		}
		if(!isExist){
			throw new IllegalArgumentException();
		}
		else{
			if(value<1){
				return new Coin(value,subCurrency);
			}
			else {
				super.nextSerialNumber++;
				return new BankNote(value,currency,nextSerialNumber);
			}
		}
	}

}
