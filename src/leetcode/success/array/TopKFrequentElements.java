package leetcode.success.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            if (freq.containsKey(i)) {
                int c = freq.get(i);
                freq.put(i, c + 1);
            } else {
                freq.put(i, 1);
            }
        }
        int freqSize = freq.size();
        int[] vals = new int[freqSize];
        int[] freqs = new int[freqSize];
        Set<Map.Entry<Integer, Integer>> entries = freq.entrySet();
        int index = 0;
        for (Map.Entry<Integer, Integer> entity : entries) {
            int val = entity.getKey();
            int frequency = entity.getValue();
            vals[index] = val;
            freqs[index] = frequency;
            index++;
        }

        mergeSort(vals, freqs, 0, freqSize - 1);

        List<Integer> rtn=new ArrayList<>();
        if(freqSize<=k){
           List<Integer> l= Arrays.stream(vals).boxed().collect(Collectors.toList());
            rtn.addAll(l);
        }else{
            for(int i=0;i<k;i++){
                rtn.add(vals[i]);
            }
        }

        return rtn;
    }

    private void mergeSort(int[] vals, int[] freqs, int l, int r) {
        if(l>=r){
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(vals, freqs, l, m);
        mergeSort(vals, freqs, m + 1, r);
        merge(vals, freqs, l, m, r);
    }

    private void merge(int[] vals, int[] freqs, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int valsL[] = new int[n1];
        int valsR[] = new int[n2];

        int freqsL[] = new int[n1];
        int freqsR[] = new int[n2];

        for (int i = 0; i < n1; ++i) {
            valsL[i] = vals[l + i];
            freqsL[i] = freqs[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            valsR[j] = vals[m + 1 + j];
            freqsR[j] = freqs[m + 1 + j];
        }

        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (freqsL[i] >= freqsR[j]) {
                freqs[k] = freqsL[i];
                vals[k] = valsL[i];
                i++;
            } else {
                freqs[k] = freqsR[j];
                vals[k] = valsR[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            vals[k] = valsL[i];
            freqs[k] = freqsL[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            vals[k] = valsR[j];
            freqs[k] = freqsR[j];
            j++;
            k++;
        }

    }

}
