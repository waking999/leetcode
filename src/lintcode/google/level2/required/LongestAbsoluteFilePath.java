package lintcode.google.level2.required;

/**
 * Longest Absolute File Path
 * Suppose we abstract our file system by a string in the following manner:
 * <p>
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
 * <p>
 * dir
 * subdir1
 * subdir2
 * file.ext
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.
 * <p>
 * The string
 * <p>
 * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * represents:
 * <p>
 * dir
 * subdir1
 * file1.ext
 * subsubdir1
 * subdir2
 * subsubdir2
 * file2.ext
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.
 * <p>
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).
 * <p>
 * Given a string representing the file system in the above format, return the length of the longest absolute path to file in the abstracted file system. If there is no file in the system, return 0.
 * <p>
 * Example
 * Give input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" return 20
 */
public class LongestAbsoluteFilePath {
    /**
     * @param input: an abstract file system
     * @return return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {

        if (input == null) {
            return 0;
        }
        int inputLen = input.length();
        if (inputLen == 0) {
            return 0;
        }

        String[] elements = input.split("\n");
        int elementsLen = elements.length;

        int[] sum = new int[elementsLen + 1];
        int maxLen = 0;
        for (String element : elements) {
            int level = element.lastIndexOf("\t") + 2;
            int len = element.length() - (level - 1);
            if (element.contains(".")) {
                maxLen = Math.max(maxLen, sum[level - 1] + len);
            } else {
                sum[level] = sum[level - 1] + len + 1;
            }

        }

        return maxLen;
    }


}
