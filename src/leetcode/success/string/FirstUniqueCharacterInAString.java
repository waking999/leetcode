package leetcode.success.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
		if(s==null){
			return -1;
		}
		int sLen=s.length();
		if(sLen==0){
			return -1;
		}
		if(sLen==1){
			return 0;
		}
		Map<Character,Integer> map=new HashMap<>();
		char[] sArr=s.toCharArray();
		for(char c:sArr){			
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}			
		}
		
		for(int i=0;i<sLen;i++){
			char c=sArr[i];
			if(map.get(c)==1){
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueCharacterInAString s = new FirstUniqueCharacterInAString();

		String str;
		int expect;
		int output;

		str = "leetcode";
		expect = 0;
		output = s.firstUniqChar(str);
		assert (expect == output) : "1:wrong";

		str = "loveleetcode";
		expect = 2;
		output = s.firstUniqChar(str);
		assert (expect == output) : "2:wrong";

		str = "";
		expect = -1;
		output = s.firstUniqChar(str);
		assert (expect == output) : "2:wrong";
		
		str = "cc";
		expect = -1;
		output = s.firstUniqChar(str);
		assert (expect == output) : "2:wrong";
		
		System.out.println("Finish");

	}

}
