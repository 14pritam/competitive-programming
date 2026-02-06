package Practice.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RansomeNote {

    public static void main(String[] args){

       // Longest Repeating Substring without repeating characters
        RansomeNote ransomeNote = new RansomeNote();

        ransomeNote.getLongestSubString("abbcader");
        List<String> word = List.of("cats", "dog", "sand", "and", "cat");
        ransomeNote.wordBreak("catsanddog", word);
    }


    public void wordBreak(String word, List<String> wordDict){

                HashSet<String> set = new HashSet<>(wordDict);
                int n = word.length();
                int maxLength = 0;

                for (String w : wordDict) {
                    maxLength = Math.max(maxLength, w.length());
                }

                boolean[] dp = new boolean[n + 1];
                dp[0] = true; // base case: empty string

                for (int i = 1; i <= n; i++) {
                    for (int j = Math.max(0, i - maxLength); j < i; j++) {
                        if (dp[j] && set.contains(word.substring(j, i))) {
                            dp[i] = true;
                            break;
                        }
                    }
                }

        System.out.println(dp[n]);
            
        }

        public void getLongestSubString(String word) {
            HashMap<Character, Integer> map = new HashMap<>();
            int maxLength = 0, left = 0;
            for (int right = 0; right < word.length(); right++) {
                char ch = word.charAt(right);
                if (map.containsKey(ch) && map.get(ch) >= left) {
                    left = map.get(ch) + 1;
                }
                map.put(ch, right);
                maxLength = Math.max(maxLength, right - left + 1);
            }
            System.out.println("Max: " + maxLength);
        }

    // RansomeNote
    public void canConstruct(String ranSomeNote, String magazine){
        int[] charCount = new int[26];
        for (char ch : ranSomeNote.toCharArray()){
            charCount[ch-'a']++;
        }
        for (char ch : magazine.toCharArray()){
            if (charCount[ch -'a'] == 0){
                System.out.println("FALSE");
                break;
            }
            charCount[ch -'a']--;
        }
        System.out.println("TRIEEue");
    }
}
