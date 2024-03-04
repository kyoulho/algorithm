import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        // routes 배열을 나가는 지점(end)을 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        System.out.println(Arrays.deepToString(routes));
        int answer = 0;
        int cameraPosition = Integer.MIN_VALUE;

        // 모든 차량이 한 번은 만나도록 카메라 설치
        for (int[] route : routes) {
            // 현재 차량의 시작 지점이 카메라의 위치보다 뒤에 있으면 새로운 카메라 설치
            if (cameraPosition < route[0]) {
                cameraPosition = route[1];
                answer++;
            }
        }

        return answer;
    }
}