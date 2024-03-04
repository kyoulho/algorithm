import java.util.LinkedList;

class Solution {
        public int solution(String begin, String target, String[] words) {
        int answer = 0;
        // 첫번째 스텝에서는 begin과 한글자가 다른 문자열들이
        // 두번째 스텝에서는 begin과 두글자가 다른 문자열들만 담기는게 가장 빠르다.
        // 때문에 한번 선택된 문자열들이 재선택 되는 경우가 없어야 한다.
        boolean[] vst = new boolean[words.length];

        LinkedList<String> q = new LinkedList<>();
        q.add(begin);

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                String poll = q.poll();

                if (poll.equals(target)) {
                    return answer;
                }

                for (int j = 0; j < words.length; j++) {
                    if (!vst[j] && isOneCharDiff(words[j], poll)) {
                        q.add(words[j]);
                        vst[j] = true;
                    }
                }
            }

            answer++;
        }

        return 0;
    }

    private boolean isOneCharDiff(String word, String poll) {
        int diffCnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != poll.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }
}