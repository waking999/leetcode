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


}
