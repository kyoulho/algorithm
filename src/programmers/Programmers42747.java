package programmers;

import java.util.Arrays;

public class Programmers42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int ll = citations.length;
        int h = 0;

        for(int i = 0; i < ll; i++){
            h = Math.max(h, Math.min(citations[i], ll - i));
        }

        return h;
    }
}