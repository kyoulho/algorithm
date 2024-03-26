package programmers.p76502;

import java.util.*;

public class Solution {
    public int solution(String s) {
        int n = s.length();
        // 길이가 홀수
        if (n % 2 != 0) return 0;

        int answer = 0;

        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.add(c);
        }
        // 길이 만큼 반복
        for (int i = 0; i < n; i++) {
            if (isValid(q)) {
                answer++;
            }
            q.offer(q.poll());
        }
        return answer;
    }

    private static boolean isValid(Queue<Character> q) {
        Stack<Character> stack = new Stack<>();
        for (char c : q) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
