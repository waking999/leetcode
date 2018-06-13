package leetcode.attempt;

import leetcode.success.comm.Util;

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		
		if(divisor==0) {
			return Integer.MAX_VALUE;
		}
		
		if(divisor==1) {
			return dividend;
		}
		if(divisor==-1) {
			if(dividend==Integer.MIN_VALUE) {
				return Integer.MAX_VALUE;
			}else {
				return 0-dividend;
			}
		}
		long d1=(long)dividend;
		
		
		if(Math.abs(d1)<Math.abs(divisor)) {
			return 0;
		}
		
		if(d1==divisor) {
			return 1;
		}
		
		if(d1+divisor==0) {
			return -1;
		}
		
		boolean dividendPos=d1==Math.abs(d1);
		boolean divisordPos=divisor==Math.abs(divisor);
		
		
		d1=Math.abs(d1);
		divisor=Math.abs(divisor);
		
		int count=-1;
		while(d1>=0) {
			d1-=divisor;
			count++;
		}
		if(dividendPos==divisordPos) {
			return count;
		}else {
			return 0-count;
		} 
		
		
		
	}

	public static void main(String[] args) {
		DivideTwoIntegers s=new DivideTwoIntegers();
		
		int dividend;
		int divisor;		
		int expect;
		int output;
		
		dividend=1;
		divisor=2;
		expect=0;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 5);
		
		dividend=2;
		divisor=3;
		expect=0;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 10);
		
		
		dividend=2;
		divisor=1;
		expect=2;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 15);
		
		dividend=3;
		divisor=2;
		expect=1;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 20);
		
		dividend=2;
		divisor=2;
		expect=1;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 25);
		
		
		dividend=1;
		divisor=0;
		expect=Integer.MAX_VALUE;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output,30);
		
		
		dividend=1;
		divisor=-2;
		expect=0;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 35);
		
		dividend=2;
		divisor=-3;
		expect=0;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 40);
		
		
		dividend=-1;
		divisor=2;
		expect=0;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 45);

		dividend=-2;
		divisor=3;
		expect=0;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 50);
		
		dividend=2;
		divisor=-1;
		expect=-2;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 55);
		
		dividend=3;
		divisor=-2;
		expect=-1;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 60);
		
		dividend=-2;
		divisor=1;
		expect=-2;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 65);
		
		
		dividend=-3;
		divisor=2;
		expect=-1;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 70);

		dividend=-1;
		divisor=-2;
		expect=0;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 75);
		
		dividend=-2;
		divisor=-3;
		expect=0;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 80);
		
		dividend=-2;
		divisor=-1;
		expect=2;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 85);
		
		dividend=-3;
		divisor=-2;
		expect=1;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 90);
		
		
		dividend=-1;
		divisor=0;
		expect=Integer.MAX_VALUE;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 95);
		
		dividend=-3;
		divisor=-3;
		expect=1;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 100);

		dividend=3;
		divisor=3;
		expect=1;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 105);
		
		dividend=-3;
		divisor=3;
		expect=-1;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 110);
		
		dividend=3;
		divisor=-3;
		expect=-1;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 115);
		
		dividend=-2147483648;				 
		divisor=-1;
		expect=2147483647;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 120);
		
		dividend=-2147483648;				 
		divisor=2;
		expect=-1073741824;
		output=s.divide(dividend, divisor);
		Util.verify(expect, output, 125);
		
	}
}
