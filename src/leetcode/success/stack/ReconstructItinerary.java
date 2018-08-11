package leetcode.success.stack;

import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 * <p>
 * Input: tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 * <p>
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 */
public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null) {
            return null;
        }
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] t : tickets) {
            String s = t[0];
            String d = t[1];
            map.computeIfAbsent(s, k -> new PriorityQueue<>()).add(d);
        }

        String s = "JFK";
        List<String> rtn = new ArrayList<>();


        Stack<String> stack = new Stack<>();
        stack.add(s);
        while (!stack.isEmpty()) {

            while (map.containsKey(stack.peek()) && (!map.get(stack.peek()).isEmpty())) {
                stack.push(map.get(stack.peek()).poll());
            }
            rtn.add(0,stack.pop());
        }
        return rtn;
    }
}
