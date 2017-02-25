package coinpurse;

public interface Valuable extends Comparable<Valuable>{
	public double getValue();

	public String getCurrency();

	public boolean equals(Object obj);

	public String toString();

}
