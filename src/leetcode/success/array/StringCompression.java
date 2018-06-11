package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;
import org.junit.Test;

public class StringCompression {
	private int setCharCount(char[] chars, int i,  int count, int newCharsLen) {
		if (count == 1) {
			if (i < chars.length) {
				chars[newCharsLen++] = chars[i];
			}
		} else if (count >= 2 && count < 10) {
			chars[newCharsLen++] = (char) (count + '0');
			if (i < chars.length) {
				chars[newCharsLen++] = chars[i];
			}
		} else {
			int countLen = 0;
			while (count != 0) {
				int m = count % 10;
				chars[newCharsLen++] = (char) (m + '0');
				countLen++;
				count /= 10;
			}

			// swap countLen
			for (int j = 0; j < countLen / 2; j++) {
				int left = newCharsLen - 1 - j;
				int right = newCharsLen - countLen + j;
				char tmp = chars[left];
				chars[left] = chars[right];
				chars[right] = tmp;
			}

			if (i < chars.length) {
				chars[newCharsLen++] = chars[i];
			}
			 
		}
		return newCharsLen;
	}

	public int compress(char[] chars) {
		if (chars == null) {
			return 0;
		}
		int charsLen = chars.length;  

		int pointer = 0;
		int count = 0;
		int newCharsLen = 1;
		int i = 1;
		for (i = 1; i < charsLen; i++) {
			if (chars[i] != chars[i - 1]) {
				count = i - pointer;
				pointer = i;

				newCharsLen = setCharCount(chars, i,  count, newCharsLen);

			}
		}
		if (i >= charsLen) {
			count = i - pointer;
			newCharsLen = setCharCount(chars, i,  count, newCharsLen);
		}
		chars=Arrays.copyOfRange(chars, 0, newCharsLen);
		return newCharsLen;
	}

    @Test
    public void test1() {
		StringCompression s = new StringCompression();

		char[] chars;
		int expect;
		int output;
		int seq = 0;

		chars = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		expect = 6;
		output = s.compress(chars);
		Util.verifyUnsort(expect, output, seq++);

		chars = new char[] { 'a' };
		expect = 1;
		output = s.compress(chars);
		Util.verifyUnsort(expect, output, seq++);

		chars = new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		expect = 4;
		output = s.compress(chars);
		Util.verifyUnsort(expect, output, seq++);

		chars = new char[] { 'a', 'b', 'c' };
		expect = 3;
		output = s.compress(chars);
		Util.verifyUnsort(expect, output, seq++);
		
		chars = new char[] { 'a', 'b', 'c' };
		expect = 3;
		output = s.compress(chars);
		Util.verifyUnsort(expect, output, seq++);
		
		chars = new char[] { 'a', 'a' };
		expect = 2;
		output = s.compress(chars);
		Util.verifyUnsort(expect, output, seq++);

	}

}
