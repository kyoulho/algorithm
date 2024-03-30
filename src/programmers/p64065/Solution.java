package programmers.p64065;

import java.util.*;

public class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> tuples = parseStringToList(s);
        tuples.sort(Comparator.comparingInt(List::size));

        List<Integer> answer = new ArrayList<>();

        for (List<Integer> tuple : tuples) {
            int num = getNumber(tuple, set);
            answer.add(num);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getNumber(List<Integer> tuple, Set<Integer> set) {
        for (Integer integer : tuple) {
            if (!set.contains(integer)) {
                set.add(integer);
                return integer;
            }
        }
        return -1;
    }

    private List<List<Integer>> parseStringToList(String input) {
        List<List<Integer>> resultList = new ArrayList<>();

        String[] arrays = input.replaceAll("\\{\\{|}}", "").split("},\\{");

        for (String array : arrays) {
            List<Integer> list = new ArrayList<>();
            String[] elements = array.split(",");
            for (String element : elements) {
                list.add(Integer.parseInt(element));
            }
            resultList.add(list);
        }

        return resultList;
    }
}
