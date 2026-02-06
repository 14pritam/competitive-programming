package LeetCode.Contest;

import java.util.*;

public class WarmUp {

    public static void main(String[] args) {
        longestAbsoluteFilePath();
    }

    private static void longestAbsoluteFilePath() {
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); // depth -> cumulative length

        for (String line : input.split("\n")) {
            int depth = line.lastIndexOf("\t") + 1; // basically it give the last index where it 'slash t' is persent
            int len = line.length() - depth; // gives the file Name

            // I could not come up this logic if else one got stuck there
            if (line.contains(".")) // to check the final "file.ext"
            {
                maxLen = Math.max(maxLen, map.get(depth) + len);
            } else {
                map.put(depth + 1, map.get(depth) + len + 1); // +1 for '/'
            }
        }
        System.out.println(maxLen);
    }
}
