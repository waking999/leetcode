package leetcode.success.nowhere;

import leetcode.success.comm.Util;

public class BinaryNumberwithAlternatingBits {
	public boolean hasAlternatingBits(int n) {
		int comp = 1 - n % 2;
		n = n / 2;

		while (n != 0) {
			int a = n % 2;
			if (comp != a) {
				return false;
			}
			comp = 1 - a;
			n = n / 2;
		}

		return true;
	}

	public static void main(String[] args) {
		BinaryNumberwithAlternatingBits s = new BinaryNumberwithAlternatingBits();

		int n;
		boolean expect;
		boolean output;
		int seq = 0;

		n = 5;
		expect = true;
		output = s.hasAlternatingBits(n);
		Util.verify(expect, output, ++seq);

		n = 7;
		expect = false;
		output = s.hasAlternatingBits(n);
		Util.verify(expect, output, ++seq);

		n = 11;
		expect = false;
		output = s.hasAlternatingBits(n);
		Util.verify(expect, output, ++seq);

		n = 10;
		expect = true;
		output = s.hasAlternatingBits(n);
		Util.verify(expect, output, ++seq);
	}

}
