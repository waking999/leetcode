package leetcode.success.stack;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s == null) {
			return true;
		}
		s = s.trim().toLowerCase();
		if (s.isEmpty()) {
			return true;
		}
		int sLen = s.length();
		if (sLen == 1) {
			return true;
		}

		char[] cArr = s.toCharArray();
		char[] cStack = new char[sLen];
		int cStackLen = 0;

		for (char c : cArr) {
			if ((c >= 'a' && c <= 'z')||(c>='0'&&c<='9')) {
				cStack[cStackLen] = c;
				cStackLen++;
			}
		}
		if (cStackLen <= 1) {
			return true;
		}
		int mid = cStackLen / 2;

		for (int i = 0; i <= mid; i++) {
			if (cStack[i] != cStack[cStackLen - 1 - i]) {
				return false;
			}
		}

		return true;
	}



}
