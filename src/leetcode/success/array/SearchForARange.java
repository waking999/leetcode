package leetcode.success.array;

public class SearchForARange {
	public int[] searchRange(int[] nums, int target) {
		int[] result=new int[] { -1, -1 };
		int n=nums.length;
		if(n==0){
			return result;
		}
	 
		int low=0;
		int high=n-1;
		int mid=0;
		while(low<=high){
			mid=(low+high)/2;
			if(nums[mid]>=target){
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		if(low>=n||nums[low]!=target){
			return result;
		}
		int left=low;
		high=n-1;
		while(low<=high){
			mid=(low+high)/2;
			if(nums[mid]<=target){
				low=mid+1;
			}else{
				high=mid-1;
			}
		} 	
		 
		result=new int[] { left, high };
		
		return result;
	}

	public static void main(String[] args) {
		SearchForARange s = new SearchForARange();

		int[] nums;
		int target;
		int[] expect;
		int[] output;

		nums = new int[] { 5, 7, 7, 8, 8, 10 };
		target = 8;
		expect = new int[] { 3, 4 };
		output = s.searchRange(nums, target);
		assert (expect.length == output.length) : "1:wrong";
		for(int i=0;i<expect.length;i++){
			assert (expect[i] == output[i]) : "1:wrong:"+i;
		}

		System.out.println("Finish");
	}

}
