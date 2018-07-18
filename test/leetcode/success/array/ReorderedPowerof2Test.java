package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class ReorderedPowerof2Test {
    @Test
    public void test1(){
        ReorderedPowerof2 s=new ReorderedPowerof2();


        int N;
        boolean expect;
        boolean output;
        int seq=1;

        N=1;
        expect=true;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);


        N=10;
        expect=false;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);

        N=16;
        expect=true;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);

        N=24;
        expect=false;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);

        N=46;
        expect=true;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);


        N=821;
        expect=true;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);

        N=38416;
        expect=true;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);

        N=38415;
        expect=false;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);


        N=1024;
        expect=true;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);


        N=1023;
        expect=false;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);

        N=213107;
        expect=true;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);

        N=9702152;
        expect=true;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);

        N=9702153;
        expect=false;
        output=s.reorderedPowerOf2(N);
        Util.verify(expect,output,seq++);
    }
}
