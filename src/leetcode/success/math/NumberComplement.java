package leetcode.success.math;

import java.util.Stack;

import leetcode.success.comm.Util;

public class NumberComplement {
	public int findComplement(int num) {
		int ret=0;
		Stack<Integer> s=new Stack<>();
		while(num!=0) {
			int c=num%2;
			int d=1-c;
			s.push(d);
			num=num/2;
		}
		
		
		while(!s.isEmpty()) {
			
			ret=ret*2+s.pop();
		}
		return ret;
	}

	public static void main(String[] args) {
		NumberComplement s = new NumberComplement();

		int num;
		int expect;
		int output;

		num = 5;
		expect = 2;
		output = s.findComplement(num);
		Util.verify(expect, output, 1);

		num = 1;
		expect = 0;
		output = s.findComplement(num);
		Util.verify(expect, output, 2);
		
		num =2;
		expect = 1;
		output = s.findComplement(num);
		Util.verify(expect, output, 2);

	}

}
