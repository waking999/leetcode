package leetcode.success.other;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class MapSum {
	
	private Map<String, Integer> map;
	private Map<String, Integer> preMap;

	/** Initialize your data structure here. */
	public MapSum() {
		map = new HashMap<>();
		preMap = new HashMap<>();
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
		return preMap.getOrDefault(prefix, 0);
			
	}



}
