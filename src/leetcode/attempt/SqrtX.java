package leetcode.attempt;

import leetcode.success.comm.Util;

public class SqrtX {
	public int mySqrt(int x) {

		if (x <= 1) {
			return x;
		}
		 
		int l = 0, h = x;

		while (l   < h) {
			int m = l + (h - l) / 2;
			int n = x / m;
			if (m <= n) {
				return m;
			} else {
				l = n;
				h = m;
			}
		}


		return l;
	}

	public static void main(String[] args) {
		SqrtX s = new SqrtX();

		int x;
		int expect;
		int output;
		int seq = 0;

		x = 1;
		expect = (int) Math.sqrt(x);
		output = s.mySqrt(x);
		Util.verifyUnsort(expect, output, seq++);

		x = 2;
		expect = (int) Math.sqrt(x);
		output = s.mySqrt(x);
		Util.verifyUnsort(expect, output, seq++);

		x = 4;
		expect = (int) Math.sqrt(x);
		output = s.mySqrt(x);
		Util.verifyUnsort(expect, output, seq++);

		x = 9;
		expect = (int) Math.sqrt(x);
		output = s.mySqrt(x);
		Util.verifyUnsort(expect, output, seq++);

		x = 2147395599;
		expect = (int) Math.sqrt(x);
		output = s.mySqrt(x);
		Util.verifyUnsort(expect, output, seq++);

		x = 2147483647;
		expect = (int) Math.sqrt(x);
		output = s.mySqrt(x);
		Util.verifyUnsort(expect, output, seq++);

	}

}
