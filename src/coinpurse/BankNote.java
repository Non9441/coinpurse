package coinpurse;

public class BankNote implements Valuable {
	public String DEFAULT_CURRENCY = "Baht";
	private double value;
	private String currency;
	private static long nextSerialNumber = 1000000;
	private long serialNumber;

	public BankNote(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
		this.serialNumber = this.nextSerialNumber;
		this.nextSerialNumber++;
	}

	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = this.nextSerialNumber;
		this.nextSerialNumber++;
	}
	
	public long getSerial(){
		return serialNumber;
	} 

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	public boolean equals(Object obj) {
    	if(obj == null)
    		return false;
    	if(this.getClass()!=obj.getClass())
    		return false;
    	BankNote other = (BankNote)obj;
    	return(this.value==(other.value)&&this.currency.equals(other.currency));
    }
	
	public String toString(){
		return (this.value+" "+this.currency+" note"+this.serialNumber);
	}

}
