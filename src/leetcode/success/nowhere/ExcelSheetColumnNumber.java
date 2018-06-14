package leetcode.success.nowhere;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if(s==null){
			return -1;
		}
		s=s.trim().toUpperCase();
		if(s.isEmpty()){
			return -1;
		}
		int sLen=s.length();
		int sum=0;
		
		for(int i=0;i<sLen;i++){
			char c=s.charAt(i);
			if(c<'A'||c>'Z'){
				return -1;
			}
			sum=sum*26+ c-'A' +1;
		}
		
		
		return sum;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber s = new ExcelSheetColumnNumber();

		String str;
		int expect;
		int output;

		str = "A";
		expect = 1;
		output = s.titleToNumber(str);
		assert (expect == output) : str + ":wrong";

		str = "B";
		expect = 2;
		output = s.titleToNumber(str);
		assert (expect == output) : str + ":wrong";

		str = "C";
		expect = 3;
		output = s.titleToNumber(str);
		assert (expect == output) : str + ":wrong";

		str = "Z";
		expect = 26;
		output = s.titleToNumber(str);
		assert (expect == output) : str + ":wrong";

		str = "AA";
		expect = 27;
		output = s.titleToNumber(str);
		assert (expect == output) : str + ":wrong";

		str = "AB";
		expect = 28;
		output = s.titleToNumber(str);
		assert (expect == output) : str + ":wrong";

		System.out.println("Finish");

	}

}
