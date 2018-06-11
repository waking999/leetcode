package leetcode.success.string;

import leetcode.success.comm.Util;

public class NumberOfSegmentsInAString {
	public int countSegments(String s) {
		if(s==null){
			return 0;
		}
		
		s=s.trim();
		int sLen=s.length();
		if(sLen<=1){
			return sLen;
		}
		String[] sArr=s.split(" ");
		int count=0;
		for(String str:sArr){
			if(!"".equals(str.trim())){
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		NumberOfSegmentsInAString s = new NumberOfSegmentsInAString();

		String str;
		int expect;
		int output;

		str = "Hello, my name is John";
		expect = 5;
		output = s.countSegments(str);
		Util.verifyUnsort(expect, output, 1);
		
		
		str = "";
		expect = 0;
		output = s.countSegments(str);
		Util.verifyUnsort(expect, output, 2);
		
		str = ", , , ,        a, eaefa";
		expect = 6;
		output = s.countSegments(str);
		Util.verifyUnsort(expect, output, 3);
		
		
		System.out.println("Finish");
	}

}
