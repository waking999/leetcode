package leetcode.success.array;

import java.util.Arrays;

public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		if (s == null) {
			return true;
		}
		s = s.trim();
		int sLen = s.length();
		if (sLen == 0) {
			return true;
		}

		char[] sArr = s.toCharArray();

		return isPalindrome(sArr, 1);
	}

	private boolean isPalindrome(char[] sArr, int n) {
		if (n < 0) {
			return false;
		}
		int sLen = sArr.length;
		if(sLen<=1) {
			return true;
		}
		int low = 0;
		int high = sLen - 1;

		for (; low <= high; low++, high--) {
			if (sArr[low] != sArr[high]) {
				n--;
				char[] sArr1 = Arrays.copyOfRange(sArr, low + 1, high+1);
				char[] sArr2 = Arrays.copyOfRange(sArr, low, high);
				boolean flag1=isPalindrome(sArr1, n);
				if(flag1) {
					return true;
				}
                return isPalindrome(sArr2, n);

            }

		}
		return true;

	}



}
