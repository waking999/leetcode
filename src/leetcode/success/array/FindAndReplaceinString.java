package leetcode.success.array;

/**
 * https://leetcode.com/problems/find-and-replace-in-string/description/
 *
 * To some string S, we will perform some replacement operations that replace groups of letters with new ones (not necessarily the same size).
 * <p>
 * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.  The rule is that if x starts at position i in the original string S, then we will replace that occurrence of x with y.  If not, we do nothing.
 * <p>
 * For example, if we have S = "abcd" and we have some replacement operation i = 2, x = "cd", y = "ffff", then because "cd" starts at position 2 in the original string S, we will replace it with "ffff".
 * <p>
 * Using another example on S = "abcd", if we have both the replacement operation i = 0, x = "ab", y = "eee", as well as another replacement operation i = 2, x = "ec", y = "ffff", this second operation does nothing because in the original string S[2] = 'c', which doesn't match x[0] = 'e'.
 * <p>
 * All these operations occur simultaneously.  It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * Output: "eeebffff"
 * Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
 * "cd" starts at index 2 in S, so it's replaced by "ffff".
 * Example 2:
 * <p>
 * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * Output: "eeecd"
 * Explanation: "ab" starts at index 0 in S, so it's replaced by "eee".
 * "ec" doesn't starts at index 2 in the original S, so we do nothing.
 * Notes:
 * <p>
 * 0 <= indexes.length = sources.length = targets.length <= 100
 * 0 < indexes[i] < S.length <= 1000
 * All characters in given inputs are lowercase letters.
 */
public class FindAndReplaceinString {

    private void mergeSort(int[] indexes, String[] sources, String[] targets, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(indexes, sources, targets, l, m);
            mergeSort(indexes, sources, targets, m + 1, r);
            merge(indexes, sources, targets, l, m, r);
        }
    }

    private void merge(int[] indexes, String[] sources, String[] targets, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] indexesL = new int[n1];
        int[] indexesR = new int[n2];
        String[] sourcesL = new String[n1];
        String[] sourcesR = new String[n2];
        String[] targetsL = new String[n1];
        String[] targetsR = new String[n2];

        for (int i = 0; i < n1; i++) {
            indexesL[i] = indexes[l+i];
            sourcesL[i] = sources[l+i];
            targetsL[i] = targets[l+i];
        }

        for (int j = 0; j < n2; j++) {
            indexesR[j] = indexes[m + j + 1];
            sourcesR[j] = sources[m + j + 1];
            targetsR[j] = targets[m + j + 1];
        }


        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (indexesL[i] <= indexesR[j]) {
                copyArr(k, i, indexes, indexesL, sources, sourcesL, targets, targetsL);
                i++;
            } else {
                copyArr(k, j, indexes, indexesR, sources, sourcesR, targets, targetsR);
                j++;
            }
            k++;
        }

        while (i < n1) {
            copyArr(k, i, indexes, indexesL, sources, sourcesL, targets, targetsL);

            i++;
            k++;
        }

        while (j < n2) {
            copyArr(k, j, indexes, indexesR, sources, sourcesR, targets, targetsR);
            j++;
            k++;
        }
    }

    private void copyArr(int k, int ij, int[] indexes, int[] indexesLR, String[] sources, String[] sourcesLR, String[] targets, String[] targetsLR) {
        indexes[k] = indexesLR[ij];
        sources[k] = sourcesLR[ij];
        targets[k] = targetsLR[ij];
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (S == null) {
            return null;
        }
        int sLen = S.length();
        if (sLen == 0) {
            return S;
        }
        int indexesLen = indexes.length;
        if (indexesLen == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();

        this.mergeSort(indexes,sources,targets,0,indexesLen-1);

        int end = indexes[0];
        sb.append(S, 0, end);

        for (int i = 0; i < indexesLen; i++) {
            int idx = indexes[i];
            String source = sources[i];
            int sourceLen = source.length();
            if (source.equals(S.substring(idx, idx + sourceLen))) {
                sb.append(targets[i]);
                end = i + 1 < indexesLen ? indexes[i + 1] : sLen ;
                if (idx + sourceLen < sLen) {
                    sb.append(S, idx + sourceLen, end);
                }
            } else {
                end = i + 1 < indexesLen ? indexes[i + 1] : sLen;
                sb.append(S, idx, end);
            }

        }

        return sb.toString();
    }
}
