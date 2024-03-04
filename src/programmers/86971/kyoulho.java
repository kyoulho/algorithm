class Solution {
   public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int excludeIdx = 0;

        /*
            전선을 하나씩 제외시킨다.
            나머지 전선을 연결한다.
            각 집합의 개수를 구한다.
            집합의 차이가 가장 작은 수를 구한다.
         */
        while (excludeIdx < n - 1) {
            UnionFind unionFind = new UnionFind(n+1);
            for (int i = 0; i < wires.length; i++) {
                if (i != excludeIdx) {
                    int[] wire = wires[i];
                    unionFind.union(wire[0], wire[1]);
                }
            }
            // 송전탑 번호에서 1을 뺌
            int size0 = unionFind.getSize(wires[excludeIdx][0]);
            int size1 = unionFind.getSize(wires[excludeIdx][1]);

            answer = Math.min(answer, Math.abs(size1 - size0));
            excludeIdx++;
        }
        return answer;
    }
}

class UnionFind {
    private final int[] parent;
    private final int[] size;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            // y가 속한 집합 밑으로 새롭게 편입한다.
            // y가 속한 집합에 부모를 x가 속합 집합에 부모로 한다.
            parent[rootX] = rootY;
            // y가 속합 집합의 크기를 x가 속한 집합의 크기와 더한다.
            size[rootY] += size[rootX];
        }
    }

    public int find(int x) {
        // 혼자 속한 집합이 아니라면
        if (parent[x] != x) {
            // x가 속한 집합의 부모를 찾아서
            // x의 부모로 한다. (경로 축소)
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int getSize(int x) {
        int rootX = find(x);
        return size[rootX];
    }
}