import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
     /*
        BFS를 이용해서 각 레밸 별로 카운트
        몇 레벨까지 있을지 알 수 없다. 그래서 list
        방문 여부를 체크해야한다.
     */
    public int solution(int n, int[][] edge) {
        // 각 레벨 별로 몇개가 있는지 담는 리스트
        ArrayList<Integer> countList = new ArrayList<>();
        // 방문 여부
        boolean[] vst = new boolean[n + 1];

        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        vst[1] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            countList.add(size);
            for (int i = 0; i < size; i++) {
                Integer current = q.poll();

                for (int[] e : edge) {
                    // 가야할 곳
                    int neighbor = -1;
                    if (e[0] == current) {
                        neighbor = e[1];
                    } else if (e[1] == current) {
                        neighbor = e[0];
                    }

                    if (neighbor != -1 && !vst[neighbor]) {
                        vst[neighbor] = true;
                        q.add(neighbor);
                    }
                }
            }
        }

        return countList.get(countList.size() - 1);
    }
}