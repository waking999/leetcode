package leetcode.success.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
		if(s==null){
			return null;
		}
	 
		int sLen=s.length();
		if(sLen<=1){
			return s;
		}
		
		Set<Character> set=new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		
		
		Stack<Character> cStack=new Stack<>();
		Queue<Integer> pStack=new LinkedList<>();
		
		char[] sChars=s.toCharArray();
		for(int i=0;i<sLen;i++){
			char c=sChars[i];
			if(set.contains(c)){
				cStack.push(c);
				pStack.add(i);
			}
		}
		
		while(!pStack.isEmpty()){
			int i=pStack.poll();
			char c=cStack.pop();
			sChars[i]=c;
		}
		
		return String.valueOf(sChars);

	}

	public static void main(String[] args) {
		ReverseVowelsOfAString s = new ReverseVowelsOfAString();

		String str;
		String expect;
		String output;

		str = "hello";
		expect = "holle";
		output = s.reverseVowels(str);
		assert (expect.equals(output)) : "1:wrong";

		str = "leetcode";
		expect = "leotcede";
		output = s.reverseVowels(str);
		assert (expect.equals(output)) : "2:wrong";
		
		str = " ";
		expect = " ";
		output = s.reverseVowels(str);
		assert (expect.equals(output)) : "3:wrong";
		
		str = "aA";
		expect = "Aa";
		output = s.reverseVowels(str);
		assert (expect.equals(output)) : "4:wrong";
		
		System.out.println("Finish");

	}

}
