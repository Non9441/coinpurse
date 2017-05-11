package coinpurse.strategy;

import java.util.List;

import coinpurse.Purse;
import coinpurse.Valuable;

public interface WithdrawStrategy {
	 public List<Valuable> withdraw( double amount, List<Valuable> money);
}
