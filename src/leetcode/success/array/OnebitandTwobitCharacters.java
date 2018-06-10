package leetcode.success.array;

import leetcode.success.comm.Util;

public class OnebitandTwobitCharacters {
	public boolean isOneBitCharacter(int[] bits) {
		if (bits == null) {
			return false;
		}

		int bitsLen = bits.length;
		if (bitsLen == 0) {
			return false;
		}
		if (bitsLen == 1) {
			if (bits[0] == 0) {
				return true;
			} else {
				return false;
			}
		}

		int i = 0;
		for (; i < bitsLen-1;) {
			if (bits[i] == 1) {
				i = i + 2;
			} else {
				i = i + 1;
			}
		}

		if (i < bitsLen) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		OnebitandTwobitCharacters s = new OnebitandTwobitCharacters();

		int[] bits;
		boolean expect;
		boolean output;
		int seq = 0;

		bits = new int[] { 1, 0, 0 };
		expect = true;
		output = s.isOneBitCharacter(bits);
		Util.verify(expect, output, seq++);

		bits = new int[] { 1, 1, 1, 0 };
		expect = false;
		output = s.isOneBitCharacter(bits);
		Util.verify(expect, output, seq++);

	}

}
