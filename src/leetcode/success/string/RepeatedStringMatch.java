package leetcode.success.string;

import leetcode.success.comm.Util;

public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		if(B==null) {
			return 1;
		}
		B=B.trim();
		int bLen=B.length();
		if(bLen==0) {
			return 1;
		}
		if(A==null) {
			return -1;
		}
		int aLen=A.length();
		if(aLen==0) {
			return -1;
		}
		
		if(A.contains(B)) {
			return 1;
		}
		
		StringBuilder sb=new StringBuilder();
		int count=0;
		
		while(sb.length()<bLen){
			sb.append(A);
			count++;
		}
		
		if(sb.toString().contains(B)) {
			return count;
		}
		if(sb.append(A).toString().contains(B)) {
			return ++count;
		}
		
		
		return -1;
		
	 
	}
	
	 

	public static void main(String[] args) {
		RepeatedStringMatch s = new RepeatedStringMatch();

		String A;
		String B;
		int expect;
		int output;
		int seq=0;
		
		A = "abcd";
		B = "cdabcdab";
		expect=3;
		output=s.repeatedStringMatch(A, B);
		Util.verify(expect, output, ++seq);
		
		
		A = "aaaa";
		B = "a";
		expect=1;
		output=s.repeatedStringMatch(A, B);
		Util.verify(expect, output, ++seq);
		
		
		A = "abaabaa";
		B = "abaababaab";
		expect=-1;
		output=s.repeatedStringMatch(A, B);
		Util.verify(expect, output, ++seq);
	}

}
