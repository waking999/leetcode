package history;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class HeapSortTest {

    @Test
    public void test1() {

        HeapSort s = new HeapSort();

        int[] array;
        int[] expect;
        int[] output;

        array = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        expect = new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        output = s.sort(array);
        verifyUnsort(expect, output, 1);


        array = new int[]{4, 1, 3, 2, 16, 9, 14, 10, 8, 7};
        expect = new int[]{1, 2, 3, 4, 7, 8, 9, 10, 14, 16};
        output = s.sort(array);
        verifyUnsort(expect, output, 2);

    }
}
