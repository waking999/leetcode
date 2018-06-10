package leetcode.success.string;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine==null){
        	return false;
        }
        int magazineLen=magazine.length();
//        if(magazineLen==0){
//        	return false;
//        }
        if(ransomNote==null){
        	return true;
        }
        int ransomNoteLen=ransomNote.length();
        if(ransomNoteLen==0){
        	return true;
        }
        if(ransomNoteLen>magazineLen){
        	return false;
        }
        
        Map<Character,Integer> magazineMap=new HashMap<>();
        char[] magazineArr=magazine.toCharArray();
        for(char c:magazineArr){
        	if(magazineMap.containsKey(c)){
        		magazineMap.put(c,magazineMap.get(c)+1);
        	}else{
        		magazineMap.put(c, 1);
        	}
        }
        
        char[] ransomNoteArr=ransomNote.toCharArray();
        for(char c:ransomNoteArr){
        	if(!magazineMap.containsKey(c)){
        		return false;
        	}else{
        		int count=magazineMap.get(c);
        		count--;
        		if(count<0){
        			return false;
        		}else{
        			magazineMap.put(c, count);
        		}
        	}
        }
        
        
        return true;
        
    }
	public static void main(String[] args) {
		RansomNote s=new RansomNote();
		
		String ransomNote;
		String magazine;
		boolean expect;
		boolean output;
		
		ransomNote="a";
		magazine="b";
		expect= false;
		output=s.canConstruct(ransomNote, magazine);
		assert (expect == output) : "1:wrong";
		
		ransomNote="aa";
		magazine="ab";
		expect= false;
		output=s.canConstruct(ransomNote, magazine);
		assert (expect == output) : "2:wrong";
		
		ransomNote="aa";
		magazine="aab";
		expect= true;
		output=s.canConstruct(ransomNote, magazine);
		assert (expect == output) : "3:wrong";
		
		ransomNote="";
		magazine="";
		expect= true;
		output=s.canConstruct(ransomNote, magazine);
		assert (expect == output) : "3:wrong";
		
		
		System.out.println("Finish");
	}

}
