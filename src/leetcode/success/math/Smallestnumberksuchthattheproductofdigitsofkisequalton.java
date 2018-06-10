package leetcode.success.math;

import java.util.Stack;

import leetcode.success.comm.Util;

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
	public static void main(String[] args) {
		Smallestnumberksuchthattheproductofdigitsofkisequalton s=new Smallestnumberksuchthattheproductofdigitsofkisequalton();

		int n;
		int expect;
		int output;
		
		n=100;
		expect=455;
		output=s.productk(n);
		Util.verify(expect, output, 1);
		
		n=26;
		expect=-1;
		output=s.productk(n);
		Util.verify(expect, output, 2);
	}

}
