package leetcode.success.math;

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



}
