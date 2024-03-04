class Solution {
     public int[] solution(int brown, int yellow) {
        // brown = 2x + 2y - 4
        // brown + yellow = x * y
        // x >= y
        // x, y >= 3
        int y = 3;
        while (true) {
            int x = (brown / 2) + 2 - y;
            if (x * y == brown + yellow) {
                return new int[]{x, y};
            }
            y++;
        }
    }
}