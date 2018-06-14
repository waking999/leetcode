package leetcode.success.array;

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


}
