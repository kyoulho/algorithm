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
                // City found in cache
                deque.remove(city);
                deque.addFirst(city);
                return 1; // Return 1 indicating cache hit
            } else {
                // City not found in cache
                if (deque.size() >= size) {
                    // Cache is full, remove the least recently used city
                    String removedCity = deque.removeLast();
                    cacheSet.remove(removedCity);
                }
                // Add the new city to the cache
                deque.addFirst(city);
                cacheSet.add(city);
                return 5; // Return 5 indicating cache miss
            }
        }
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int solution = T.solution(2,
                new String[]{
                        "Jeju", "Pangyo", "NewYork", "newyork"
                }
        );

        System.out.println(solution);
    }

}