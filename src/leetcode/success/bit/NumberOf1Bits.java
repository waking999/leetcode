package leetcode.success.bit;

public class NumberOf1Bits {
	public int hammingWeight(int n) {
		long num=n>=0?n:2 * (long) Integer.MAX_VALUE + 2 + n;
				
		int sum = 0;
		while (num != 0) {
			sum += (num & 1);
			num >>= 1;
		}
		return sum;
	}
	
	 

	public static void main(String[] args) {
		NumberOf1Bits s = new NumberOf1Bits();

		int n;
		int expect;
		int output;

		n = 0x00000000000000000000000000001011;
		expect = 3;
		output = s.hammingWeight(n);
		assert (output == expect) : "1.wrong";

		//n = 0x10000000000000000000000000000000;
		n=-2147483648;
		expect = 1;
		output = s.hammingWeight(n);
		assert (output == expect) : "2.wrong";

		System.out.println("Finish");

	}

}
