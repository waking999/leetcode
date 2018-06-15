package leetcode.success.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
		Set<String> built;
		built = new HashSet<>();
		String res = "";
		for (String w : words) {
			if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
				res = w.length() > res.length() ? w : res;
				built.add(w);
			}
		}
		return res;

		
	}


}
