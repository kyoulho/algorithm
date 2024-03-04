import java.util.Arrays;
class Solution {
    /*
        최소 거리가 n 과 일치 하는 범위 중에서 가장 큰 수를 반환해야 한다.
        최소 거리보다 더 짧은 거리가 있다면 돌을 제거해야한다.
        최소 거리           1, [2, 3, 4], 5, 6, 7, ...
        제거해야 하는 돌 개수  0, [2, 2, 2], 3, ...
     */
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int answer = 0;
        int min = 0;
        int max = distance;

        while (min <= max) {
            int mid = (max + min) / 2;
            int removeCnt = getRemoveCnt(distance, rocks, mid);
            /*
                제거할 바위의 개수가 현재 mid 값을 적거나 만족하는 경우 최소 거리를 늘린다.
                제거할 바위의 개수가 현재 mid 값을 초과하는 경우 최소 거리를 줄인다.
             */
            if (removeCnt > n) {
                max = mid - 1;
            }else {
                // 가능한 값들 중에
                answer = Math.max(answer, mid);
                min = mid + 1;
            }
        }

        return answer;
    }

    // mid가 최소 거리라면 mid보다 작은 거리를 가진 돌은 제거해야한다.
    private int getRemoveCnt(int distance, int[] rocks, int mid) {
        int removeCnt = 0;
        int previousRock = 0;
        for (int rock : rocks) {
            if (rock - previousRock < mid) {
                removeCnt++;
            }else {
                previousRock = rock;
            }
        }
        if (distance - previousRock < mid) {
            removeCnt++;
        }
        return removeCnt;
    }
}