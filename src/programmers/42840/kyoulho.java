import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        // 수포자 객체 생성, 번호와 패턴 바인딩
        List<Supoja> supojas = List.of(
                new Supoja(1, new int[]{1, 2, 3, 4, 5}),
                new Supoja(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5}),
                new Supoja(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5})
        );

        // 가장 많이 맞힌 사람의 맞힌 개수 구하기
        int maxCount = 0;
        for (Supoja supoja : supojas) {
            int count = supoja.fun(answers);
            maxCount = Math.max(maxCount, count);
        }
        // 가장 많이 맞힌 사람들 구하기
        for (Supoja supoja : supojas) {
            if (supoja.count >= maxCount) {
                answer.add(supoja.number);
            }
        }
        // 리스트를 배열로 변경
        int[] ints = new int[answer.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = answer.get(i);
        }
        return ints;
    }
}

class Supoja {
    int number;
    int[] pattern;
    int count = 0;

    public Supoja(int number, int[] pattern) {
        this.number = number;
        this.pattern = pattern;
    }

    // 정답 목록과 패턴을 순회하면서 카운팅
    public int fun(int[] answers) {
        int count = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % pattern.length]) {
                count++;
            }
        }
        this.count = count;
        return count;
    }

}