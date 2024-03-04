import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int j = 0; j < commands.length; j++) {
            int[] command = commands[j];

            // 부분 배열 추출 및 정렬
            int[] subArray = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(subArray);

            // 정렬된 부분 배열에서 원하는 인덱스 값 가져오기
            answer[j] = subArray[command[2] - 1];
        }

        return answer;
    }
}