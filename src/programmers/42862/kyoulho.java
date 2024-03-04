import java.util.HashSet;
class Solution {
     public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> lostSet = new HashSet<>();
        for (int i : lost) {
            lostSet.add(i);
        }
        HashSet<Integer> reserveSet = new HashSet<>();
        for (int i : reserve) {
            // 자기꺼 입을 수 있으면 입고
            if (lostSet.contains(i)) {
                lostSet.remove(i);
            }else {
                reserveSet.add(i);
            }
        }
        // 자기 옷 입을 수 있는 학생 수
        int answer = n - lostSet.size();

        for (Integer i : lostSet) {
            if (reserveSet.contains(i - 1)) {
                answer++;
                reserveSet.remove(i - 1);
            } else if (reserveSet.contains(i + 1)) {
                answer++;
                reserveSet.remove(i + 1);
            }
        }
        return answer;
    }
}