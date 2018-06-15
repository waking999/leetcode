package leetcode.success.string;

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
	
	  String leftRotate1(String str, int m) {
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
	


}
