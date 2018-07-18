package leetcode.success.graph;

import common.Util;
import leetcode.success.graph.NetworkDelayTime;
import org.junit.jupiter.api.Test;

public class NetworkDelayTimeTest {
    @Test
    public void test1(){
        NetworkDelayTime s=new NetworkDelayTime();

        int[][] times;
        int N;
        int K;
        int expect;
        int output;
        int seq=1;

        times=new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        N=4;
        K=2;
        expect=2;
        output=s.networkDelayTime(times,N,K);
        Util.verify(expect,output,seq++);

        times=new int[][]{{1,2,1}};
        N=2;
        K=2;
        expect=-1;
        output=s.networkDelayTime(times,N,K);
        Util.verify(expect,output,seq++);

        times=new int[][]{{1,2,1},{2,3,2},{1,3,2}};
        N=3;
        K=1;
        expect=2;
        output=s.networkDelayTime(times,N,K);
        Util.verify(expect,output,seq++);

        times=new int[][]{{4,1,2},{1,2,1},{2,3,2},{1,3,2}};
        N=4;
        K=4;
        expect=4;
        output=s.networkDelayTime(times,N,K);
        Util.verify(expect,output,seq++);


        times=new int[][]{{1,2,1},{2,3,7},{1,3,4},{2,1,2}};
        N=3;
        K=2;
        expect=6;
        output=s.networkDelayTime(times,N,K);
        Util.verify(expect,output,seq++);

        times=new int[][]{{1,2,1},{2,3,7},{1,3,4},{2,1,5}};
        N=3;
        K=2;
        expect=7;
        output=s.networkDelayTime(times,N,K);
        Util.verify(expect,output,seq++);

        times=new int[][]{{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
        N=5;
        K=5;
        expect=31;
        output=s.networkDelayTime(times,N,K);
        Util.verify(expect,output,seq++);

    }
}
