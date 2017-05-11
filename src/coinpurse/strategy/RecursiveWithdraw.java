package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {
		if (money.isEmpty()&&amount!=0) {
			return null;
		}
		if (amount == 0) {
			return new ArrayList<>();
		}
		if (amount > 0) {
			double ans = amount - money.get(0).getValue();
			int size = money.size();
			List<Valuable> left = withdraw(ans, money.subList(1, money.size()));
			List<Valuable> right = withdraw(amount, money.subList(1, money.size()));
			if (left == null) {

			} else {
				left.add(money.get(0));
				return left;
			}
			if (right == null) {

			} else {
				return right;
			}
		}
		return null;
		//// List<Valuable> m = new ArrayList<Valuable>();
		//// m.addAll(money);
		// List<Valuable> value = new ArrayList<Valuable>();
		// if (amount == 0) {
		// return value;
		// }
		// if (amount < 0) {
		// return null;
		// }
		// if (money.size()<=0) {
		// return null;
		// }
		// // double a = amount;
		// // double b = amount - money.get(0).getValue();
		// if (withdraw(amount - money.get(0).getValue(), money.subList(1,
		//// money.size())) != null) {
		// value.add(money.get(0));
		// return withdraw(amount - money.get(0).getValue(), money.subList(1,
		//// money.size()));
		// } else {
		// return withdraw(amount, money.subList(1, money.size()));
		// }

	}

}
