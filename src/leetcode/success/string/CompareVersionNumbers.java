package leetcode.success.string;

import leetcode.success.comm.Util;
import org.junit.Test;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) {
            return 0;
        }
        if (version1 == null) {
            return -1;
        }
        if (version2 == null) {
            return 1;
        }
        version1 = removePrefixZero(version1);
        version1 = removeSuffixZero(version1);
        version2 = removePrefixZero(version2);
        version2 = removeSuffixZero(version2);

        return compare(version1, version2);
    }

    private String removePrefixZero(String version) {
        String strPattern = "^0+";
        String rtn = version.replaceAll(strPattern, "");
        if (rtn.indexOf(".") == 0) {
            rtn = "0" + rtn;
        }else if(rtn.length()==0){
            rtn="0";
        }

        return rtn;

    }

    private String removeSuffixZero(String version) {
        String strPattern = "\\.{1}0+$";

        String rtn = version.replaceAll(strPattern, "");
        while(!rtn.equals(version)){
            version=rtn;
            rtn=version.replaceAll(strPattern, "");
        }

        return rtn;


    }


    private int compare(String a, String b) {
        String[] aStrs = a.split("\\.");
        String[] bStrs = b.split("\\.");


        int aStrsLen = aStrs.length;
        int bStrsLen = bStrs.length;

        int len = Math.min(aStrsLen, bStrsLen);

        for (int i = 0; i < len; i++) {
            String aStr = aStrs[i];
            String bStr = bStrs[i];
            int cmp = Integer.parseInt(aStr) - Integer.parseInt(bStr);
            if (cmp == 0) {
                continue;
            } else {
                return cmp / Math.abs(cmp);
            }
        }

        int aStrsLenRemining = aStrsLen - len;
        int bStrsLenRemining = bStrsLen - len;

        if (aStrsLenRemining == 0 && bStrsLenRemining == 0) {
            return 0;
        } else if (aStrsLenRemining == 0) {
            return -1;
        } else {
            return 1;
        }

    }

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
