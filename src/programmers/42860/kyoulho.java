class Solution {
     public int solution(String name) {
        int length = name.length();
        int joystickCount = 0; // 조이스틱 조작 횟수
        int moveCount = length - 1; // 좌우 이동 횟수 (기본 최솟값)

        // 모든 문자열의 조이스틱 조작 횟수 구하기
        for (int i = 0; i < length; i++) {
            joystickCount += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }

        // 모든 위치를 순회하면 최소 이동 횟수를 구한다.
        for (int i = 0; i < length; i++) {
            int nextNonAIndex = i + 1;
            while (nextNonAIndex < length && name.charAt(nextNonAIndex) == 'A') {
                nextNonAIndex++;
            }

            int leftMoveCount = (i * 2) + length - nextNonAIndex;
            int rightMoveCount = (length - nextNonAIndex) * 2 + i;

            moveCount = Math.min(moveCount, leftMoveCount);
            moveCount = Math.min(moveCount, rightMoveCount);
        }

        return joystickCount + moveCount;
    }

}