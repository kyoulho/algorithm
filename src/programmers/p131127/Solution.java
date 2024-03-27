package programmers.p131127;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> discountMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            discountMap.merge(discount[i], 1, Integer::sum);
        }

        int lp = 0;
        int rp = 9;

        while (rp < discount.length) {
            if (wantMap.equals(discountMap)) {
                answer++;
            }
            if (rp == discount.length - 1) break;
            decrementCount(discountMap,discount[lp++]);
            incrementCount(discountMap, discount[++rp]);
        }
        return answer;
    }

    private void incrementCount(Map<String, Integer> discountMap, String key) {
        discountMap.merge(key, 1, Integer::sum);
    }

    private void decrementCount(Map<String, Integer> map, String key) {
        map.computeIfPresent(key, (k, v) -> v - 1);
        map.remove(key, 0);
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int solution = T.solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}
        );
        System.out.println(solution);
    }
}
