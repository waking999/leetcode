package leetcode.success.array;

import org.junit.Test;


import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int strsLen = strs.length;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = sort(str);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }

        }

        List<List<String>> rtn = new ArrayList<>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            rtn.add(map.get(key));
        }


        return rtn;
    }

    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }


}
