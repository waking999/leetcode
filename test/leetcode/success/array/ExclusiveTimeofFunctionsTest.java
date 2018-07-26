package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ExclusiveTimeofFunctionsTest {
    @Test
    public void test1() {
        ExclusiveTimeofFunctions s = new ExclusiveTimeofFunctions();

        int n;
        String[] logsArr;
        List<String> logs;
        int[] expect;
        int[] output;
        int seq = 1;


        n = 2;
        logsArr = new String[]{"0:start:0", "1:start:2", "1:end:5", "0:end:6"};
        logs = Arrays.asList(logsArr);
        expect = new int[]{3, 4};
        output = s.exclusiveTime(n, logs);
        Util.verifyUnsort(expect,output,seq++);




        n = 1;
        logsArr = new String[]{"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
        logs = Arrays.asList(logsArr);
        expect = new int[]{8};
        output = s.exclusiveTime(n, logs);
        Util.verifyUnsort(expect,output,seq++);


        n = 1;
        logsArr = new String[]{"0:start:0", "0:end:0"};
        logs = Arrays.asList(logsArr);
        expect = new int[]{1};
        output = s.exclusiveTime(n, logs);
        Util.verifyUnsort(expect,output,seq++);

    }
}
