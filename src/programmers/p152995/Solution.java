package programmers.p152995;

import java.util.*;

public class Solution {
    public int solution(int[][] scores) {
            int n = scores.length;

            // 인센티브를 받을 수 있는 사원 필터링
            List<int[]> validScores = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                boolean valid = true;
                for (int j = 0; j < n; j++) {
                    if (i != j && scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    validScores.add(scores[i]);
                }
            }

            // 유효한 사원들의 점수 합계 계산
            List<int[]> totalScores = new ArrayList<>();
            for (int i = 0; i < validScores.size(); i++) {
                int[] score = validScores.get(i);
                totalScores.add(new int[]{score[0] + score[1], i});
            }

            // 점수 합계에 따라 내림차순 정렬
            totalScores.sort((a, b) -> b[0] - a[0]);

            // 석차 계산
            Map<Integer, Integer> ranks = new HashMap<>();
            int rank = 1;
            int currentRank = 1;
            Integer prevScore = null;
            for (int[] score : totalScores) {
                if (prevScore == null || score[0] != prevScore) {
                    rank = currentRank;
                }
                ranks.put(score[1], rank);
                prevScore = score[0];
                currentRank++;
            }

            // 완호의 석차 반환
            int[] wanhoScore = scores[0];
            for (int i = 0; i < validScores.size(); i++) {
                if (Arrays.equals(wanhoScore, validScores.get(i))) {
                    return ranks.get(i);
                }
            }

            return -1; // 완호가 인센티브를 받지 못하는 경우
        }
}
