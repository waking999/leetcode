package lintcode.google;

import leetcode.success.comm.Util;
import org.junit.Test;

public class BeautifulArrangement {
    private int count;
    private int[] array;
    private boolean[] hold;

    /**
     * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
     * <p>
     * The number at the ith position is divisible by i.
     * i is divisible by the number at the ith position.
     * Now given N, how many beautiful arrangements can you construct?
     * N is a positive integer and will not exceed 15.
     *
     * @param N: The number of integers
     * @return: The number of beautiful arrangements you can construct
     */


    public int countArrangement(int N) {
        // Write your code here
        if (N <= 3) {
            return N;
        }


        array = new int[N + 1];
        hold = new boolean[N + 1];
        count=0;

        permute(1,N);

        return count;
    }

    private void permute(int step, int N) {
        if (step == N+1) {
            count++;

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!hold[i]) {
                if (step % i == 0 || i % step == 0) {
                    array[step] = i;
                    hold[i] = true;
                    permute(step + 1, N);
                    hold[i] = false;
                }
            }
        }
    }

//    private void swap(int[] combin, int i, int j) {
//        int tmp = combin[i];
//        combin[i] = combin[j];
//        combin[j] = tmp;
//    }
//
//    private void change(int[] combin, int pointer, int len) {
//        if (pointer == len - 1) {
//            boolean beCounted = true;
//            for (int j = 0; j < len; j++) {
//                if (!((combin[j] % (j + 1) == 0) || ((j + 1) % combin[j] == 0))) {
//                    beCounted = false;
//                    break;
//                }
//            }
//            if (beCounted) {
//                count++;
//                StringBuilder sb = new StringBuilder();
//                sb.append(count).append(":");
//                for (int i = 0; i < len; i++) {
//                    sb.append(combin[i]).append(",");
//                }
//                System.out.println(sb.toString());
//
//            }
//
//
//        } else {
//            for (int i = pointer; i < len; i++) {
//                //if (((combin[i]%(pointer+1)==0)||((pointer+1)%combin[i]==0))
//                //       &&((combin[pointer]%(i+1)==0)||((i+1)%combin[pointer]==0))) {
//                swap(combin, pointer, i);
//
//                change(combin, pointer + 1, len);
//                swap(combin, pointer, i);
//                // }
//            }
//        }
//    }

    @Test
    public void testcountArrangement() {
        BeautifulArrangement s = new BeautifulArrangement();

        int N;
        int expect;
        int output;
        int seq = 1;

        N = 1;
        expect = 1;
        output = s.countArrangement(N);
        Util.verify(expect, output, seq++);

        N = 2;
        expect = 2;
        output = s.countArrangement(N);
        Util.verify(expect, output, seq++);

        N = 3;
        expect = 3;
        output = s.countArrangement(N);
        Util.verify(expect, output, seq++);

        N = 4;
        expect = 8;
        output = s.countArrangement(N);
        Util.verify(expect, output, seq++);

        N = 5;
        expect = 10;
        output = s.countArrangement(N);
        Util.verify(expect, output, seq++);

        N = 6;
        expect = 36;
        output = s.countArrangement(N);
        Util.verify(expect, output, seq++);
    }


}
