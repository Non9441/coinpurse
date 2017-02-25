package coinpurse;

public class AbstractValuable implements Valuable {
	public static String DEFAULT_CURRENCY = "Baht";
	double value;
	String currency;

	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Valuable other = (Valuable) obj;
		return (this.value == (other.getValue()) && this.currency.equals(other.getCurrency()));
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}

	@Override
	public int compareTo(Valuable o) {
		if (this.getCurrency() == o.getCurrency()) {
			if (this.getValue() < o.getValue()) {
				return -1;
			} else
				return 1;
		} else
			return (this.getCurrency().compareToIgnoreCase(o.getCurrency()));
	}

}