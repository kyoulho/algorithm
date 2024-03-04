import java.util.*;

class Solution {
   public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));

        Stack<String> route = new Stack<>();
        route.add("ICN");

        DFS("ICN", tickets, new boolean[tickets.length], route, answer);

        return answer.toArray(String[]::new);
    }

    private void DFS(String departure, String[][] tickets, boolean[] used, Stack<String> route, List<String> answer) {
        if (!answer.isEmpty()) {
            // 이미 정답을 찾았으면 종료
            return;
        }

        if (route.size() == tickets.length + 1) {
            // 결과를 찾았을 때 처리
            answer.addAll(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            // 출발지가 일치하는 티켓, 사용하지 않았다면
            if (ticket[0].equals(departure) && !used[i]) {
                // 도착지에 넣고
                route.add(ticket[1]);
                // 사용여부 체크
                used[i] = true;
                // 출발
                DFS(ticket[1], tickets, used, route, answer);
                // 도착지에서 빼고
                route.pop();
                // 사용여부 해제
                used[i] = false;
            }
        }
    }
}