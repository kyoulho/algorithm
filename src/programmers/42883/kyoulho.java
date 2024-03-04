import java.util.List;
import java.util.Stack;

class Solution {
    // 바로 앞에 인덱스가 현재 인덱스 보다 작으면 삭제
    // 스택에 하나씩 넣으면서 앞에 있는게 현재보다 작으면 제거
    public String solution(String number, int k) {
        int remain = number.length() - k;  // 남겨야 하는 숫자의 개수
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack.subList(0, remain)) {
            sb.append(c);
        }
        return sb.toString();
    }
}