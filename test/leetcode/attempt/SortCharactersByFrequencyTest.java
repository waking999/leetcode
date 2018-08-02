package leetcode.attempt;

import common.Util;
import leetcode.success.array.SortCharactersByFrequency;
import org.junit.jupiter.api.Test;

public class SortCharactersByFrequencyTest {
    @Test
    public void test1(){
        SortCharactersByFrequency s=new SortCharactersByFrequency();

        String input;
        String expect;
        String output;
        int seq=1;

        input="tree";
        expect="eert"; //"eetr"
        output=s.frequencySort(input);
        Util.verify(expect,output,seq++);


        input="cccaaa";
        expect="aaaccc"; //"aaaccc"
        output=s.frequencySort(input);
        Util.verify(expect,output,seq++);

        input="Aabb";
        expect="bbAa"; //"bbaA"
        output=s.frequencySort(input);
        Util.verify(expect,output,seq++);


        input="2a554442f544asfasssffffasss";
        expect="sssssssffffff44444aaaa55522"; //"bbaA"
        output=s.frequencySort(input);
        Util.verify(expect,output,seq++);

    }
}
