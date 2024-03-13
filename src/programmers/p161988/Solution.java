package programmers.p161988;

import java.util.Arrays;

public class Solution {

    public long solution(int[] sequence) {
        int[] case1 = getCase(sequence, -1);
        int[] case2 = getCase(sequence, 1);

        long max1 = getMaxSum(case1);
        long max2 = getMaxSum(case2);
        return Math.max(max1, max2);
    }

    private int[] getCase(int[] sequence, int startNumber) {
        int[] newArr = Arrays.copyOf(sequence, sequence.length);

        int pulseNum = startNumber;

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = newArr[i] * pulseNum;
            pulseNum *= -1;
        }

        return newArr;
    }

    private long getMaxSum(int[] arr) {
        long maxEndingHere = arr[0];
        long maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{6, -7, 16, 3, -4}));
    }
}
