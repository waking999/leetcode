package leetcode.success.string;

import leetcode.success.comm.Util;

public class CountBinarySubstrings {
	public int countBinarySubstrings(String s) {
		int pre=0;
		int cur=1;
		int count=0;
        char[] chars=s.toCharArray();
        int charsLen=chars.length;
		
		for(int i=1;i<charsLen;i++) {
			if(chars[i]==chars[i-1]) {
				cur++;
			}else {
				pre=cur;
				cur=1;
			}
			if(pre>=cur) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		CountBinarySubstrings s = new CountBinarySubstrings();
		
		String str;
		int expect;
		int output;
		int seq=0;
		
		
		 str="00110011";
		 expect=6;
		 output=s.countBinarySubstrings(str);
		 Util.verify(expect, output, ++seq);
		 
		 str="10101";
		 expect=4;
		 output=s.countBinarySubstrings(str);
		 Util.verify(expect, output, ++seq);
	}

}
