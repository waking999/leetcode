package leetcode.success.array;

import common.Util;
import leetcode.success.array.KthLargest;
import org.junit.jupiter.api.Test;

public class KthLargestTest {
    @Test
    public void test1(){
        int k;
        int[] arr;
        int expect;
        int output;
        int seq=1;

        k = 3;
        arr = new int[]{4,5,8,2};
        KthLargest kthLargest = new KthLargest(k, arr);

        expect=4;
        output=kthLargest.add(3);
        Util.verify(expect,output,seq++);

        expect=5;
        output=kthLargest.add(5);
        Util.verify(expect,output,seq++);

        expect=5;
        output=kthLargest.add(10);
        Util.verify(expect,output,seq++);


        expect=8;
        output=kthLargest.add(9);
        Util.verify(expect,output,seq++);


        expect=8;
        output=kthLargest.add(4);   // returns 4
        Util.verify(expect,output,seq++);

    }

    @Test
    public void test2(){


        KthLargest s=new KthLargest(7,new int[]{-10,1,3,1,4,10,3,9,4,5,1});

        String[] operations=new String[]{"add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add"};
        int[][] params=new int[][]{{3},{2},{3},{1},{2},{4},{5},{5},{6},{7},{7},{8},{2},{3},{1},{1},{1},{10},{11},{5},{6},{2},{4},{7},{8},{5},{6}};
        runTest(s,operations,params);
    }

    private void runTest(KthLargest s,String[] operations, int[][] params ) {

        int seq = 1;

        int len = operations.length;
        for (int i = 0; i < len; i++) {
            String op = operations[i];
            int[] param = params[i];
            if ("add".equals(op)) {
                s.add(param[0]);
            }
        }
    }

}
