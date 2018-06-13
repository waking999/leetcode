package leetcode.success.string;

import leetcode.success.comm.Util;

import static leetcode.success.comm.Util.verify;

public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		if(word==null) {
			return true;
		}
		int wordLen=word.length();
		if(wordLen==0) {
			return true;
		}
		
		int cnt=0;
		char[] wordArr=word.toCharArray();
		for(char c:wordArr) {
			if('Z'-c>=0) {
				cnt++;
			}
		}
		return cnt == 0 || cnt == wordLen || (cnt == 1 && 'Z' - word.charAt(0) >= 0);
		
		
		
	}

	public static void main(String[] args) {
		DetectCapital s = new DetectCapital();

		String word;
		boolean expect;
		boolean output;
		
		word="USA";
		expect=true;
		output=s.detectCapitalUse(word);
		verify(expect, output, 1);
		
		word="leetcode";
		expect=true;
		output=s.detectCapitalUse(word);
		verify(expect, output, 2);
		
		word="Google";
		expect=true;
		output=s.detectCapitalUse(word);
		verify(expect, output, 3);
		
		word="FlaG";
		expect=false;
		output=s.detectCapitalUse(word);
		verify(expect, output, 4);
		
		
		
		word="FFFFFFFFFFFFFFFFFFFFf";
		expect=false;
		output=s.detectCapitalUse(word);
		verify(expect, output, 4);
		
		System.out.println("Finish");
		
		
	}

}
