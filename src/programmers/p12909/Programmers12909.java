package programmers.p12909;

import java.util.Stack;

public class Programmers12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
