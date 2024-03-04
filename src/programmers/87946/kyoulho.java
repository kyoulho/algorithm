import java.util.Arrays;

class Solution {
    int answer = -1;

    public int solution(int k, int[][] dungeons) {
        Dungeon[] array = Arrays.stream(dungeons).map(it -> new Dungeon(it[0], it[1])).toArray(Dungeon[]::new);
        boolean[] visited = new boolean[dungeons.length];
        DFS(array, visited, k, 0, dungeons.length);
        return answer;
    }

    private void DFS(Dungeon[] dungeons, boolean[] visited, int k, int idx, int goalIdx) {
        // 던전 입장하면 answer의 값을 변경
        answer = Math.max(answer, idx);
        if (idx < goalIdx) {
            for (int i = 0; i < dungeons.length; i++) {
                Dungeon dungeon = dungeons[i];
                // 입장한적 없고 입장 가능하다면 입장
                if (!visited[i] && dungeon.canEnter(k)) {
                    visited[i] = true;
                    DFS(dungeons, visited, k - dungeon.usageCost, idx + 1, goalIdx);
                    visited[i] = false;
                }
            }
        }
    }
}

class Dungeon {
    int requiredCost;
    int usageCost;

    public Dungeon(int requiredCost, int usageCost) {
        this.requiredCost = requiredCost;
        this.usageCost = usageCost;
    }

    public boolean canEnter(int k) {
        return k >= requiredCost;
    }
}