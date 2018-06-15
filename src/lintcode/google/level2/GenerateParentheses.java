package lintcode.google.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example
 * Given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
    /**
     * @param n: n pairs
     * @return All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> rtn=new ArrayList<>();

        next("",0,0,rtn,n);

        return rtn;
    }

    private void next(String prefix,int numLeft,int numRight,List<String> rtn,int n){
        if(numLeft<numRight){
            return;
        }
        if(numLeft<=n-1){
            next(prefix+"(",numLeft+1,numRight,rtn,n);
        }
        if(numRight<=n-1){
            next(prefix+")",numLeft,numRight+1,rtn,n);
        }

        if(numLeft==n&&numRight==n){
            rtn.add(prefix);
        }
    }


}
