package history;
import org.junit.Assert;

public class NumberOfBits {
	public int hammingWeight(int n) {
		int ones = 0;
		while(n!=0) {
			ones = ones + (n & 1);
			n = n>>>1;
		}
		return ones; 
		
	}

	public static void main(String[] args) {
		NumberOfBits x = new NumberOfBits();

		int a;
		int e;

		a = 11;
		e = 3;
		Assert.assertEquals(e, x.hammingWeight(a));

		a = 255;
		e = 8;
		Assert.assertEquals(e, x.hammingWeight(a));

		a = Integer.MIN_VALUE;
		e = 1;
		Assert.assertEquals(e, x.hammingWeight(a));

		System.out.println("done");

	}

}
