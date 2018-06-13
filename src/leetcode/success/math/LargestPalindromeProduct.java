package leetcode.success.math;

import leetcode.success.comm.Util;

public class LargestPalindromeProduct {
	public int largestPalindrome(int n) {
		if (n < 1 || n > 8) {
			return -1;
		}
		if(n==1){
            return 9;
        }
		
		int high=(int) Math.pow(10, n)-1;
		int low=high/10;
		for(int i=high;i>low;i--) {
			long palindrome = getPalindrome(i);
			for(long j=high;j>low;j--) {
				if(palindrome/j>high) {
					break;
				}
				if(palindrome%j==0) {
					return (int)(palindrome%1337);
				}
			}
		}
		
		
		return -1;
	}
	 
	  
	private static long getPalindrome(int num) {
        return Long.parseLong(num + (new StringBuilder(String.valueOf(num))).reverse().toString());
    }

 

	public static void main(String[] args) {
		LargestPalindromeProduct s = new LargestPalindromeProduct();

		int n;
		int expect;
		int output;

		n = 2;
		expect = 987;
		output=s.largestPalindrome(n);
		Util.verify(expect, output, 1);
		
		
		n = 1;
		expect = 9;
		output=s.largestPalindrome(n);
		Util.verify(expect, output, 2);
		
		n = 5;
		expect = 677;
		output=s.largestPalindrome(n);
		Util.verify(expect, output, 1);

	}

}
