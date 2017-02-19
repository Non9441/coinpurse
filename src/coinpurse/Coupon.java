package coinpurse;

public class Coupon implements Valuable{
	private double value;
	private String currency;
	private String color;
	
	public Coupon(double value, String currency, String color){
		this.value = value;
		this.currency = currency;
		this.color = color;
	}

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}
	
	public String toString(){
		return (this.value+" "+this.currency+" "+this.color+" Coupon");
	}
}