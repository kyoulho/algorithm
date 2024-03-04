import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        // 아래에서 하나씩 올라간다.
        for (int i = triangle.length - 1; i > 0; i--) {
            int[] current = triangle[i];
            int[] upstairs = triangle[i - 1];
            for (int j = 0; j < current.length - 1; j++) {
                // 현재 위치와 오른쪽 위치중 큰 숫자를 위에 인덱스에 더한다.
                // ex) 4와 5 중 5를 2와 더한다.
                int max = Math.max(current[j], current[j + 1]);
                upstairs[j] += max;
            }
        }
        return triangle[0][0];
    }

}