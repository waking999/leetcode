package leetcode.success.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import leetcode.success.comm.Util;

public class LongestWordinDictionary {

	 

	public String longestWord(String[] words) {
		if (words == null) {
			return "";
		}
		int wordsLen = words.length;
		if (wordsLen == 0) {
			return "";
		}
		if (wordsLen == 1) {
			if (words[0].length() <= 1) {
				return words[0];
			} else {
				return "";
			}
		}

		Arrays.sort(words);
		Set<String> built = new HashSet<String>();
		String res = "";
		for (String w : words) {
			if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
				res = w.length() > res.length() ? w : res;
				built.add(w);
			}
		}
		return res;

		
	}

	public static void main(String[] args) {
		LongestWordinDictionary s = new LongestWordinDictionary();

		String[] words;
		String expect;
		String output;
		int seq = 0;

		words = new String[] { "w", "wo", "wor", "worl", "world" };
		expect = "world";
		output = s.longestWord(words);
		Util.verifyUnsort(expect, output, seq++);

		words = new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" };
		expect = "apple";
		output = s.longestWord(words);
		Util.verifyUnsort(expect, output, seq++);

		words = new String[] { "m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat" };
		expect = "latte";
		output = s.longestWord(words);
		Util.verifyUnsort(expect, output, seq++);

	}

}
