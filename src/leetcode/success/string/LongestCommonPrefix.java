package leetcode.success.string;

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



}
