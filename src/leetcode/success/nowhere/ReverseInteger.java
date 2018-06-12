package leetcode.success.nowhere;

import leetcode.success.comm.Util;

public class ReverseInteger {
	public int reverse(int x) {
		 
		long y = 0;
		boolean neg = !(x == Math.abs(x));
		if (neg) {
			x = Math.abs(x);
		}
		while (x != 0) {
			y = y * 10 + x % 10;
			x = x / 10;
		}

		if (neg) {
			y = 0 - y;
		}

		if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) y;
	}

	public static void main(String[] args) {
		ReverseInteger s = new ReverseInteger();

		int x;
		int expect;
		int output;
		int seq = 0;

		x = 123;
		expect = 321;
		output = s.reverse(x);
		Util.verifyUnsort(expect, output, seq++);

		x = -123;
		expect = -321;
		output = s.reverse(x);
		Util.verifyUnsort(expect, output, seq++);

		x = 1534236469;
		expect = 0;
		output = s.reverse(x);
		Util.verifyUnsort(expect, output, seq++);

	}

}
