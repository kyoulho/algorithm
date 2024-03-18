package programmers.p12981;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] solution(int n, String[] words) {
        Stack<String> usedWords = new Stack<>();

        for (int i = 0; i < words.length; i++) {
            int person = i % n + 1;
            int order = i / n + 1;
            String word = words[i];

            if (word.length() == 1 || usedWords.contains(word)) {
                return new int[]{person, order};
            } else {
                if (!usedWords.isEmpty()) {
                    String peek = usedWords.peek();
                    char lastChar = peek.charAt(peek.length() - 1);
                    char startChar = word.charAt(0);
                    if (lastChar != startChar) {
                        return new int[]{person, order};
                    }
                }
                usedWords.push(word);
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] solution = T.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        System.out.println(Arrays.toString(solution));
    }


}
