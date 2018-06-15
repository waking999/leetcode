package leetcode.success.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		if(s==null){
			return 0;
		}
		int sLen=s.length();
		if(sLen==0){
			return 0;
		}
		char[] sArr=s.toCharArray();
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<sLen;i++){
			char c=sArr[i];
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		int evenCount=0;
		int oddCount=0;
		Set<Character> set=map.keySet();
		for(char c:set){
			int count=map.get(c);
			if(count%2==0){
				evenCount+=count;
			}else{
				evenCount+=(count-1);
				oddCount++;
			}
		}
		if(oddCount>0){
			return evenCount+1;
		}else{
			return evenCount;
		}
	
	}



}
