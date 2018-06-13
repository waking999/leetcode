package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;
import org.junit.Test;

public class MaximumSwap {
	public int maximumSwap(int num) {

		int num1 = num;

		int count = 0;
		int[] digits = new int[10];

		while (num1 != 0) {
			digits[count] = num1 % 10;
			count++;
			num1 = num1 / 10;
		}

		int[] digits1 = Arrays.copyOfRange(digits, 0, count);
		reverse(digits1);
		int[] digits2 = Arrays.copyOf(digits1, count);
		Arrays.sort(digits2);
		reverse(digits2);
		
		for(int i=0;i<count;i++) {
			if(digits1[i]!=digits2[i]) {
				//locate digit2[i] in digits1
				int pos=locate(digits1, digits2[i]);
				int a=digits1[i];
				digits1[i]=digits1[pos];
				digits1[pos]=a;	
				break;
			}
		}
		
		int sum=0;
		for(int i=0;i<count;i++) {
			sum=sum*10+digits1[i];
		}

		return sum;
	}
	
	private int locate(int[] data, int val) {
		int dataLen=data.length;
		for(int i=dataLen-1;i>=0;i--) {
			if(data[i]==val) {
				return i;
			}
		}
		return -1;
	}

	private void reverse(int[] data) {
		int left = 0;
		int right = data.length - 1;

		while (left < right) {
			// swap the values at the left and right indices
			int temp = data[left];
			data[left] = data[right];
			data[right] = temp;

			// move the left and right index pointers in toward the center
			left++;
			right--;
		}
	}

    @Test
    public void test1() {
		MaximumSwap s = new MaximumSwap();

		int num;
		int expect;
		int output;

		num = 2736;
		expect = 7236;
		output = s.maximumSwap(num);
		Util.verify(expect, output, 1);

		num = 9973;
		expect = 9973;
		output = s.maximumSwap(num);
		Util.verify(expect, output, 2);

		num = -7236;
		expect = -2736;
		output = s.maximumSwap(num);
		Util.verify(expect, output, 3);

		num = 98368;
		expect = 98863;
		output = s.maximumSwap(num);
		Util.verify(expect, output, 4);
		// 98368

		num = 87367;
		expect = 87763;
		output = s.maximumSwap(num);
		Util.verify(expect, output, 5);
	}

}
