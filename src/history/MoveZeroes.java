package history;
import org.junit.Assert;
import org.junit.Test;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int numsLen=nums.length;
		int j=0;
		for(int i=0;i<numsLen;i++){
			if(nums[i]==0){
				continue;
			}
			nums[j]=nums[i];
			j++;
		}
		for(int i=j;i<numsLen;i++){
			nums[i]=0;
		}
		
//		int numsLen=nums.length; 
//		 
//		int zeroCount=0;
//		for(int i=0;i<numsLen;i++){
//			if(nums[i]==0){
//				zeroCount++;
//			}
//		}
//		int nonZeroCount=numsLen-zeroCount;
//		
//		for(int i=0;i<nonZeroCount;i++){
//			if(nums[i]==0){
//				 for(int j=i+1;j<numsLen;j++){
//					 nums[j-1]=nums[j];
//				 }
//				 nums[numsLen-1]=0;
//				 i=i-1;
//			}
//		} 
		
		
	}
	
	@Test
	public void test1(){
		MoveZeroes a=new MoveZeroes();
		
		int[] nums={0, 1, 0, 3, 12};
		int[] expecteds={1,3,12,0,0};
		
		a.moveZeroes(nums);
		Assert.assertArrayEquals(expecteds, nums);
		
	}
	
	@Test
	public void test2(){
		MoveZeroes a=new MoveZeroes();
		
		int[] nums={0, 0, 1};
		int[] expecteds={1,0,0};
		
		a.moveZeroes(nums);
		Assert.assertArrayEquals(expecteds, nums);
		
	}
}
