package trenbe.p1;

public class Solution {
    public String solution(String s) {
        int[] counts = new int[26]; // 알파벳 카운트를 저장할 배열
        int maxCount = 0; // 가장 많이 출현한 알파벳의 출현 빈도

        // 문자열을 순회하며 알파벳의 빈도를 계산
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) { // 알파벳인 경우에만 처리
                int index = c - 'a'; // 알파벳의 인덱스 계산
                counts[index]++; // 해당 알파벳의 빈도 증가
                maxCount = Math.max(maxCount, counts[index]); // 최대 빈도 업데이트
            }
        }

        // 최대 빈도를 가진 알파벳들을 StringBuilder에 추가
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (counts[i] == maxCount) {
                result.append((char) ('a' + i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("BbA")); // 출력: "l"
    }
}
