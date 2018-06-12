package leetcode.success.string;

import leetcode.success.comm.Util;

public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		if(s==null) {
			return true;
		}
		s=s.trim();
		int sLen=s.length();
		if(sLen<1) {
			return true;
		}
		for(int i=sLen/2;i>=1;i--) {
			if(sLen%i==0) {
				int c=sLen/i;
				StringBuffer sb=new StringBuffer();
				for(int j=0;j< c;j++) {
					sb.append(s.substring(0, i));
				}
				if(s.equals(sb.toString())) {
					return true;
				}
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		RepeatedSubstringPattern s = new RepeatedSubstringPattern();

		String str;
		boolean expect;
		boolean output;

		str = "abab";
		expect = true;
		output = s.repeatedSubstringPattern(str);
		Util.verifyUnsort(expect, output, 1);

		str = "aba";
		expect = false;
		output = s.repeatedSubstringPattern(str);
		Util.verifyUnsort(expect, output, 2);

		str = "abcabcabcabc";
		expect = true;
		output = s.repeatedSubstringPattern(str);
		Util.verifyUnsort(expect, output, 3);

	}
}
