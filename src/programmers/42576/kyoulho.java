import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String people : participant) {
            map.put(people, map.getOrDefault(people, 0) + 1);
        }
        for (String people : completion) {
            int cnt = map.get(people) - 1;
            if (cnt == 0) map.remove(people);
            else map.put(people, cnt);
        }
        for (String people : map.keySet()) {
            answer = people;
        }

        return answer;
    }
}