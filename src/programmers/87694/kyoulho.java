import java.util.LinkedList;

class Solution {

    private static final int[][] DIRECTS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 필요한 크기 만큼 지도를 만든다.
        int mapSize = 0;
        for (int[] rect : rectangle) {
            mapSize = Math.max(mapSize, rect[2] * 2);
            mapSize = Math.max(mapSize, rect[3] * 2);
        }
        boolean[][] map = new boolean[mapSize + 2][mapSize + 2];

        // 사각형 그리기
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            // 모든 사각형의 외각을 체크한다.
            for (int x = x1; x <= x2; x++) {
                map[y1][x] = true;
                map[y2][x] = true;
            }
            for (int y = y1; y <= y2; y++) {
                map[y][x1] = true;
                map[y][x2] = true;
            }

        }

        // 사각형 내부를 false로 채우기
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[y][x] = false;
                }
            }
        }

        int answer = 0;
        LinkedList<Point> q = new LinkedList<>();
        q.add(new Point(characterX * 2, characterY * 2));

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point current = q.poll();

                for (int[] direct : DIRECTS) {
                    int nx = current.x + direct[0];
                    int ny = current.y + direct[1];
                    if (nx == itemX * 2 && ny == itemY * 2) {
                        return ++answer / 2;
                    }
                    // 지난갈 수 있다면
                    if (map[ny][nx]) {
                        // 지나간 곳은 false
                        map[ny][nx] = false;
                        q.add(new Point(nx, ny));
                    }

                }
            }

            answer++;
        }

        return 0;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}