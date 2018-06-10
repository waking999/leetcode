package leetcode.success.string;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		if(s==null){
			return 0;
		}
		s=s.trim();
		if(s.isEmpty()){
			return 0;
		}
		int subStrStart=s.lastIndexOf(" ");
		int sLen=s.length();
		if(subStrStart<=0){
			return sLen;
		}
		String subStr=s.substring(subStrStart+1);
		
		return subStr.length();
	}

	public static void main(String[] args) {
		LengthOfLastWord s=new LengthOfLastWord();
		
		String str;
		int expect;
		int output;
		
		str="Hello World";
		expect=5;
		output=s.lengthOfLastWord(str);
		assert(expect==output):"1:wrong";
		
		str="";
		expect=0;
		output=s.lengthOfLastWord(str);
		assert(expect==output):"2:wrong";
		
		System.out.println("Finish");
	}

}
