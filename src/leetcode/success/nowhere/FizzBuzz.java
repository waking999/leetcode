package leetcode.success.nowhere;

import java.util.ArrayList;
import java.util.List;

import leetcode.success.comm.Util;

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> ret = new ArrayList<>(n);
		for(int i=1;i<=n;i++){
			if(i%15==0){
				ret.add("FizzBuzz");
			}else if(i%5==0){
				ret.add("Buzz");
			}else if(i%3==0){
				ret.add("Fizz");
			}else{
				ret.add(Integer.toString(i));
			}
		}
		
		return ret;
	}

	public static void main(String[] args) {
		FizzBuzz s = new FizzBuzz();

		int n;
		String[] expect;
		List<String> output;
 

		n = 15;
		expect = new String[] { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13",
				"14", "FizzBuzz" };
		output = s.fizzBuzz(n);
		Util.verifyUnsort(expect, output, 1);

		System.out.println("Finish");
	}

}
