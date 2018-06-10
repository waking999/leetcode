package leetcode.pending;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret=new ArrayList<List<Integer>>();
		if(n<=0){
			return ret;
		}
		Stack<Integer> com=new Stack<>();
		combine(ret,com,n,k,1);
		return ret;
	}
	
	private void combine(List<List<Integer>> ret,Stack<Integer> com, int n,int k,int level){
		if(com.size()==k){
			List<Integer> list=com.stream().collect(Collectors.toList());
			 
			ret.add(list);
			return;
		}
		
		if(com.size()>k){
			return;
		}
		
		for(int i=level;i<=n;i++){
			com.push(i);
			combine(ret,com,n,k,i+1);
			com.pop();
		}
		
	}

	public static void main(String[] args) {
		Combinations s=new Combinations();
		
		int n;
		int k;
		int[][] expect;
		int expectLen;
		List<List<Integer>> output;
		int outputSize;

		n = 4;
		k = 2;
		expect=new int[][]{{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
		expectLen=expect.length;
		output=s.combine(n, k);
		outputSize=output.size();
		assert(expectLen==outputSize):"1:wrong";
		for (int i = 0; i < expectLen; i++) {

			String s1 = IntStream.of(expect[i]).map(str -> str).boxed().collect(Collectors.toList()).stream()
					.map(num -> Integer.toString(num)).collect(Collectors.joining(","));

			String s2 = output.get(i).stream().map(num -> Integer.toString(num)).collect(Collectors.joining(","));
			assert (s1.equals(s2)) : "1:wrong";
		}

		System.out.println("Finish");
		
		
		
	}

}
