package leetcode.success.math;

import leetcode.success.comm.Util;

public class PerfectNumber {
	public boolean checkPerfectNumber(int num) {
		if(num<=1) {
			return false;
		}
		int sum=1;
		for(int i=2;i*i<=num;i++) {
			if(num%i==0) {
				sum=sum+i+num/i;
			}
			if(i*i==num) {
				sum-=i;
			}
			if(sum>num) {
				return false;
			}
		}
		return sum==num;
	}

	public static void main(String[] args) {
		PerfectNumber s = new PerfectNumber();

		int num;
		boolean expect;
		boolean output;

		num = 28;
		expect = true;
		output = s.checkPerfectNumber(num);
		Util.verifyUnsort(expect, output, 1);

		System.out.println("Finish");

	}

}
