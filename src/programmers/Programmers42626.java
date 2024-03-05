package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers42626 {
    /*
        우선 순위 큐에 다 넣는다.
        가장 작은 수부터 꺼낸다.
        꺼낸 수가 k 보다 작으면 하나더 꺼낸다.
        하나 더 꺼낸 수가 null 이면 -1
        쉐이크 진행하고 다시 큐에 넣는다.
     */
    public int solution(int[] scoville, int K) {
     int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        for (int food : scoville) {
            queue.offer(food);
        }

        while (!queue.isEmpty()) {
            Integer n1 = queue.poll();
            if (n1 < K) {
                Integer n2 = queue.poll();
                if(n2 == null) return -1;
                answer++;
                queue.offer(shake(n1, n2));
            }
        }
        return answer;
    }

    private int shake(Integer n1, Integer n2) {
        return n1 + (n2 * 2);
    }
}