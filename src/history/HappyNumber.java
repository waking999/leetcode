package history;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class HappyNumber {
	public boolean isHappy(int n) {

		Set<Integer> historyNum = new HashSet<Integer>();

		while (true) {
			n = digitPower(n);
			if (n == 1)
				return true;
			if (historyNum.contains(n)) {
				return false;
			} else {
				historyNum.add(n);
			}
		}

		
	}

	private int digitPower(int n) {

		int sum = 0;
		do {
			int m = n % 10;
			n = (n - m) / 10;
			sum += m * m;
		} while (n != 0);

		return sum;
	}

	public static void main(String[] args) {
		HappyNumber x = new HappyNumber();

		int a;

		a = 19;
		//Assert.assertEquals(82, x.digitPower(19));
		Assert.assertTrue(x.isHappy(a));
		
		System.out.println("done");

	}

}
