package leetcode.success.math;

import leetcode.success.comm.Util;

public class ArrangingCoins {
	public int arrangeCoins(int n) {
		 return (int) (Math.sqrt(2*(long)n+0.25) - 0.5);

	}

	public static void main(String[] args) {
		ArrangingCoins s = new ArrangingCoins();

		int n;
		int expect;
		int output;

		n = 5;
		expect = 2;
		output = s.arrangeCoins(n);
		Util.verify(expect, output, 1);

		n = 8;
		expect = 3;
		output = s.arrangeCoins(n);
		Util.verify(expect, output, 2);

		n = 10;
		expect = 4;
		output = s.arrangeCoins(n);
		Util.verify(expect, output, 3);

		System.out.println("Finish");
	}

}
