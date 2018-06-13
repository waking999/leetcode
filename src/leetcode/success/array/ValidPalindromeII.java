package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;

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

	public static void main(String[] args) {
		ValidPalindromeII s = new ValidPalindromeII();

		String str;
		boolean expect;
		boolean output;

		str = "aba";
		expect = true;
		output = s.validPalindrome(str);
		Util.verify(expect, output, 1);

		str = "abca";
		expect = true;
		output = s.validPalindrome(str);
		Util.verify(expect, output, 2);

		str = "abc";
		expect = false;
		output = s.validPalindrome(str);
		Util.verify(expect, output, 3);

		str = "tcaac";
		expect = true;
		output = s.validPalindrome(str);
		Util.verify(expect, output, 4);

		str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		expect = true;
		output = s.validPalindrome(str);
		Util.verify(expect, output, 5);

		System.out.println("Finish");
	}

}
