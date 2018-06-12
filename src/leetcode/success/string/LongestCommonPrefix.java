package leetcode.success.string;

import leetcode.success.comm.Util;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String x = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String y = strs[i];
			x = LCP(x, y);
		}
		return x;
	}

	private String LCP(String x, String y) {
		int xLen = x.length();
		int yLen = y.length();
		int len = Math.min(xLen, yLen);
		int pos = 0;
		char[] xChars = x.toCharArray();
		char[] yChars = y.toCharArray();

		for (int i = 0; i < len; i++) {
			if (xChars[i] == yChars[i]) {
				pos++;
			} else {
				break;
			}
		}

		return x.substring(0, pos);
	}

	public static void main(String[] args) {
		LongestCommonPrefix s = new LongestCommonPrefix();

		String[] input;
		String expect;
		String output;
		int seq = 0;

		input = new String[] { "geeksforgeeks", "geeks", "geezer" };
		expect = "gee";
		output = s.longestCommonPrefix(input);
		Util.verifyUnsort(expect, output, seq++);

		input = new String[] { "apple", "ape", "april" };
		expect = "ap";
		output = s.longestCommonPrefix(input);
		Util.verifyUnsort(expect, output, seq++);
	}

}
