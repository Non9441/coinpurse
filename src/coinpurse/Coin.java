package coinpurse;

/**
 * Coin is a money with it's value and it's currency.
 * @author Non Puthikanon
 */
public class Coin implements Comparable<Coin>{
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private final double value;
    /** The currency, of course. */
    private final String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value is value of the coin you define.
     */
    public Coin( double value ) {
        this.value = value;
        this.currency = this.DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value is value of the coin you define.
     * @param currency is a currency of the coin you define.
     */
    public Coin( double value, String currency ) {
    	this.value = value;
    	this.currency = currency;
 
    }

    /**
     * return the value of this coin.
     * @return the value of this coin.
     */
    public double getValue( ) {
    	return this.value;
    } 
    
    /**
     * return the String of currency of this coin.
     * @return the String of currency of this coin.
     */
    public String getCurrency() {
    	return this.currency;
    }
    
    /**
     * check the attribute of two object and return if it same or not.
     * @param obj is an Object you want to check.
     * @return true if attribute of two object is equal, otherwise return false.
     */
    public boolean equals(Object obj) {
    	if(obj == null)
    		return false;
    	if(this.getClass()!=obj.getClass())
    		return false;
    	Coin other = (Coin)obj;
    	return(this.value==(other.value)&&this.currency.equals(other.currency));
    }
    
    /**
     * compare two object and return int by the condition.
     * @param obj is an Object you want to compare with.
     * @return negative if this object in parameter come after, positive if it should come first, otherwise return zero.
     */
    public int compareTo(Coin other){
    	if(this.value==other.value)
    		return 0;
    	if(this.value<other.value)
    		return-1;
    	if(this.value>other.value)
    		return 1;
    	return 0;
    }
    
    /**
     * return String of value and currency of this coin.
     *@return String of value and currency of this coin.
     */
    public String toString() { 
    	return value+" "+currency; 
    }
   
    
}
