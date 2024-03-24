package programmers.p138476;

import java.util.*;

public class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.merge(i, 1, Integer::sum);
        }
        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Comparator.reverseOrder());

        int idx = 0;

        while (k > 0 && idx < values.size()) {
            k -= values.get(idx++);
            answer++;
        }
        return answer;
    }
}
