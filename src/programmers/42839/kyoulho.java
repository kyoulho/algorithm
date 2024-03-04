import java.util.HashSet;

class Solution {
   public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        char[] charArray = numbers.toCharArray();
        boolean[] visited = new boolean[numbers.length()];
        DFS(charArray, visited, 0, numbers.length(), "", set);
        return (int) set.stream().filter(this::isPrime).count();
    }

    private void DFS(char[] charArray, boolean[] visited, int idx, int targetLength, String result, HashSet<Integer> set) {
        if (idx == targetLength) {
            if (!result.isEmpty()) set.add(Integer.parseInt(result));
        } else {
            // 배열 안에서 선택
            for (int i = 0; i < charArray.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(charArray, visited, idx + 1, targetLength, result + charArray[i], set);
                    visited[i] = false;
                }
            }
            // 아무것도 선택하지 않음
            DFS(charArray, visited, idx + 1, targetLength, result, set);
        }
    }


    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 5; i <= sqrt; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}