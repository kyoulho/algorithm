import java.util.Arrays;
import java.util.Comparator;

class Solution {
    // 비용으로 오름차순 정렬 후
    // 연결 가능한 것들을 하나씩 연결한다.
    // 최소 비용 반환
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));
        UnionFind unionFind = new UnionFind(n);
        for (int[] cost : costs) {
            int sum1 = cost[0];
            int sum2 = cost[1];
            // 연결 되어 있지 않으면 연결하고 비용 합산
            if (unionFind.find(sum1) != unionFind.find(sum2)) {
                unionFind.union(sum1,sum2);
                answer += cost[2];
            }
        }

        return answer;
    }

}

class UnionFind {
    private final int[] parent;

    UnionFind(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootY != rootX) {
            parent[rootX] = rootY;
        }
    }
}