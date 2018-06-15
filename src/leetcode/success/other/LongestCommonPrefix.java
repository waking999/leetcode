package leetcode.success.other;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0){
			return "";
		}
		String x=strs[0];
		for(int i=1;i<strs.length;i++){
			String y=strs[i];
			x=LCP(x,y);
		}
		return x;
	}
	
	private String LCP(String x, String y){
		int xLen=x.length();
		int yLen=y.length();
		int len=Math.min(xLen, yLen);
		int pos=0;
		for(int i=0;i<len;i++){
			if(x.charAt(i)==y.charAt(i)){
				pos++;
			}else{
				break;
			}
		}
		
		return x.substring(0, pos);
	}

	public static void main(String[] args) {
		LongestCommonPrefix s = new LongestCommonPrefix();

		String[] input = { "geeksforgeeks", "geeks", "geezer" };
		String expect = "gee";
		String output = s.longestCommonPrefix(input);
		assert (expect.equals(output)) : "1.not right";

		input = new String[] { "apple", "ape", "april" };
		expect = "ap";
		output = s.longestCommonPrefix(input);
		assert (expect.equals(output)) : "2.not right";

		System.out.println("Finish");
	}

}
