package leetcode.success.string;



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
				StringBuilder sb=new StringBuilder();
				for(int j=0;j< c;j++) {
					sb.append(s, 0, i);
				}
				if(s.equals(sb.toString())) {
					return true;
				}
			}
		}
		return false;
		
	}


}
