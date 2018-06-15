package leetcode.success.string;

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
	


}
