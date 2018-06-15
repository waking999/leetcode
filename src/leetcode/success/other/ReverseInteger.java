package leetcode.success.other;

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



}
