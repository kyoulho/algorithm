import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
       // int 배열을 String 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 둘을 더해서 더 큰 숫자가 앞으로 오도록 정렬
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 0으로만 구성된 경우에는 "0"으로 반환
        if (strNumbers[0].equals("0")) {
            return "0";
        }

        // 정렬된 문자열을 이어 붙여 반환
        StringBuilder result = new StringBuilder();
        for (String strNum : strNumbers) {
            result.append(strNum);
        }

        return result.toString();
    }
}