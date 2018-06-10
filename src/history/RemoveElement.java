package history;
import org.junit.Assert;
import org.junit.Test;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int numsLen=nums.length;
		int i=0;
		int j=0;
		for(;i<numsLen;i++){
			if(nums[i]==val){
				continue;
			}
			nums[j]=nums[i];
			j++;
		}
		return j;
	}

	@Test
	public void test1() {
		RemoveElement a=new RemoveElement();
		int[] nums={3,2,2,3};
		int val=		3;
		int actual=a.removeElement(nums,val);
		int expected=2;
		Assert.assertEquals(expected,actual);
		
	}
}
