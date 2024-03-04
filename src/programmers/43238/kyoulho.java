import java.util.*;

class Solution {
   public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        // 가장 빠른 친구가 모두 처리하는 경우
        long maxTime = (long) times[0] * n;
        // 가장 빠른 친구가 최소 1번은 진행하는 경우
        long minTime = times[0];


        while (minTime <= maxTime) {
            long mid = (minTime + maxTime) / 2;
            long cnt = getCount(n, times, mid);

            // n보다 작다면 주어진 시간을 최소로 한다.
            if (cnt < n) {
                minTime = mid + 1;
            } else {
                answer = mid;
                maxTime = mid - 1;
            }
        }

        return answer;
    }

    // 주어진 시간동안 몇명을 심사할 수 있는가?
    private static long getCount(int n, int[] times, long midTime) {
        long cnt = 0;
        for (int time : times) {
            // 주어진 시간동안 각각의 심사원들이 심사하는 인원들
            cnt += midTime / time;
            if (cnt >= n) break;
        }
        return cnt;
    }
}