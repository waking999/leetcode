package leetcode.success.string;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
		 Map<Character, Integer> tMap = new HashMap<>();
		
		char[] sArr=s.toCharArray();
		char[] tArr=t.toCharArray();
		
		for(char c:tArr){
			if(tMap.containsKey(c)){
				tMap.put(c, tMap.get(c)+1);
			}else{
				tMap.put(c, 1);
			}
		}
		
		for(char c:sArr){
			tMap.put(c, tMap.get(c)-1);
		}
		
		for(char c:tArr){
			int count=tMap.get(c);
			if(count>0){
				return c;
			}
		}
		return tArr[0];
	}

	public static void main(String[] args) {
		FindTheDifference s = new FindTheDifference();

		String str1;
		String str2;
		char expect;
		char output;

		str1 = "abcd";
		str2 = "abcde";
		expect = 'e';
		output = s.findTheDifference(str1, str2);
		assert (expect == output) : "1:wrong";

		str1 = "abcd";
		str2 = "abecd";
		expect = 'e';
		output = s.findTheDifference(str1, str2);
		assert (expect == output) : "2:wrong";

		str1 = "abcd";
		str2 = "abadc";
		expect = 'a';
		output = s.findTheDifference(str1, str2);
		assert (expect == output) : "3:wrong";

		System.out.println("Finish");

	}

}
