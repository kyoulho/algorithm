package programmers.p12949;

public class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rows1 = arr1.length;
        int cols1 = arr1[0].length;
        int cols2 = arr2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}


