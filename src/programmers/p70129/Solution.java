package programmers.p70129;

public class Solution {

    public int[] solution(String s) {
        int steps = 0;
        int zeros = 0;
        while (!s.equals("1")) {
            int zeroCnt = s.length() - s.replace("0", "").length();
            int countOne = s.length() - zeroCnt;

            String newStr = "1".repeat(countOne);
            zeros += zeroCnt;
            steps++;
            s = Integer.toBinaryString(newStr.length());
        }

        return new int[]{steps, zeros};
    }
}
