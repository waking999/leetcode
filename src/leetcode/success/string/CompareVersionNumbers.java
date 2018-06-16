package leetcode.success.string;

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

    String removePrefixZero(String version) {
        String strPattern = "^0+";
        String rtn = version.replaceAll(strPattern, "");
        if (rtn.indexOf(".") == 0) {
            rtn = "0" + rtn;
        } else if (rtn.length() == 0) {
            rtn = "0";
        }

        return rtn;

    }

    String removeSuffixZero(String version) {
        String strPattern = "\\.0+$";

        String rtn = version.replaceAll(strPattern, "");
        while (!rtn.equals(version)) {
            version = rtn;
            rtn = version.replaceAll(strPattern, "");
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
            if (cmp != 0) {
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


}
