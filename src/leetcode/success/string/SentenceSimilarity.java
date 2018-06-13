package leetcode.success.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leetcode.success.comm.Util;

public class SentenceSimilarity {
	public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
		if ((words1 == null) && (words2 == null)) {
			return true;
		}
		int words1Len = words1.length;
		int words2Len = words2.length;
		if (words1Len != words2Len) {
			return false;
		}
		Map<String, Set<String>> dic = new HashMap<>();
		for(String[] p:pairs) {
			String a=p[0];
			String b=p[1];
			putDic(dic, a, b);
			putDic(dic, b, a);
		}
		

		for (int i = 0; i < words1Len; i++) {
			String w1=words1[i];
			String w2=words2[i];
			if(w1.equals(w2)||(dic.containsKey(w1)&&dic.get(w1).contains(w2))||(dic.containsKey(w2)&&dic.get(w2).contains(w1))) {
				continue;
			}else {
				return false;
			}
		}

		return true;
	}

	private void putDic(Map<String, Set<String>> dic, String a, String b) {
		Set<String> aSet=null;
		if(dic.containsKey(a)) {
			aSet=dic.get(a);			
		}else {
			aSet=new HashSet<>();			 
		}
		aSet.add(b);
		dic.put(a, aSet);
	}

	public static void main(String[] args) {
		SentenceSimilarity s = new SentenceSimilarity();
		String[] words1;
		String[] words2;
		String[][] pairs;
		boolean expect;
		boolean output;
		int seq = 0;

		words1 = new String[] { "great", "acting", "skills" };
		words2 = new String[] { "fine", "drama", "talent" };
		pairs = new String[][] { { "great", "fine" }, { "acting", "drama" }, { "skills", "talent" } };
		expect = true;
		output = s.areSentencesSimilar(words1, words2, pairs);
		Util.verify(expect, output, seq++);

		words1 = new String[] { "great" };
		words2 = new String[] { "great" };
		pairs = new String[][] {};
		expect = true;
		output = s.areSentencesSimilar(words1, words2, pairs);
		Util.verify(expect, output, seq++);

		words1 = new String[] { "great" };
		words2 = new String[] { "doubleplus", "good" };
		pairs = new String[][] {};
		expect = false;
		output = s.areSentencesSimilar(words1, words2, pairs);
		Util.verify(expect, output, seq++);

		words1 = new String[] { "great" };
		words2 = new String[] { "good" };
		pairs = new String[][] { { "great", "fine" }, { "fine", "good" } };
		expect = false;
		output = s.areSentencesSimilar(words1, words2, pairs);
		Util.verify(expect, output, seq++);
		
		
		words1 = new String[] {"great","acting","skills"};
		words2 = new String[] {"fine","painting","talent"};
		pairs = new String[][] { {"great","fine"},{"drama","acting"},{"skills","talent"} };
		expect = false;
		output = s.areSentencesSimilar(words1, words2, pairs);
		Util.verify(expect, output, seq++);
		 

	}

}
