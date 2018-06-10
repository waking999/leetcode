package leetcode.success.nowhere;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
	// public int singleNumber(int[] nums) {
	//
	// Arrays.sort(nums);
	// int n=nums.length;
	// if(n==1){
	// return nums[0];
	// }
	// for(int i=0;i<n-1;i=i+2){
	// if(nums[i]!=nums[i+1]){
	// return nums[i];
	// }
	// }
	//
	//
	// return nums[n-1];
	// }

	public int singleNumber(int[] nums) {

		int n = nums.length;
		if (n == 1) {
			return nums[0];
		}
		Map<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		for(int i=0;i<n;i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], true);
			}else{
				map.put(nums[i], false);
			}
		}
		
		Set<Integer> keySet=map.keySet();
		for(Integer i:keySet){
			if(!map.get(i)){
				return i;
			}
		}
		
		return -1;
		

	}

	public static void main(String[] args) {
		SingleNumber s = new SingleNumber();

		int[] nums;
		int expect;
		int output;

		nums = new int[] { 2, 1, 2, 3, 3 };
		expect = 1;
		output = s.singleNumber(nums);
		assert (expect == output) : "1;wrong";

		nums = new int[] { 1 };
		expect = 1;
		output = s.singleNumber(nums);
		assert (expect == output) : "2;wrong";

		nums = new int[] { 2, 2, 3, 3, 1 };
		expect = 1;
		output = s.singleNumber(nums);
		assert (expect == output) : "3;wrong";

		System.out.println("Finish");
	}

}
