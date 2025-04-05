import java.util.*;

class Solution {
    // Encode a list of strings into a single string
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String x : strs) {
            encoded.append(x.length()).append("#").append(x);
        }
        return encoded.toString();
    }

    // Decode a single string back into a list of strings
    public List<String> decode(String str) {
}


public class Main{
    public static void main(String[] args){
        Solution sol = new Solution();
        List <String> input = Arrays.asList("neet", "code", "love", "you");
        String encodedString = sol.encode(input);
        System.out.println("Results: " + encodedString);
    }
}