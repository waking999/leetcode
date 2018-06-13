package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix==null){
            return true;
        }
        int rLen=matrix.length;
        if(rLen==0){
            return true;
        }
        int cLen=matrix[0].length;
        if(cLen<=1){
            return true;
        }
        for(int i=0;i<rLen-1;i++){
            int[] base=matrix[i];
            for(int j=i+1;j<rLen;j++){
                int[] compare=matrix[j];
                if(!isSame(base,compare,j-i)){
                    return false;
                }
            }
        }


        return true;
    }

    private boolean isSame(int[] base,int[] compare,int start){

        int compareLen=compare.length;

        for(int i=start;i<compareLen;i++){
            if(base[i-start]!=compare[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void testIsToeplitzMatrix(){
        ToeplitzMatrix s=new ToeplitzMatrix();

        int[][] matrix;
        boolean expect;
        boolean output;
        int seq=0;

        matrix = new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2},{6,9,5,1}};
        expect=true;
        output=s.isToeplitzMatrix(matrix);
        Util.verify(expect,output,seq++);


        matrix = new int[][]{{1,2},{2,2}};
        expect=false;
        output=s.isToeplitzMatrix(matrix);
        Util.verify(expect,output,seq++);

    }
}
