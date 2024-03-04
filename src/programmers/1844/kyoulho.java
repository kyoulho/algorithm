import java.util.LinkedList;

class Solution {

     /*
        BFS
        지나온 자리는 0으로 바꿔줘야한다.
        네가지 방향 중에 1인 곳을 넣는다.
     */
    private final int[][] DIRECTS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

  public int solution(int[][] maps) {
        int lastX = maps[0].length - 1;
        int lastY = maps.length - 1;

        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        // 지나온 곳을 0으로 만드려고 했으나 효율성 문제로 방문하게 될 곳을 0으로
        maps[0][0] = 0;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int[] direct : DIRECTS) {
                int nx = current.x + direct[0];
                int ny = current.y + direct[1];

                if (nx >= 0 && nx <= lastX
                        && ny >= 0 && ny <= lastY
                        && maps[ny][nx] == 1) {
                    if (nx == lastX && ny == lastY) {
                        return current.level + 1;
                    }
                    queue.add(new Point(nx, ny, current.level + 1));
                    maps[ny][nx] = 0;
                }
            }
        }
        return -1;
    }
}

class Point {
    int x;
    int y;
    int level;

    public Point(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}