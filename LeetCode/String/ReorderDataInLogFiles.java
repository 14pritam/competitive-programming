package LeetCode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReorderDataInLogFiles {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        ReorderDataInLogFiles reorder = new ReorderDataInLogFiles();
        reorder.reorderLogFiles(logs);
        for (String answer : logs){
            System.out.println(answer);
        }


        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        String result = reorder.mostCommonWord(paragraph,banned);
        System.out.println( "Output : " + result);

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("Nums Islands : " + reorder.numIslands(grid));
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        for(int i = 0 ; i < grid.length;i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] != '0'){
                    dfs(grid,i,j);
                    count++;
                }

            }
        }
        return count;
    }

    public void dfs(char[][] grid , int i , int j){

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';

        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }

    public String mostCommonWord(String paragraph, String[] banned) {

        String[] split = paragraph.split("\\W+");

        HashMap<String, Integer> map = new HashMap<>();

        for(String word : split){
            map.put(word.toLowerCase(), 1 + map.getOrDefault(word.toLowerCase(),0));
        }

        for(String word :  banned){
            if (map.containsKey(word.toLowerCase())){
                map.remove(word.toLowerCase());
            }
        }
        int max = 1;
        String result = "";
        for(Map.Entry key : map.entrySet()){
            int value = (int) key.getValue();
            if ( value > 1  && value > max){
                result = (String) key.getKey();
                max = value;
            }

        }
        return result;
    }


    public String[] reorderLogFiles(String[] logs) {
        // Sort the given logs with specified ordering rules
        Arrays.sort(logs, this::compareLogs);
        return logs;
    }

    private int compareLogs(String log1, String log2) {
        // Split the logs into two parts: identifier and content
        String[] splitLog1 = log1.split(" ", 2);
        String[] splitLog2 = log2.split(" ", 2);

        // Check if log1 and log2 contents start with a digit
        boolean isDigitLog1 = Character.isDigit(splitLog1[1].charAt(0));
        boolean isDigitLog2 = Character.isDigit(splitLog2[1].charAt(0));

        // Both logs are letter-logs
        if (!isDigitLog1 && !isDigitLog2) {
            // Compare the contents of the logs
            int contentComparison = splitLog1[1].compareTo(splitLog2[1]);
            if (contentComparison != 0) {
                return contentComparison;
            }
            // If contents are identical, compare the identifiers
            return splitLog1[0].compareTo(splitLog2[0]);
        }

        // Both logs are digit-logs, in which case we return 0 to retain their original order
        if (isDigitLog1 && isDigitLog2) {
            return 0;
        }

        // One log is a digit-log and the other is a letter-log
        // Letter-logs should come before digit-logs, thus returning 1 if the first log is a digit-log, else -1
        return isDigitLog1 ? 1 : -1;
    }
}
