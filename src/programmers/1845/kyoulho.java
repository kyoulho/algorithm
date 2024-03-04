import java.util.*;

public class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        return Math.min(n, map.keySet().size());
    }
}
