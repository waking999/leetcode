package leetcode.success.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * <p>
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 * <p>
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * <p>
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * <p>
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens==null){
            return 0;
        }
        Stack<Integer> stack=new Stack<>();

        for(String str:tokens){
            if("+".equals(str)){
                int a=stack.pop();
                int b=stack.pop();
                int c=b+a;
                stack.push(c);
            }else if("-".equals(str)){
                int a=stack.pop();
                int b=stack.pop();
                int c=b-a;
                stack.push(c);
            }else if("*".equals(str)){
                int a=stack.pop();
                int b=stack.pop();
                int c=b*a;
                stack.push(c);
            }else if("/".equals(str)){
                int a=stack.pop();
                int b=stack.pop();
                int c=b/a;
                stack.push(c);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}
