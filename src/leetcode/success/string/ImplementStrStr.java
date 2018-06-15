package leetcode.success.string;

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
				} else if (needlePos == needleLen && i <= haystackLen) {
					return i - needleLen;
				} else {
					return -1;
				}
			}

		}

		return -1;
	}



}
