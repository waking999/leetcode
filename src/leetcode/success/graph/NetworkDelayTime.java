package leetcode.success.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/network-delay-time/description/
 * There are N network nodes, labelled 1 to N.
 * <p>
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 * <p>
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 * <p>
 * Note:
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
 */
public class NetworkDelayTime {

    private int getMinTimeV(int[] time, boolean[] vExists, int N) {
        int minTimeV = -1;
        int minTime = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (vExists[i] && time[i] < minTime) {
                minTime = time[i];
                minTimeV = i;
            }
        }
        return minTimeV;
    }

    private int getMaxTime(int[] time, int N) {

        int maxTime = -1;
        for (int i = 1; i <= N; i++) {
            if (  time[i] > maxTime) {
                maxTime = time[i];
            }
        }
        return maxTime;
    }

    private int[] getShorestPath(int N, int K, Map<Integer, List<int[]>> children) {
        int[] time = new int[N + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[K] = 0;

        int[] prev = new int[N + 1];
        Arrays.fill(prev, -1);

        boolean[] vExists = new boolean[N + 1];
        Set<Integer> vSet = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            vSet.add(i);
            vExists[i] = true;
        }

        while (!vSet.isEmpty()) {
            int u = getMinTimeV(time, vExists, N);
            if(u!=-1) {
                vSet.remove(u);
                vExists[u] = false;

                List<int[]> list = children.get(u);
                if (list != null)
                    for (int[] node : list) {
                        int v = node[1];
                        int newArriveTime = time[u] + node[2];
                        if (newArriveTime < time[v]) {
                            time[v] = newArriveTime;
                            prev[v] = u;
                        }

                    }
            }else{
                break;
            }
        }

        return time;
    }


    public int networkDelayTime(int[][] times, int N, int K) {
        int timesLen = times.length;
        boolean[] visited = new boolean[timesLen];
        Arrays.fill(visited, false);

        Map<Integer, List<int[]>> children = new HashMap<>();
        //first time go through to get children list
        for (int i = 0; i < timesLen; i++) {
            int u = times[i][0];
            int v = times[i][1];
            if (v == K) {
                continue;
            }
            if (children.containsKey(u)) {
                List<int[]> list = children.get(u);
                list.add(times[i]);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(times[i]);
                children.put(u, list);
            }
        }

        int[] arriveTime = getShorestPath(N, K, children);
        int maxArriveTime  = getMaxTime(arriveTime,N);
        if(maxArriveTime==Integer.MAX_VALUE){
            return -1;
        }
        return maxArriveTime;
    }
}