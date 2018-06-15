package leetcode.success.string;

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



}
