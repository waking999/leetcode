package leetcode.success.other;

import java.util.Stack;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if(n<=0){
			return "";
		}
		
		int modNum=26;
		int modPart=0;
		Stack<Character> s=new Stack<>();
		
		while(n!=0){
			modPart=n%modNum;
			n=n/modNum;
			char a;
			if(modPart==0){
				a='Z';
				n--;
			}else{
				a=(char)(modPart+'A'-1);
			}
			s.push(a);
			
			
		}
		StringBuilder sb=new StringBuilder();
		while(!s.isEmpty()){
			sb.append(s.pop());
		} 
		
		return sb.toString();
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle s = new ExcelSheetColumnTitle();

		int n;
		String expect;
		String output;

		n = 1;
		expect = "A";
		output = s.convertToTitle(n);
		assert (expect.equals(output)) : n + ":wrong";

		n = 2;
		expect = "B";
		output = s.convertToTitle(n);
		assert (expect.equals(output)) : n + ":wrong";

		n = 3;
		expect = "C";
		output = s.convertToTitle(n);
		assert (expect.equals(output)) : n + ":wrong";

		n = 26;
		expect = "Z";
		output = s.convertToTitle(n);
		assert (expect.equals(output)) : n + ":wrong";

		n = 27;
		expect = "AA";
		output = s.convertToTitle(n);
		assert (expect.equals(output)) : n + ":wrong";

		n = 28;
		expect = "AB";
		output = s.convertToTitle(n);
		assert (expect.equals(output)) : n + ":wrong";

		System.out.println("Finish");
	}

}
