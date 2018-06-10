package leetcode.pending;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.success.comm.Util;

public class KeyboardRow {
	public String[] findWords(String[] words) {
		
		if(words==null) {
			return null;
		}
		int length = words.length;
		if(length==0) {
			return new String[] {};
		}
		List<String> results = new ArrayList<String>();
		char[] row1 = new char[] { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		char[] row2 = new char[] { 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' };
		char[] row3 = new char[] { 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
		Set<Character> row1Set=new HashSet<>();
		Set<Character> row2Set=new HashSet<>();
		Set<Character> row3Set=new HashSet<>();
		for (int i = 0; i < 10; i++) {
			row1Set.add(row1[i]);
		}
		for (int i = 0; i < 9; i++) {
			row2Set.add(row2[i]);
		}
		for (int i = 0; i < 7; i++) {
			row3Set.add(row3[i]);
		}
	
		for(String word:words) {
			String word1=word.toLowerCase();
			int row1Cnt=0;
			int row2Cnt=0;
			int row3Cnt=0;
			for(int i=0;i<word1.length();i++) {
				if(row1Set.contains(word1.charAt(i))) {
					row1Cnt=1;
				}else if(row2Set.contains(word1.charAt(i))) {
					row2Cnt=1;
				}if(row3Set.contains(word1.charAt(i))) {
					row3Cnt=1;
				}
				
			}
			if(row1Cnt+row2Cnt+row3Cnt==1) {
				results.add(word);
			}
			
		}
		int size=results.size();
		String[] ret=new String[size];
		for(int i=0;i<size;i++) {
			ret[i]=results.get(i);
		}
		return ret;
	}

	public static void main(String[] args) {
		KeyboardRow s = new KeyboardRow();

		String[] words;
		String[] expect;
		String[] output;

		words = new String[] { "Hello", "Alaska", "Dad", "Peace" };
		expect = new String[] { "Alaska", "Dad" };
		output = s.findWords(words);
		Util.verify(expect, output, 1);

	}

}
