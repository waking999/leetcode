package history.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import history.common.ISolution;

public class IntersectionOfTwoArrays implements ISolution<Return, Input> {
	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> numList = new ArrayList<Integer>();
		int nums1Len=nums1.length;
		int nums2Len=nums2.length;
		
		Set<Integer> nums1Set=new HashSet<Integer>(nums1Len);
		for(int i=0;i<nums1Len;i++){
			nums1Set.add(nums1[i]);
		}
		Set<Integer> nums2Set=new HashSet<Integer>(nums2Len);
		for(int i=0;i<nums2Len;i++){
			nums2Set.add(nums2[i]);
		}
		
		for(int i:nums2Set){
			if(nums1Set.contains(i)){
				numList.add(i);
			}
		}
		
		int numListSize=numList.size();
		int[] nums = new int[numListSize]; 
		
		for(int i=0;i<numListSize;i++){
			nums[i]=numList.get(i).intValue();
		}

		
		return nums;
	}

	@Test
	public void test1() {
		ISolution<Return, Input> s = new IntersectionOfTwoArrays();
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		Input i = new Input(nums1, nums2);
		int[] nums = { 2 };
		Return e = new Return(nums);
		s.test(i, e);
	}

	@Override
	public Return solution(Input i) {
		int[] nums1 = i.getNums1();
		int[] nums2 = i.getNums2();

		int[] nums = intersection(nums1, nums2);
		Return r = new Return(nums);
		return r;
	}
}

class Input {
	int[] nums1;
	int[] nums2;

	public Input(int[] nums1, int[] nums2) {
		this.nums1 = nums1;
		this.nums2 = nums2;
	}

	public int[] getNums1() {
		return nums1;
	}

	public void setNums1(int[] nums1) {
		this.nums1 = nums1;
	}

	public int[] getNums2() {
		return nums2;
	}

	public void setNums2(int[] nums2) {
		this.nums2 = nums2;
	}
}

class Return {
	int[] nums;

	public Return(int[] nums) {
		this.nums = nums;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Return))
			return false;

		Return r = (Return) o;
		int[] rNums = r.nums;
		if (rNums == null) {
			return false;
		}
		int rNumsLen = rNums.length;

		int[] tNums = this.nums;
		if (tNums == null) {
			return false;
		}
		int tNumsLen = tNums.length;
		if (rNumsLen != tNumsLen) {
			return false;
		}

		for (int i = 0; i < rNumsLen; i++) {
			if (rNums[i] != tNums[i]) {
				return false;
			}
		}
		return true;
	}

	public int hashCode() {
		int result = 2;
		if (this.nums != null) {
			for (int i = 0, len = nums.length; i < len; i++) {
				result = 3 * result + nums[i];
			}
		}

		return result;
	}

	public String toString() {

		return Arrays.toString(nums);

	}
}
