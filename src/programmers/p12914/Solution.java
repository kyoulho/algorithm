package programmers.p12914;

public class Solution {
        public long solution(int n) {
            var arr = new long[n+1];
            arr[0] = 1;
            arr[1] = 1;

            for(int i = 2; i <= n; i++){
                arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
            }
            return arr[n] ;
        }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(1));
        System.out.println(T.solution(2));
        System.out.println(T.solution(3));
        System.out.println(T.solution(4));
        System.out.println(T.solution(5));
        System.out.println(T.solution(123456789));
    }
}