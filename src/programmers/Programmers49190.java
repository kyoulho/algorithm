package programmers;

import java.util.*;

public class Programmers49190 {

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }

        public boolean equals(Pair o) {
            return this.x == o.x && this.y == o.y;
        }
    }

    public int[] move(int i) {
        int[] r = new int[2];
        switch (i) {
            case 0 -> r[1] = 1;
            case 1 -> {
                r[0] = 1;
                r[1] = 1;
            }
            case 2 -> r[0] = 1;
            case 3 -> {
                r[0] = 1;
                r[1] = -1;
            }
            case 4 -> r[1] = -1;
            case 5 -> {
                r[0] = -1;
                r[1] = -1;
            }
            case 6 -> r[0] = -1;
            case 7 -> {
                r[0] = -1;
                r[1] = 1;
            }
        }
        return r;
    }

    public int opposite(int i) {
        return (i + 4) % 8;
    }

    public int solution(int[] arrows) {
        int answer = 0;
        Map<Pair, boolean[]> map = new HashMap<>();
        boolean[] vis = new boolean[8];
        int[] cur = {0, 0};

        map.put(new Pair(0, 0), vis);

        for (int i : arrows) {
            Pair now = new Pair(cur[0], cur[1]);
            boolean[] nowVisit = map.get(now);
            Pair temp;
            if (i == 1) {
                temp = new Pair(cur[0], cur[1] + 1);
                boolean[] check = map.get(temp);
                if (check != null && check[3] && !nowVisit[1]) {
                    answer++;
                }
            }
            if (i == 3) {
                temp = new Pair(cur[0] + 1, cur[1]);
                boolean[] check = map.get(temp);
                if (check != null && check[5] && !nowVisit[3]) {
                    answer++;
                }
            }
            if (i == 5) {
                temp = new Pair(cur[0] - 1, cur[1]);
                boolean[] check = map.get(temp);
                if (check != null && check[3] && !nowVisit[5]) {
                    answer++;
                }
            }

            if (i == 7) {
                temp = new Pair(cur[0], cur[1] + 1);
                boolean[] check = map.get(temp);
                if (check != null && check[5] && !nowVisit[7]) {
                    answer++;
                }
            }
            nowVisit[i] = true;

            int[] dis = move(i);
            cur[0] = cur[0] + dis[0];
            cur[1] = cur[1] + dis[1];
            Pair next = new Pair(cur[0], cur[1]);
            boolean[] visited = map.get(next);
            if (visited == null) {
                boolean[] vis2 = new boolean[8];
                vis2[opposite(i)] = true;
                map.put(next, vis2);
            } else {

                if (!visited[opposite(i)]) {
                    visited[opposite(i)] = true;
                    answer++;
                }
            }
        }
        return answer;
    }
}
