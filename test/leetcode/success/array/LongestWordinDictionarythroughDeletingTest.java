package leetcode.success.array;

import common.Util;
import leetcode.success.array.LongestWordinDictionarythroughDeleting;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LongestWordinDictionarythroughDeletingTest {
    @Test
    public void test1(){
        LongestWordinDictionarythroughDeleting s=new LongestWordinDictionarythroughDeleting();

        String[] dictStr;
        List<String> d;
        String str;
        String expect;
        String output;
        int seq=1;

        dictStr=new String[]{"ale","apple","monkey","plea"};
        d= Arrays.asList(dictStr);
        str="abpcplea";
        expect="apple";
        output=s.findLongestWord(str,d);
        Util.verify(expect,output,seq++);

        dictStr=new String[]{ "a","b","c"};
        d= Arrays.asList(dictStr);
        str="abpcplea";
        expect="a";
        output=s.findLongestWord(str,d);
        Util.verify(expect,output,seq++);

        dictStr=new String[]{ "aaa","aa","a"};
        d= Arrays.asList(dictStr);
        str="aaa";
        expect="aaa";
        output=s.findLongestWord(str,d);
        Util.verify(expect,output,seq++);

    }
}
