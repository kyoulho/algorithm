package programmers.p17680;

import java.util.*;

public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        Cache cache = new Cache(cacheSize);
        for (String city : cities) {
            answer += cache.findCity(city.toLowerCase(Locale.ROOT));
        }
        return answer;
    }

    static class Cache {
        int size;
        Deque<String> deque;
        Set<String> cacheSet;

        Cache(int size) {
            this.size = size;
            this.deque = new LinkedList<>();
            this.cacheSet = new HashSet<>();
        }

        int findCity(String city) {
            if (cacheSet.contains(city)) {
                deque.remove(city);
                deque.addFirst(city);
                return 1;
            } else {
                if (deque.size() >= size) {
                    String removedCity = deque.removeLast();
                    cacheSet.remove(removedCity);
                }
                deque.addFirst(city);
                cacheSet.add(city);
                return 5;
            }
        }
    }
}