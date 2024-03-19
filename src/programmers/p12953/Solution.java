package programmers.p12953;

public class Solution {
    public int solution(int[] arr) {
        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currentNumber = arr[i];
            int gcd = gcd(lcm, currentNumber);
            lcm = (lcm / gcd) * currentNumber;
        }

        return lcm;
    }

    public int gcd(int a, int b) {
        if (a > b)
            return (a % b == 0) ? b : gcd(b, a % b);
        else
            return (b % a == 0) ? a : gcd(a, b % a);
    }

}
