package leetcode.success.math;

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

 


}
