package leetcode.success.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<>();
		int n = digits.length();
		if (n == 0) {
			return ret;
		}
		char[] digitsArr = digits.toCharArray();
		
		int[] idxArr=new int[n];
		for(int i=0;i<n;i++){
			idxArr[i]=digitsArr[i]-'0';
		}
		char[][] dic = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
				{ 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		
		Stack<Character> s=new Stack<>();
		combin(ret,s,idxArr,dic,0,n);
		return ret;
	}

	private void combin(List<String> ret,Stack<Character> s, int[] idxArr,char[][] dic,int level,int n){
		if(level==n){
			String str=s.stream().map(c->c.toString()).collect(Collectors.joining());
			ret.add(str);
			return;
		}
		
		int index=idxArr[level];
		for(int i=0;i<dic[index].length;i++){
			s.push(dic[index][i]);
			combin(ret,s,idxArr,dic,level+1,n);
			s.pop();
		}
	}

	public static void main(String[] args) {

		LetterCombinationsOfAPhoneNumber s = new LetterCombinationsOfAPhoneNumber();

		String digits;
		String[] expect;
		int expectLen;
		List<String> output;
		int outputSize;

		digits = "23";
		expect = new String[] { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" };
		expectLen = expect.length;
		output = s.letterCombinations(digits);
		outputSize = output.size();
		assert (expectLen == outputSize) : "1:wrong";

		String s1 = Arrays.asList(expect).stream().collect(Collectors.joining(","));

		String s2 = output.stream().collect(Collectors.joining(","));
		assert (s1.equals(s2)) : "1:wrong";

		System.out.println("Finish");

	}

}
