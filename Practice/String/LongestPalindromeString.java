package Practice.String;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeString {

    public  static void main(String[] args){


        String str = "abacdfeesabase";

        String LSP = "";

        for(int i = 1 ; i < str.length() ; i++){

            int start = i;
            int end = i;

            while(str.charAt(start) == str.charAt(end)){
                start--;
                end++;

                if (start == -1 || end ==  str.length()){
                    break;
                }
            }

            String palindrome = str.substring(start+1,end);

            if (palindrome.length() >  LSP.length()){
                LSP = palindrome;
            }

            // consider even
            start = i-1;
            end = i;

            while(str.charAt(start) == str.charAt(end)){
                start--;
                end++;

                if (start == -1 || end ==  str.length()){
                    break;
                }
            }
            palindrome = str.substring(start+1,end);
            if (palindrome.length() >  LSP.length()){
                LSP = palindrome;
            }

        }

        System.out.println("LSP :: "+ LSP);

        //First unique character in a String

        String input = "fourByasfour";

        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : input.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue() <= 1 ){
                System.out.print(entry.getKey() + " ");
            }
        }
    }
}
