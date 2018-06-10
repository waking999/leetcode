package leetcode.success.bit;

public class ReverseBits {
	public int reverseBits(int n) {
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			ret <<= 1;
			if ((n & 1) == 1) {
				ret++;
			}
			n >>= 1;
		}

		return ret;
	}

	public static void main(String[] args) {
		ReverseBits s = new ReverseBits();

		int n;
		int expect;
		int output;

		n = 43261596;
		expect = 964176192;
		output = s.reverseBits(n);
		assert (expect == output) : "1:wrong";

		System.out.println("Finish");

	}

}
