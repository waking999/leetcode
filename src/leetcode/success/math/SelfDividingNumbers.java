package leetcode.success.math;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
	public List<Integer> selfDividingNumbers(int left, int right) {
		if(left<1) {
			left=1;
		}
		
		if(right>10000) {
			right=10000;
		}
		
		List<Integer> rtn=new ArrayList<>();
		
		if(left>right) {
			return rtn;
		}
		
		for(int i=left;i<=right;i++) {
			if(isSelf(i)) {
				rtn.add(i);
			}
		}
		return rtn;
	}
	
	private boolean isSelf(int number) {
		if(number<10) {
			return true;
		}
		int tmp=number;
		int div=1;
		
		while(tmp!=0) {
			div=tmp%10;
			tmp=tmp/10;
			if(div==0) {
				return false;
			}
			if(number%div!=0) {
				return false;
			}
			
		}
		
		return true;
	}


}
