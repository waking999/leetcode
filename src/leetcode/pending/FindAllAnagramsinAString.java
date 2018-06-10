package leetcode.pending;

import java.util.ArrayList;
import java.util.List;

import leetcode.success.comm.Util;

public class FindAllAnagramsinAString {
 

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;

		int[] hash = new int[256];

		char[] pChars=p.toCharArray();
		int pLen=p.length();
		
		for (char c :pChars) {
			hash[c]++;
		}

		int left = 0, right = 0, count = pLen;
		char[] sChars=s.toCharArray();
		int sLen=s.length();

		while (right < sLen) {
			if (hash[sChars[right]] >= 1) {
				count--;
			}
			hash[sChars[right]]--;
			right++;

			if (count == 0) {
				list.add(left);
			}

			if (right - left == pLen) {

				if (hash[sChars[left]] >= 0) {
					count++;
				}
				hash[sChars[left]]++;
				left++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		FindAllAnagramsinAString s = new FindAllAnagramsinAString();

		String str1;
		String str2;
		int[] expect;
		List<Integer> output;

		str1 = "cbaebabacd";
		str2 = "abc";
		expect = new int[] { 0, 6 };
		output = s.findAnagrams(str1, str2);
		Util.verifySort(expect, output, 1);

		str1 = "abab";
		str2 = "ab";
		expect = new int[] { 0, 1, 2 };
		output = s.findAnagrams(str1, str2);
		Util.verifySort(expect, output, 2);

		System.out.println("Finish");
	}
}
