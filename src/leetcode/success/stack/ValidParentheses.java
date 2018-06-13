package leetcode.success.stack;

import leetcode.success.comm.Util;

import static leetcode.success.comm.Util.verify;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null) {
			return true;
		}
		if (s.isEmpty()) {
			return true;
		}
		int sSize = s.length();
		char[] chars = s.toCharArray();
 
		char[] cStack=new char[sSize];
		int cStackLen=0;
		cStack[0]=chars[0];
		cStackLen++;
		
		int i = 1;
		while (i < sSize) {
			if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
				
				cStack[cStackLen++]=chars[i];
				i++;
			} else {
				if(cStackLen==0){
					return false;
				}
				char cTop = cStack[cStackLen-1];
				if ((cTop == '(' && chars[i] == ')') || (cTop == '[' && chars[i] == ']')
						|| (cTop == '{' && chars[i] == '}')) {
					cStackLen--;
					i++;
				} else {
					return false;
				}
			}
		}
		return cStackLen == 0;
	}

	public static void main(String[] args) {
		ValidParentheses s = new ValidParentheses();

		String str;
		boolean expect;
		boolean output;
		int seq=0;
		
		str = "()";
		expect = true;
		output = s.isValid(str);
		verify(expect, output, seq++);

		str = "()[]{}";
		expect = true;
		output = s.isValid(str);
		verify(expect, output, seq++);

		str = "(]";
		expect = false;
		output = s.isValid(str);
		verify(expect, output, seq++);

		str = "([)]";
		expect = false;
		output = s.isValid(str);
		verify(expect, output, seq++);
		
		str = "[])";
		expect = false;
		output = s.isValid(str);
		verify(expect, output, seq++);
		
		
	 
	}

}
