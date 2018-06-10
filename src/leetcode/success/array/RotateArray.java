package leetcode.success.array;

public class RotateArray {
//	public void rotate(int[] nums, int k) {
//		int numsLen = nums.length;
//		if (numsLen <= 1) {
//			return;
//		}
//		if (k <= 0) {
//			return;
//		}
//		if (numsLen >= k) {
//			int[] left = new int[numsLen - k];
//			int[] right = new int[k];
//			System.arraycopy(nums, 0, left, 0, numsLen - k);
//			System.arraycopy(nums, numsLen - k, right, 0, k);
//			
//			System.arraycopy(merge(right, left),0, nums, 0, numsLen);
//			return;
//		} else {
//			k=k%numsLen;
//			rotate(nums, k);
//			return;
//		}
//	}
//
//	private int[] merge(int[] left, int[] right) {
//		int leftLen = left.length;
//		int rightLen = right.length;
//
//		int[] ret = new int[rightLen + leftLen];
//		System.arraycopy(left, 0, ret, 0, leftLen);
//		System.arraycopy(right, 0, ret, leftLen, rightLen);
//		return ret;
//	}

	public void rotate(int[] nums, int k) {
		int numsLen = nums.length;
		if (numsLen <= 1) {
			return;
		}
		if (k <= 0) {
			return;
		}
		k=k%numsLen;
		for(int i=1;i<=k;i++){
			int t=nums[numsLen-1];
			for(int j=numsLen-2;j>=0;j--){
				nums[j+1]=nums[j];
			}
			nums[0]=t;
		}
		
		return;
	}
	public static void main(String[] args) {
		RotateArray s = new RotateArray();

		int[] nums;
		int k;
		int[] expect;

		nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		k = 3;
		expect = new int[] { 5, 6, 7, 1, 2, 3, 4 };
		s.rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			assert (expect[i] == nums[i]) : "1:wrong";
		}
		
		nums = new int[] { 1, 2};
		k = 1;
		expect = new int[] {2,1 };
		s.rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			assert (expect[i] == nums[i]) : "2:wrong";
		}
		
		nums = new int[] { 1, 2};
		k = 3;
		expect = new int[] {2,1 };
		s.rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			assert (expect[i] == nums[i]) : "2:wrong";
		}

		System.out.println("Finish");
	}

}
