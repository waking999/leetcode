package leetcode.success.array;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int low=0;
		int high=nums.length-1;
		
		while(low<=high){
			int mid=(high+low)/2;
			if(nums[mid]==target){
				return mid;
			}else if(nums[mid]<target){
				low=mid+1;
			}else{
				high=mid-1;
			}
		}
		
		return low;
	}

	public static void main(String[] args) {
		SearchInsertPosition s = new SearchInsertPosition();
		
		int[] nums;
		int target;
		int expect;
		int output;
		
		
		nums=new int[]{1,3,5,6};
		target=5;
		expect=2;
		output=s.searchInsert(nums,target);
		assert(output==expect):"1.wrong";
		
		nums=new int[]{1,3,5,6};
		target=2;
		expect=1;
		output=s.searchInsert(nums,target);
		assert(output==expect):"2.wrong";
		
		
		nums=new int[]{1,3,5,6};
		target=7;
		expect=4;
		output=s.searchInsert(nums,target);
		assert(output==expect):"3.wrong";
		
		
		nums=new int[]{1,3,5,6};
		target=0;
		expect=0;
		output=s.searchInsert(nums,target);
		assert(output==expect):"4.wrong";
		 
		
		System.out.println("Finish");
	}

}
