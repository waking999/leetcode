package leetcode.success.bit;

public class SumOfTwoInteger {
	public int getSum(int a, int b) {
		int sum = a;
		int carry = b;

		while (carry != 0) {
			int tmps = sum;
			sum = tmps ^ carry;
			carry = (tmps & carry) << 1;
		}
		return sum;
	}

	public static void main(String[] args) {
		SumOfTwoInteger s = new SumOfTwoInteger();

		int a = 1;
		int b = 2;
		int c = s.getSum(a, b);
		assert (a + b == c) : "1.wrong";

		a = 4;
		b = 6;
		c = s.getSum(a, b);
		assert (a + b == c) : "2.wrong";

		a = 2147483647;
		b = -2147483648;
		c = s.getSum(a, b);
		assert (a + b == c) : "3.wrong";

		System.out.println("Finish");
	}

}
