package leetcode.success.array;

public class MaximizeDistancetoClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int seatsLen = seats.length;
        int maxDis = 1;

        int left = -1;
        int start = 1;

        if (seats[0] == 1) {
            left = 0;
            start = 0;
        }

        for (int i = start; i < seatsLen; i++) {
            if (seats[i] == 1) {
                int leftDis = i - left;
                if (left == -1) {
                    leftDis = (leftDis - 1) * 2;
                }
                maxDis = Math.max(maxDis, leftDis);
                left = i;
            }
        }


        if (left != seatsLen - 1) {
            int leftDis = (seatsLen - 1 - left) * 2;
            maxDis = Math.max(leftDis, maxDis);
        }


        return maxDis / 2;

    }


}
