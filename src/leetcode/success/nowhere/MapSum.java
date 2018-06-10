package leetcode.success.nowhere;

import java.util.HashMap;
import java.util.Map;

import leetcode.success.comm.Util;

public class MapSum {
	
	Map<String, Integer> map;
	Map<String, Integer> preMap;

	/** Initialize your data structure here. */
	public MapSum() {
		map = new HashMap<String, Integer>();
		preMap = new HashMap<String, Integer>();
	}

	public void insert(String key, int val) {
		if(map.containsKey(key)) {
			//replace existing
			map.put(key, val);
			
			for (int i = 1; i <= key.length(); i++) {
				String tmp = key.substring(0, i);
				preMap.put(tmp, val);
			}
			
		}else {
			//add new
			map.put(key, val);
			for (int i = 1; i <= key.length(); i++) {
				String tmp = key.substring(0, i);
				if (preMap.containsKey(tmp)) {
					int v2 = preMap.get(tmp);
					preMap.put(tmp, v2 + val);
				} else {
					preMap.put(tmp, val);
				}
			}
		}
		
	
	}

	public int sum(String prefix) {
		if(preMap.containsKey(prefix)) {
			return preMap.get(prefix);
		}else {
			return 0;
		}
			
	}

	public static void main(String[] args) {
		MapSum s;
		int expect;
		int output;

		s= new MapSum();
		s.insert("apple", 3);
		expect = 3;
		output = s.sum("ap");
		Util.verify(expect, output, 1);

		s.insert("app", 2);
		expect = 5;
		output = s.sum("ap");
		Util.verify(expect, output, 1);
		
		
		s= new MapSum();
		s.insert("a", 3);
		expect = 0;
		output = s.sum("ap");
		Util.verify(expect, output, 2);
		s.insert("b", 2);
		expect = 3;
		output = s.sum("a");
		Util.verify(expect, output, 2);
		 
		
		s= new MapSum();
		s.insert("aa", 3);
		expect = 3;
		output = s.sum("a");
		Util.verify(expect, output, 3);
		s.insert("aa", 2);
		expect = 2;
		output = s.sum("a");
		Util.verify(expect, output, 3);
		
		 
	}

}
