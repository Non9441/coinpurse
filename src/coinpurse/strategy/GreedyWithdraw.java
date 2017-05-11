package coinpurse.strategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Purse;
import coinpurse.Valuable;
import coinpurse.strategy.WithdrawStrategy;

public class GreedyWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		List<Valuable> templist = new ArrayList<Valuable>();

		if (amount < 0) {
			return null;
		}
		Collections.sort(money, new Comparator<Valuable>() {

			@Override
			public int compare(Valuable o1, Valuable o2) {
				if (o1.getValue() > o2.getValue()) {
					return 1;
				}
				if (o1.getValue() < o2.getValue()) {
					return -1;
				}
				return 0;
			}
		});
		Collections.reverse(money);

		for (Valuable x : money) {
			if (amount > 0) {
				if (x.getValue() <= amount) {
					amount -= x.getValue();
					templist.add(x);
				}
			}
		}
		if (amount == 0) {
			return templist;
		}
		return null;

	}

}
