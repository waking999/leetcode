package leetcode.success.array;

import leetcode.success.comm.Util;

public class GuessNumberHigherOrLower {
	int real;

	public int guessNumber(int n) {
		int low = 1;
		int high = n;

		while (low < high) {
			int mid = low + (high - low) / 2;
			int g = guess(mid);
			if (g == 0) {
				return mid;
			} else if (g == 1) {

				low = mid + 1;
			} else {
				high = mid-1;
			}
		}
		return low;
	}

	/**
	 * @param num,
	 * your guess
	 * @return -1 if my number is lower, 1 if my number is higher, otherwise
	 * return 0
	 */
	private int guess(int num) {
		if (real < num) {
			return -1;
		} else if (num < real) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		GuessNumberHigherOrLower s = new GuessNumberHigherOrLower();

		int n;
		int expect;
		int output;
		int seq = 0;

		n = 10;
		s.real = 6;
		expect = 6;
		output = s.guessNumber(n);
		Util.verify(expect, output, seq++);

		n = 10;
		s.real = 1;
		expect = 1;
		output = s.guessNumber(n);
		Util.verify(expect, output, seq++);

		n = 10;
		s.real = 5;
		expect = 5;
		output = s.guessNumber(n);
		Util.verify(expect, output, seq++);

	}

}
