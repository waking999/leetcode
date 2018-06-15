package leetcode.success.math;

import java.util.Stack;

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


}
