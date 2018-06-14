package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

import static leetcode.success.comm.Util.*;

public class SearchinRotatedSortedArrayTest {
    @Test
    public void test1() {
        SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();

        int[] nums;
        int target;
        int expect;
        int output;
        int seq = 0;

        nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = 5;
        expect = 1;
        output = s.search(nums, target);
        verify(expect, output, ++seq);

        nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = 1;
        expect = 5;
        output = s.search(nums, target);
        verify(expect, output, ++seq);

        nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = 15;
        expect = -1;
        output = s.search(nums, target);
        verify(expect, output, ++seq);


        nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = -1;
        expect = -1;
        output = s.search(nums, target);
        verify(expect, output, ++seq);


        nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        target = 3;
        expect = -1;
        output = s.search(nums, target);
        verify(expect, output, ++seq);

        nums = new int[] { 1 };
        target = 1;
        expect = 0;
        output = s.search(nums, target);
        verify(expect, output, ++seq);


        nums = new int[] { 1,3 };
        target = 3;
        expect = 1;
        output = s.search(nums, target);
        verify(expect, output, ++seq);


		nums = new int[] { 3,1,1,1 ,1};
		target = 3;
		expect = 0;
		output = s.search(nums, target);
		verify(expect, output, ++seq);

		nums = new int[] { 1,1};
		target = 2;
		expect = -1;
		output = s.search(nums, target);
		verify(expect, output, ++seq);

        nums = new int[] { 5,1,3};
        target = 3;
        expect = 2;
        output = s.search(nums, target);
        verify(expect, output, ++seq);


		nums = new int[] { 1,3,1,1,1};
		target = 3;
		expect = 1;
		output = s.search(nums, target);
		verify(expect, output, ++seq);

        nums = new int[] { 3,5,1};
        target = 3;
        expect = 0;
        output = s.search(nums, target);
        verify(expect, output, ++seq);

		nums = new int[] { 1,1,3,1};
		target = 3;
		expect = 2;
		output = s.search(nums, target);
		verify(expect, output, ++seq);
    }
}
