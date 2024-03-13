package trenbe.p2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int[] grade) {
        int[] answer = new int[grade.length];

        PriorityQueue<Student> students = new PriorityQueue<>();
        for (int i = 0; i < grade.length; i++) {
            students.add(new Student(i, grade[i]));
        }

        int previousScore = -1;
        int previousIdx = -1;
        int rank = 1;

        while (!students.isEmpty()) {
            Student student = students.poll();
            // 이전 학생과 같은 등수라면
            if (previousScore == student.score) {
                answer[student.idx] = answer[previousIdx];
            } else {
                answer[student.idx] = rank;
            }
            rank++;
            previousIdx = student.idx;
            previousScore = student.score;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{3, 2, 1, 2})));
    }

    static class Student implements Comparable<Student> {
        int idx;
        int score;

        public Student(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return o.score - this.score;
        }
    }

}
