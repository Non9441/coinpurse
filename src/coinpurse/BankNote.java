package coinpurse;

public class BankNote extends AbstractValuable {
	private long serialNumber;

	public BankNote(double value, String currency, long serialNumber) {
		super(value, currency);
		this.serialNumber = serialNumber;
	}

	public long getSerial() {
		return serialNumber;
	}

	public String toString() {
		return (this.value + " " + this.currency + " note " + "["+this.serialNumber+"]");
	}

}
