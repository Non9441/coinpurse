package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  When you withdraw money, the coin purse decides which
 *  coins to remove.
 *  
 *  @author Non Puthikanon
 */
public class Purse {
    /** Collection of objects in the purse. */
    /** Capacity is maximum number of coins the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    private List<Coin> money = new ArrayList<Coin>();
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() {
    	return this.money.size();
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	double sum = 0;
    	for(Coin x: money){
    		sum += x.getValue();
    	}
    	return sum;
    }

    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() {
    	return this.capacity;
    }
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
    	return(money.size()>=this.capacity);
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
    	if(this.isFull())
    	{
    		return false;
    	}
    	if(coin==null)
    	{
    		return false;
    	}
    	if(coin.getValue()<=0)
    	{
    		return false;
    	}
    	this.money.add(coin);
        return true;
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
    	
    	List<Coin> templist = new ArrayList<Coin>();
    	
		if ( amount < 0 )
		{	
			return null;
		}
		if ( amount > this.getBalance() )
		{
			return null;
		}
		Collections.sort(this.money);
		Collections.reverse(this.money);
		
		for(Coin x : money){
			if(amount>0)
			{
				if(x.getValue()<=amount)
				{
					amount -= x.getValue();
					templist.add(x);
				}
			}
		}
		if( amount==0 )
		{
			for(Coin x : templist){
				this.money.remove(x);
			}
			Coin[] withdraw = new Coin[templist.size()];
	        templist.toArray(withdraw);
	        return withdraw;
		}
		return null;
        
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	return "Total Balance : "+this.getBalance()+"\n"+"Coin left : "+this.count()+"\n"+"Purse Capacity : "+this.getCapacity();
    }

}
