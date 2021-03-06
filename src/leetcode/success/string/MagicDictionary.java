package leetcode.success.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicDictionary {
	private Map<Integer,List<String>> map;
	/** Initialize your data structure here. */
    public MagicDictionary() {
        map= new HashMap<>();
    }

	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		if(dict==null) {
			return;
		}
		int dictLen=dict.length;
		if(dictLen==0) {
			return;
		}
		for(String s:dict) {
			int sLen=s.length();
			if(map.containsKey(sLen)) {
				List<String> row=map.get(sLen);
				row.add(s);
			}else {
				List<String> row=new ArrayList<>();
				row.add(s);
				map.put(sLen, row);
			}
		}
	}

	/**
	 * Returns if there is any word in the trie that equals to the given word after
	 * modifying exactly one character
	 */
	public boolean search(String word) {
		if(word==null) {
			return false;
		}
		int wordLen=word.length();
		if(!map.containsKey(wordLen)) {
			return false;
		}
		List<String> row=map.get(wordLen);
		for(String s:row) {
			int count=0;
			for(int i=0;i<wordLen;i++) {
				if(s.charAt(i)!=word.charAt(i)) {
					count++;
					if(count>=2) {
						break;
					}
				}
			}
			if(count==1) {
				return true;
			}
		}
		return false;
	}



}
