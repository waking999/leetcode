package leetcode.attempt;

import java.util.Arrays;

import leetcode.success.comm.Util;

public class HIndex {
	public int hIndex(int[] citations) {
		if (citations == null) {
			return 0;
		}
		int citationLen = citations.length;
		if (citationLen == 0) {
			return citationLen;
		}

		Arrays.sort(citations);

		int[] citationCount = new int[citationLen + 1];
		for(int c:citations) {
			if(c>=citationLen) {
				citationCount[citationLen]++;
			}else {
				citationCount[c]++;
			}
			
		}
		int count=0;
		for(int i=citationLen;i>=0;i--) {
			count+=citationCount[i];
			if(count>=i) {
				return i;
			}
		}
 
		return 0;
	}

	// private int getCountLess(int idx, int[] citationCount) {
	// int count = 0;
	// for (int i = 0; i < idx; i++) {
	// if (citationCount[i] > 0) {
	// count++;
	// }
	// }
	// return count;
	// }

	public static void main(String[] args) {
		HIndex s = new HIndex();

		int[] citations;
		int expect;
		int output;
		int seq = 0;

		citations = new int[] { 3, 0, 6, 1, 5 };
		expect = 3;
		output = s.hIndex(citations);
		Util.verify(expect, output, ++seq);

		citations = new int[] { 100 };
		expect = 1;
		output = s.hIndex(citations);
		Util.verify(expect, output, ++seq);

		citations = new int[] { 0 };
		expect = 0;
		output = s.hIndex(citations);
		Util.verify(expect, output, ++seq);

		citations = new int[] { 0, 1 };
		expect = 1;
		output = s.hIndex(citations);
		Util.verify(expect, output, ++seq);

		citations = new int[] { 1, 1 };
		expect = 1;
		output = s.hIndex(citations);
		Util.verify(expect, output, ++seq);

		citations = new int[] { 11, 15 };
		expect = 2;
		output = s.hIndex(citations);
		Util.verify(expect, output, ++seq);
	}

}
