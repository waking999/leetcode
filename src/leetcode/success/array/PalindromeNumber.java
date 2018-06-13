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

    @Test
    public void test1() {
		PalindromeNumber s=new PalindromeNumber();
		
		int x;
		boolean expect;
		boolean output;
		int seq=0;
		
		x=0;
		expect=true;
		output=s.isPalindrome(x);
		Util.verify(expect, output, seq++);
		
		x=-1;
		expect=false;
		output=s.isPalindrome(x);
		Util.verify(expect, output, seq++);
		
		x=121;
		expect=true;
		output=s.isPalindrome(x);
		Util.verify(expect, output, seq++);
		
		x=122;
		expect=false;
		output=s.isPalindrome(x);
		Util.verify(expect, output, seq++);
		 
		
	}

}
