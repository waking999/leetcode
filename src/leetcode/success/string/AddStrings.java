package leetcode.success.string;

import leetcode.success.comm.Util;
import org.junit.Test;

public class AddStrings {
	public String addStrings(String num1, String num2) {
		if(num1==null){
			return num2;
		}
		int num1Len=num1.length();
		if(num2==null){
			return num1;
		}
		int num2Len=num2.length();
		
		int len=Math.min(num1Len, num2Len);
		char[] num1Arr=num1.toCharArray();
		char[] num2Arr=num2.toCharArray();
		int num3Len=Math.max(num1Len, num2Len)+1;
		char[] num3Arr=new char[num3Len];
		int carry=0;
		
		for(int i=1;i<=len;i++){
			char c1=num1Arr[num1Len-i];
			char c2=num2Arr[num2Len-i];
			int a=c1-'0';
			int b=c2-'0';
			int sum=a+b+carry;
			if(sum<10){
				num3Arr[num3Len-i]=(char)(sum+'0');
				carry=0;
			}else{
				carry=1;
				sum=sum-10;
				num3Arr[num3Len-i]=(char)(sum+'0');
			}
		}
		
		for(int i=1;i<=num1Len-len;i++){
			char c=num1Arr[num1Len-len-i];
			int a=c-'0';
			int sum=a+carry;
			if(sum<10){
				num3Arr[num3Len-len-i]=(char)(sum+'0');
				carry=0;
			}else{
				carry=1;
				sum=sum-10;
				num3Arr[num3Len-len-i]=(char)(sum+'0');
			}
		}
		
		for(int i=1;i<=num2Len-len;i++){
			char c=num2Arr[num2Len-len-i];
			int a=c-'0';
			int sum=a+carry;
			if(sum<10){
				num3Arr[num3Len-len-i]=(char)(sum+'0');
				carry=0;
			}else{
				carry=1;
				sum=sum-10;
				num3Arr[num3Len-len-i]=(char)(sum+'0');
			}
		}
		String s;
		if(carry==1){
			num3Arr[0]=(char)(1+'0');
			s=new String(num3Arr);
		}else{
			char[] num4Arr=new char[num3Len-1];
			System.arraycopy(num3Arr, 1, num4Arr, 0, num3Len-1);
			s=new String(num4Arr);
		}
		
		 
		return s;
		
	}

	@Test
	public void test1() {
		AddStrings s=new AddStrings();
		
		String num1;
		String num2;
		String expect;
		String output;
		
		num1="19";
		num2="292";
		expect="311";
		output=s.addStrings(num1, num2);
		Util.verify(expect, output, 1);
		
		num1="6";
		num2="501";
		expect="507";
		output=s.addStrings(num1, num2);
		Util.verify(expect, output, 2);
		
		num1="501";
		num2="6";
		expect="507";
		output=s.addStrings(num1, num2);
		Util.verify(expect, output, 3);
		
		num1="999";
		num2="1";
		expect="1000";
		output=s.addStrings(num1, num2);
		Util.verify(expect, output, 4);
		
		System.out.println("Finish");
				

	}

}
