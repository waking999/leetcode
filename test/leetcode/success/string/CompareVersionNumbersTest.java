package leetcode.success.string;

import common.Util;
import org.junit.Test;

public class CompareVersionNumbersTest {
    @Test
    public void testremovePrefixZero() {
        CompareVersionNumbers s = new CompareVersionNumbers();

        String version;
        String expect;
        String output;
        int seq = 1;

        version = "01";
        expect = "1";
        output = s.removePrefixZero(version);
        Util.verify(expect, output, seq++);

        version = "00001";
        expect = "1";
        output = s.removePrefixZero(version);
        Util.verify(expect, output, seq++);


        version = "000100";
        expect = "100";
        output = s.removePrefixZero(version);
        Util.verify(expect, output, seq++);

        version = "0.1";
        expect = "0.1";
        output = s.removePrefixZero(version);
        Util.verify(expect, output, seq++);


        version = "0000.1";
        expect = "0.1";
        output = s.removePrefixZero(version);
        Util.verify(expect, output, seq++);


        version = "0";
        expect = "0";
        output = s.removePrefixZero(version);
        Util.verify(expect, output, seq++);

        version = "0000";
        expect = "0";
        output = s.removePrefixZero(version);
        Util.verify(expect, output, seq++);
    }


    @Test
    public void testremoveSuffixZero() {
        CompareVersionNumbers s = new CompareVersionNumbers();

        String version;
        String expect;
        String output;
        int seq = 1;

        version = "10";
        expect = "10";
        output = s.removeSuffixZero(version);
        Util.verify(expect, output, seq++);

        version = "1.0";
        expect = "1";
        output = s.removeSuffixZero(version);
        Util.verify(expect, output, seq++);


        version = "1.0000000000000000";
        expect = "1";
        output = s.removeSuffixZero(version);
        Util.verify(expect, output, seq++);

        version = "1.1110000";
        expect = "1.1110000";
        output = s.removeSuffixZero(version);
        Util.verify(expect, output, seq++);


        version = "0000.1";
        expect = "0000.1";
        output = s.removeSuffixZero(version);
        Util.verify(expect, output, seq++);


        version = "0";
        expect = "0";
        output = s.removeSuffixZero(version);
        Util.verify(expect, output, seq++);

        version = "0000";
        expect = "0000";
        output = s.removeSuffixZero(version);
        Util.verify(expect, output, seq++);


        version = "1.0.000.00.0.00";
        expect = "1";
        output = s.removeSuffixZero(version);
        Util.verify(expect, output, seq++);

        version = "1.0.000.1.0.00";
        expect = "1.0.000.1";
        output = s.removeSuffixZero(version);
        Util.verify(expect, output, seq++);
    }

    @Test
    public void testcompareVersion() {
        CompareVersionNumbers s = new CompareVersionNumbers();

        String version1;
        String version2;
        int expect;
        int output;
        int seq = 1;

        version1 = "0.1";
        version2 = "1.1";
        expect = -1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);


        version1 = "1.0.1";
        version2 = "1";
        expect = 1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);

        version1 = "1";
        version2 = "1.0.1";
        expect = -1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);


        version1 = "7.5.2.4";
        version2 = "7.5.3";
        expect = -1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);

        version1 = "7.5.2.4";
        version2 = "7.5.2";
        expect = 1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);

        version1 = "7.5.3";
        version2 = "7.5.2.4";
        expect = 1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);

        version1 = "7.5.2";
        version2 = "7.5.2.4";
        expect = -1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);

        version1 = "01";
        version2 = "1";
        expect = 0;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);


        version1 = "1";
        version2 = "0";
        expect = 1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);


        version1 = "1.0";
        version2 = "1.2";
        expect = -1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);


        version1 = "1.2";
        version2 = "1.10";
        expect = -1;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);

        version1 = "1.0";
        version2 = "1";
        expect = 0;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);

        version1 = "1.0.0.00.00.0";
        version2 = "1";
        expect = 0;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);


        version1 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
        version2 = "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000";
        expect = 0;
        output = s.compareVersion(version1, version2);
        Util.verify(expect, output, seq++);
    }
}
