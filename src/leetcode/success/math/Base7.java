package leetcode.success.math;

import leetcode.success.comm.Util;

public class Base7 {
	public String convertToBase7(int num) {
		
		if(num>=0&&num<7) {
			return Integer.toString(num);
		}
		int base=7;
		boolean neg=num<0 ;
		num=Math.abs(num);
		StringBuilder sb=new StringBuilder();
		while(num!=0) {
			int val=num%base;
			sb.insert(0, val);
			num=num/base;
		}
		
		if(neg) {
			sb.insert(0, "-");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Base7 s = new Base7();

		int num;
		String expect;
		String output;

		num = 100;
		expect = "202";
		output = s.convertToBase7(num);
		Util.verify(expect, output, 1);

		num = -7;
		expect = "-10";
		output = s.convertToBase7(num);
		Util.verify(expect, output, 2);
		
		num = -8;
		expect = "-11";
		output = s.convertToBase7(num);
		Util.verify(expect, output, 2);


	}

}
