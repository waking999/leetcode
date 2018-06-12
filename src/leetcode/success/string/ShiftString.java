package leetcode.success.string;

import leetcode.success.comm.Util;

public class ShiftString {
	public String leftRotate(String str,int m) {
		char[] chars=str.toCharArray();
		int charsLen=chars.length;
		m=m%charsLen;
		
		while(m>0) {
			leftShiftOne(chars);
			m--;
		}
		
		return new String(chars);
	}
	private void leftShiftOne(char[] chars) {
		int charsLen=chars.length;
		char t=chars[0];
		for(int i=1;i<charsLen;i++) {
			chars[i-1]=chars[i];
		}
		chars[charsLen-1]=t; 
	}
	
	public String leftRotate1(String str,int m) {
		char[] chars=str.toCharArray();
		int charsLen=chars.length;
		m=m%charsLen;
		reverseString(chars,0,m-1);
		reverseString(chars,m,charsLen-1);
		reverseString(chars,0,charsLen-1);
		return new String(chars);
		
	}
	private void reverseString(char[] chars,int from, int to) {
		while(from<to){
			char t=chars[from];
			chars[from++]=chars[to];
			chars[to--]=t;
		}
	}
	
	public static void main(String[] args) {
		ShiftString s=new ShiftString();

		String str;
		int m;
		String expect;
		String output;
		
		str="abcdef";
		m=2;
		expect="cdefab";
		output=s.leftRotate(str, m);
		Util.verifyUnsort(expect, output, 1);
		
		str="abcdef";
		m=2;
		expect="cdefab";
		output=s.leftRotate1(str, m);
		Util.verifyUnsort(expect, output, 2);
	}

}
