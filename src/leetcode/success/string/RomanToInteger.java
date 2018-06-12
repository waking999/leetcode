package leetcode.success.string;

import leetcode.success.comm.Util;

public class RomanToInteger {
	public int romanToInt(String s) {
		if (s == null) {
			return 0;
		}
		int sLen = s.length();
		if (sLen == 0) {
			return 0;
		}
		char[] sChars=s.toCharArray();

		int result =romanToInt(sChars[sLen - 1]);
		for (int i = sLen - 2; i >= 0; i--) {
			int right=romanToInt(sChars[i + 1]);
			int curr=romanToInt(sChars[i]);
			if (right <= curr) {
				result +=curr;
			} else {
				result -= curr;
			}
		}
		return result;
	}

	private int romanToInt(char c) {
		switch (c) {
		case 'M':
			return 1000;
		case 'D':
			return 500;

		case 'C':
			return 100;

		case 'L':
			return 50;

		case 'X':
			return 10;

		case 'V':
			return 5;

		case 'I':
			return 1;

		}
		return 0;
	}

	public static void main(String[] args) {
		RomanToInteger s = new RomanToInteger();

		String str;
		int expect;
		int output;
		int seq=0;
		
		str = "I";
		expect = 1;
		output = s.romanToInt(str);
		Util.verifyUnsort(expect, output, seq++);

		str = "IX";
		expect = 9;
		output = s.romanToInt(str);
		Util.verifyUnsort(expect, output, seq++);

		str = "XII";
		expect = 12;
		output = s.romanToInt(str);
		Util.verifyUnsort(expect, output, seq++);

	}

}
