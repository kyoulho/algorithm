import java.util.*;

class Solution {
    Set<String> dictionary = new TreeSet<>();
    int answer = -1;

    private void dfs(int idx, String result, String word) {
        // 이미 답을 찾았으면 더 이상의 재귀 호출 중단
        if (answer != -1) {
            return;
        }
        // 사전에 추가
        dictionary.add(result);

        // 찾던 글자면 사전 사이즈에서 -1
        // 왜냐 빈문자열이 있어서
        if (result.equals(word)) {
            answer = dictionary.size() - 1;
        }

        // 문자열이 5글자 이하면 하나씩 붙여서 궈궈
        if (idx != 5) {
            for (int i = 0; i < 5; i++) {
                dfs(idx + 1, result + "AEIOU".charAt(i), word);
            }
        }
    }

    public int solution(String word) {
        dfs(0, "", word);
        return answer;
    }
}