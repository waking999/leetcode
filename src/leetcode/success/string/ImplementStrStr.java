package leetcode.success.string;

import leetcode.success.comm.Util;

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
		if (haystack == null) {
			return -1;
		}
		if (needle == null) {
			return 0;
		}
		int haystackLen = haystack.length();
		int needleLen = needle.length();

		if (haystackLen < needleLen) {
			return -1;
		}
		if (haystackLen == needleLen && haystack.equals(needle)) {
			return 0;
		}
		if (haystackLen == 0) {
			return -1;
		}
		if (needleLen == 0) {
			return 0;
		}

		char[] haystackChars = haystack.toCharArray();
		char[] needleChars = needle.toCharArray();

		int needlePos = 0;

		for (int i = 0; i < haystackLen; i++) {
			if (needleChars[needlePos] == haystackChars[i]) {

				while (needlePos < needleLen && i < haystackLen && needleChars[needlePos] == haystackChars[i]) {
					needlePos++;
					i++;
				}
				if (needlePos < needleLen && i < haystackLen) {
					i = i - needlePos;
					needlePos = 0;
					continue;
				} else if (needlePos == needleLen && i <= haystackLen) {
					return i - needleLen;
				} else {
					return -1;
				}
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		ImplementStrStr s = new ImplementStrStr();

		String s1;
		String s2;
		int expect;
		int output;
		int seq = 0;

		s1 = "abcdef";
		s2 = "cde";
		expect = 2;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "abcedef";
		s2 = "cde";
		expect = -1;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "";
		s2 = "";
		expect = 0;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "";
		s2 = "a";
		expect = -1;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "a";
		s2 = "";
		expect = 0;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "aaa";
		s2 = "a";
		expect = 0;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "aaa";
		s2 = "aaaa";
		expect = -1;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "aabaaaababaababaa";
		s2 = "bbbb";
		expect = -1;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "a";
		s2 = "a";
		expect = 0;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "mississippi";
		s2 = "issip";
		expect = 4;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);

		s1 = "mississippi";
		s2 = "pi";
		expect = 9;
		output = s.strStr(s1, s2);
		Util.verifyUnsort(expect, output, seq++);
	}

}
