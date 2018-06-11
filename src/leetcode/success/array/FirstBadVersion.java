package leetcode.success.array;

import org.junit.Test;

public class FirstBadVersion {
    boolean[] badVersions;

    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid;

        while (low + 1 < high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        if (isBadVersion(low)) {
            return low;
        }

        return high;
    }

    private boolean isBadVersion(int version) {
        return badVersions[version];
    }

    @Test
    public void test1() {
        FirstBadVersion s = new FirstBadVersion();

        int expect;
        int output;

        s.badVersions = new boolean[]{false, true, true, true, true};
        expect = 1;
        output = s.firstBadVersion(4);
        assert (expect == output) : "1:wrong";

        System.out.println("Finish");

    }

}
