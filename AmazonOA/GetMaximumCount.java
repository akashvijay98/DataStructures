import java.util.*;

public class Solution {
    public int getMaximumCount(int[] arr, int k) {
        int baseCount = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1 + 2: count base k's and group indices by diff
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                baseCount++;
            } else {
                int diff = k - arr[i];
                map.computeIfAbsent(diff, d -> new ArrayList<>()).add(i);
            }
        }

        int bestGain = 0;

        // Step 3: find max contiguous streak in each diff group
        for (List<Integer> indices : map.values()) {
            int current = 1, localBest = 1;
            for (int i = 1; i < indices.size(); i++) {
                if (indices.get(i) == indices.get(i - 1) + 1) {
                    current++;
                } else {
                    current = 1;
                }
                localBest = Math.max(localBest, current);
            }
            bestGain = Math.max(bestGain, localBest);
        }

        return baseCount + bestGain;
    }

    // test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getMaximumCount(new int[]{2,3,2,4,3,2}, 2)); // 4
        System.out.println(s.getMaximumCount(new int[]{6,4,4,6,4,4}, 6)); // 5
    }
}
