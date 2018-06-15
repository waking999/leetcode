package leetcode.success.math;

import java.util.Stack;

public class Smallestnumberksuchthattheproductofdigitsofkisequalton {
	public int productk(int n) {
		if(n>=0&&n<=9) {
			return n;
		}
		Stack<Integer> s=new Stack<>();
		for(int i=9;i>=2&&n>1;i--) {
			while(n%i==0) {
				s.push(i);
				n=n/i;
			}
		}
		
		if(n!=1) {
			return -1;
		}
		int ret=0;
		while(!s.isEmpty()) {
			ret=ret*10+s.pop();
		}
		
		
		return ret;
		
		 
	}


}
