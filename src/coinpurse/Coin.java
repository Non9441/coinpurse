package coinpurse;
//TODO fix this Javadoc. It should be written as a COMPLETE SENTENCE WITH PERIOD.
/**
 * a coin with a monetary value and currency
 * @author
 */
//TODO declare that Coin implements Comparable<Coin>
public class Coin implements Comparable<Coin>{
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin( double value ) {
        this.value = value;
        this.currency = this.DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
    	this.value = value;
    	this.currency = currency;
 
    }

//TODO Write a getValue() method and javadoc.
    public double getValue( ) {
    	return this.value;
    } 
    
//TODO Write a getCurrency() method and javadoc.
    public String getCurrency() {
    	return this.currency;
    }
    
//TODO Write an equals(Object) method.
    public boolean equals(Object obj) {
    	if(obj == null)
    		return false;
    	if(this.getClass()!=obj.getClass())
    		return false;
    	Coin other = (Coin)obj;
    	return(this.value==(other.value)&&this.currency.equals(other.currency));
    }
    
//TODO Write a compareTo method and implement Comparable.
    public int compareTo(Coin other){
    	if(this.value==other.value)
    		return 0;
    	if(this.value<other.value)
    		return-1;
    	if(this.value>other.value)
    		return 1;
    	return 0;
    }
    
//TODO write a toString() method. See labsheet for what to return.
    public String toString() { 
    	return value+" "+currency; 
    }
    
//TODO Write good Javadoc comments on all methods.
    
}
//TODO remove the TODO comments after you complete them! Including this one!
