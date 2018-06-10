package leetcode.success.string;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null) {
			return false;
		}
		String[] words = str.trim().split(" ");
		char[] p = pattern.trim().toCharArray();
		
		int wordsLen=words.length;
		int pLen=p.length;
		
		if(wordsLen!=pLen){
			return false;
		}
		
		Map<Character, String> map1=new HashMap<>();
		Map<String,Character> map2=new HashMap<>();
	 
		for(int i=0;i<pLen;i++){
			char c=p[i];
			String word=words[i];
			if(map1.containsKey(c)){
				String word2=map1.get(c);
				if(!word2.equals(word)){
					return false;
				}
			}else{
				map1.put(c, word);
			}
			
			if(map2.containsKey(word)){
				char c2=map2.get(word);
				if(c!=c2){
					return false;
				}
			}else{
				map2.put(word, c);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		WordPattern s = new WordPattern();

		String pattern;
		String str;
		boolean expect;
		boolean output;

		pattern = "abba";
		str = "dog cat cat dog";
		expect = true;
		output = s.wordPattern(pattern, str);
		assert (expect == output) : "1:wrong";

		pattern = "abba";
		str = "dog cat cat fish";
		expect = false;
		output = s.wordPattern(pattern, str);
		assert (expect == output) : "2:wrong";

		pattern = "aaaa";
		str = "dog cat cat dog";
		expect = false;
		output = s.wordPattern(pattern, str);
		assert (expect == output) : "3:wrong";

		pattern = "abba";
		str = "dog dog dog dog";
		expect = false;
		output = s.wordPattern(pattern, str);
		assert (expect == output) : "4:wrong";
		
		pattern = "ab";
		str = "dog dog";
		expect = false;
		output = s.wordPattern(pattern, str);
		assert (expect == output) : "5:wrong";
		

		System.out.println("Finish");

	}

}
