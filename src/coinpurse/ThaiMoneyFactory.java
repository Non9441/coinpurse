package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory{
	private static String currency = "Bath";
	private Double[] existValue = {0.25,0.5,1.0,2.0,5.0,10.0,20.0,50.0,100.0,500.0,1000.0};
	
	public ThaiMoneyFactory() {
		
	}
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
			if(value<20){
				return new Coin(value,currency);
			}
			else {
				super.nextSerialNumber++;
				return new BankNote(value,currency,nextSerialNumber);
			}
		}
	}

}
