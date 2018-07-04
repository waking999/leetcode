package leetcode.success.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/friends-of-appropriate-ages/description/
 * <p>
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.
 * <p>
 * Person A will NOT friend request person B (B != A) if any of the following conditions are true:
 * <p>
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B.
 * <p>
 * Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.
 * <p>
 * How many total friend requests are made?
 * <p>
 * Example 1:
 * <p>
 * Input: [16,16]
 * Output: 2
 * Explanation: 2 people friend request each other.
 * Example 2:
 * <p>
 * Input: [16,17,18]
 * Output: 2
 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
 * Example 3:
 * <p>
 * Input: [20,30,100,110,120]
 * Output:
 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 * <p>
 * <p>
 * Notes:
 * <p>
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 */
/*
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 */
public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int requestCount = 0;

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(ages);

        for (int age : ages) {
            if (map.containsKey(age)) {
                int count = map.get(age);
                map.put(age, count + 1);
            } else {
                map.put(age, 1);
            }

        }

        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            if (key > 14) {
                int sameAgeCount = map.get(key);
                int tempRequest = getRequestCount(sameAgeCount);
                requestCount += tempRequest;
            }
        }


        for (int a : keySet) {
            for (int b : keySet) {
                if (a > b) {
                    if ((!(b > 100 & a < 100)) && (!(b <= 0.5 * a + 7))) {
                        System.out.println(a + "," + b);
                        int aCount = map.get(a);
                        int bCount = map.get(b);
                        requestCount += aCount * bCount;
                    }
                }
            }
        }

        return requestCount;
    }


    private int getRequestCount(int sameAgeCount) {
        if (sameAgeCount == 1) {
            return 0;
        }

        return sameAgeCount * (sameAgeCount - 1);
    }

}
