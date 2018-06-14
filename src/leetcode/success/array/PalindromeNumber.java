package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
		if(x<10){
			return true;
		}
		int tmp=x;
		int y=0;
		while(x!=0){
			y=y*10+x%10;
			x=x/10;
		}
		return (y==tmp);
	}



}
