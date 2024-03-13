package trenbe.p3;

import java.util.Arrays;

public class Solution {
      public int solution(int[] dots, int[] lines) {
        int answer = -1;
        int lp = 1;
        int rp = lines.length;

        Arrays.sort(lines);

        while (lp <= rp) {
            int mp = (lp + rp) / 2;
            if (isPossible(mp, dots, lines)) {
                answer = mp;
                rp = mp - 1;
            } else {
                lp = mp + 1;
            }
        }

        return answer;
    }


    private boolean isPossible(int mp, int[] dots, int[] lines) {
        int i = 0;
        int k = lines.length - 1;
        int n = dots.length;

        while (mp > 0) {
            if (i < n - 1) {
                // 아 거리....
                int distance = dots[i + 1] - dots[i];
                if (distance <= lines[k]) {
                    i++;
                }
            }
            i++;
            k--;
            mp--;
        }

        return i == n;
    }
}