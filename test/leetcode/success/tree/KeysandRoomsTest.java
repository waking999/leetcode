package leetcode.success.tree;

import common.Util;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class KeysandRoomsTest {

    private List<List<Integer>> getInputList(int[][] inputs){
        List<List<Integer>> rtn=new ArrayList<>();

        for(int[] input:inputs){
            List<Integer> tmp=new ArrayList<>();
            for(int i:input){
                tmp.add(i);
            }
            rtn.add(tmp);
        }
        return rtn;
    }


    @Test
    public void test1(){
        KeysandRooms s=new KeysandRooms();

        int[][] inputs;
        List<List<Integer>> rooms;
        boolean expect;
        boolean output;
        int seq=1;

        inputs=new int[][]{{1},{2},{3},{}};
        rooms=this.getInputList(inputs);
        expect=true;
        output=s.canVisitAllRooms(rooms);
        Util.verify(expect,output,seq++);

        inputs=new int[][]{{1,3},{3,0,1},{2},{0}};
        rooms=this.getInputList(inputs);
        expect=false;
        output=s.canVisitAllRooms(rooms);
        Util.verify(expect,output,seq++);


    }
}
