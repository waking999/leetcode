package leetcode.success.tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> ret = new ArrayList<>();
		

		String prefix = "(";

		next(prefix, ret,  1, 0, n);
		return ret;
	}

 
	private void next(String prefix, List<String> ret,  int numOfL, int numOfR, int n) {
		if (numOfR > numOfL) {
			return;
		}
		
		if (numOfL <= n - 1) {
			next(prefix + "(", ret,  numOfL + 1, numOfR, n);
		}

		if (numOfR <= n - 1) {
			next(prefix + ")", ret, numOfL, numOfR + 1, n);
		}
        if (numOfL == n && numOfR == n) {
			ret.add(prefix);
		}

	}



}
