package leetcode.success.math;

import leetcode.success.comm.Util;

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		 
		int ret=0;
		while(n>0) {
			ret+=n/5;
			n/=5;
		}
		return ret;
	}
	
    
      
       
	public static void main(String[] args) {
		FactorialTrailingZeroes s = new FactorialTrailingZeroes();

		int n;
		int expect;
		int output;

		n = 5;
		expect = 1;
		output = s.trailingZeroes(n);
		Util.verify(expect, output, 1);

		n = 11;
		expect = 2;
		output = s.trailingZeroes(n);
		Util.verify(expect, output, 2);

		n = 28;
		expect = 6;
		output = s.trailingZeroes(n);
		Util.verify(expect, output, 3);
		
		n = 1808548329;
		expect = 452137076;
		output = s.trailingZeroes(n);
		Util.verify(expect, output, 4);
		
		
	}

}
