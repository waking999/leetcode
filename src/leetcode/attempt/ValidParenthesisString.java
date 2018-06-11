package leetcode.attempt;

import leetcode.success.comm.Util;

public class ValidParenthesisString {
	/*
	 * 1.Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	 * 2.Any right parenthesis ')' must have a corresponding left parenthesis '('.
	 * 3.Left parenthesis '(' must go before the corresponding right parenthesis
	 * ')'. 4.'*' could be treated as a single right parenthesis ')' or a single
	 * left parenthesis '(' or an empty string. 5.An empty string is also valid.
	 */
	public boolean checkValidString(String s) {
		if(s==null) {
			return true;
		}
		s=s.trim();
		int sLen=s.length();
		if(sLen==0) {
			return true;
		}
		
	 
		char[] chs=s.toCharArray();
	 
		
		return false;
	}

	public static void main(String[] args) {
		ValidParenthesisString s = new ValidParenthesisString();

		String str;
		boolean expect;
		boolean output;

		str = "()";
		expect = true;
		output = s.checkValidString(str);
		Util.verify(expect, output, 1);

		str = "(*)";
		expect = true;
		output = s.checkValidString(str);
		Util.verify(expect, output, 2);

		str = "(*))";
		expect = true;
		output = s.checkValidString(str);
		Util.verify(expect, output, 3);

	}

}
