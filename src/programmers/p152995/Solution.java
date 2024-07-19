package programmers.p152995;

import java.util.Arrays;

class Solution {
    public int solution(int[][] scores) {
        int[] wanHo = scores[0];
        // 0번 내림차순. 1번 오름차순
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int wanHoRank = 1;
        int prevB = 0;
        int wanHoSum = wanHo[0] + wanHo[1];

        for (int[] score : scores) {
            if (score[1] < prevB) {
                // 그게 나인가?
                if (Arrays.equals(score, wanHo))
                    return -1;
            } else {
                // 인센대상
                prevB = score[1];
                if (score[0] + score[1] > wanHoSum) {
                    wanHoRank++;
                }
            }
        }
        return wanHoRank;
    }
}