package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class QueueReconstructionbyHeightTest {
    @Test
    public void test1(){
        QueueReconstructionbyHeight s=new QueueReconstructionbyHeight();
        /*
         * Input:
         * [[7,0},{4,4},{7,1},{5,0},{6,1},{5,2]]
         *
         * Output:
         * [[5,0},{7,0},{5,2},{6,1},{4,4},{7,1]]
         */
        
        int[][] people;
        int[][] expect;
        int[][] output;
        int seq=1;
        
        people=new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        expect=new int[][]{{5,0},{7,0},{5,2},{6,1},{4,4},{7,1}};
        output=s.reconstructQueue(people);
        Util.verifyUnsort(expect,output,seq++);

    }
}
