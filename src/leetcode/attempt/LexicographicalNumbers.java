package leetcode.attempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicalNumbers {
	public List<Integer> lexicalOrder(int n) {
		String[] arr=new String[n+1];
		for(int i=0;i<=n;i++) {
			arr[i]=Integer.toString(i);
		}
		Arrays.sort(arr);
 
		List<Integer> ret=new ArrayList<>();
		for(int i=1;i<n+1;i++) {
			ret.add(Integer.parseInt(arr[i]));
		}
		return ret;
	}




}
