package leetcode.success.string;

import leetcode.success.comm.Util;

public class ReverseStringII {
	public String reverseStr(String s, int k) {
		if(s==null) {
			return null;
		}
		int sLen=s.length();
		if(sLen<=1) {
			return s;
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<sLen;i+=2*k) {
			int start=i;
			int end=Math.min(start+k,sLen);
			String subStr=s.substring(start, end);
			String reSubStr=reverseString(subStr);
			sb.append(reSubStr);
			start=end;
			end=Math.min(start+k, sLen);
			subStr=s.substring(start, end);
			sb.append(subStr);
			
		}
		
		
		return sb.toString();
	}
	
	private String reverseString(String s) {
		byte[] bytes=s.getBytes();
		int sLen=s.length();
		int half=0;
		if(sLen%2==0){
			half=sLen/2;
		}else{
			half=(sLen-1)/2;
		}
		
		for(int i=0;i<half;i++){
			byte tmp=bytes[i];
			int j=sLen-1-i;
			bytes[i]=bytes[j];
			bytes[j]=tmp;
		}
		
		String s2=new String(bytes);
		return s2;
	}

	public static void main(String[] args) {
		ReverseStringII s = new ReverseStringII();

		String str;
		int k;
		String expect;
		String output;

		str = "abcdefg";
		k = 2;
		expect = "bacdfeg";
		output = s.reverseStr(str, k);
		Util.verifyUnsort(expect, output, 1);

	}

}
