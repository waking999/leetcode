package leetcode.success.array;

import java.util.*;

/**
 * https://leetcode.com/problems/exclusive-time-of-functions/description/
 * Given the running logs of n functions that are executed in a nonpreemptive single threaded CPU, find the exclusive time of these functions.
 * <p>
 * Each function has a unique id, start from 0 to n-1. A function may be called recursively or by another function.
 * <p>
 * A log is a string has this format : function_id:start_or_end:timestamp. For example, "0:start:0" means function 0 starts from the very beginning of time 0. "0:end:0" means function 0 ends to the very end of time 0.
 * <p>
 * Exclusive time of a function is defined as the time spent within this function, the time spent by calling other functions should not be considered as this function's exclusive time. You should return the exclusive time of each function sorted by their function id.
 * <p>
 * Example 1:
 * Input:
 * n = 2
 * logs =
 * ["0:start:0",
 * "1:start:2",
 * "1:end:5",
 * "0:end:6"]
 * Output:[3, 4]
 * Explanation:
 * Function 0 starts at time 0, then it executes 2 units of time and reaches the end of time 1.
 * Now function 0 calls function 1, function 1 starts at time 2, executes 4 units of time and end at time 5.
 * Function 0 is running again at time 6, and also end at the time 6, thus executes 1 unit of time.
 * So function 0 totally execute 2 + 1 = 3 units of time, and function 1 totally execute 4 units of time.
 * Note:
 * Input logs will be sorted by timestamp, NOT log id.
 * Your output should be sorted by function id, which means the 0th element of your output corresponds to the exclusive time of function 0.
 * Two functions won't start or end at the same time.
 * Functions could be called recursively, and will always end.
 * 1 <= n <= 100
 */
public class ExclusiveTimeofFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] rtn = new int[n];
        Arrays.fill(rtn, 0);

        Stack<Wrap> wrapStack = new Stack<>();
        Map<Long, Integer> indexMap = new HashMap<>();


        int currentRtnLen = 0;
        for (String log : logs) {
            Wrap w = new Wrap(log);

            Set<Long> keySet = indexMap.keySet();

            if (w.isStart) {

                int index = -1;
                if (keySet.contains(w.timestamp)) {
                    index = indexMap.get(w.timestamp);
                } else {
                    index = currentRtnLen;
                    indexMap.put(w.timestamp, index);
                    currentRtnLen++;
                }

                if (!wrapStack.isEmpty()) {
                    //since lastIndex job not finished, we keep it,
                    // but we don't know the new start time until we meet the end of the internal function index & its end
                    Wrap lastW = wrapStack.peek();
                    int lastIndex = indexMap.get(lastW.timestamp);
                    int unit = w.timePointer - lastW.timePointer;
                    rtn[lastIndex] += unit;
                }
                wrapStack.push(w);
            } else {
                int index = indexMap.get(w.timestamp);
                Wrap currentW = wrapStack.pop();

                int unit = w.timePointer - currentW.timePointer + 1;
                rtn[index] += unit;
                //we know the end of the internal function now, and the start of the outer function is the next sec of the end
                if (!wrapStack.isEmpty()) {
                    Wrap lastW = wrapStack.peek();
                    lastW.timePointer = w.timePointer + 1;

                }

            }
        }

        return rtn;
    }

    class Wrap {
        int timePointer;
        long timestamp;
        boolean isStart;

        Wrap(String log) {
            String[] info = log.split(":");
            timestamp = Long.parseLong(info[0]);
            isStart = "start".equals(info[1]);
            timePointer = Integer.parseInt(info[2]);
        }
    }
}