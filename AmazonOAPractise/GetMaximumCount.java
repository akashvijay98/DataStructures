import java.util.*;

public class Solution {
    public int getMaximumCount(int[] arr, int k) {
        int baseCount = 0;
        Set<Integer> diffs = new HashSet<>();

        for (int val : arr) {
            if (val == k) {
                baseCount++;
            } else {
                diffs.add(k - val);
            }
        }

        int maxGain = 0;
        for (int diff : diffs) {
            int currentGain = 0;
            for (int val : arr) {
                int gain = 0;
                if (val == k) {
                    gain = -1;
                } else if (k - val == diff) {
                    gain = 1;
                }
                
                currentGain += gain;
                
                if (currentGain > maxGain) {
                    maxGain = currentGain;
                }
                if (currentGain < 0) {
                    currentGain = 0;
                }
            }
        }
        
        return baseCount + maxGain;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getMaximumCount(new int[]{2,3,2,4,3,2}, 2));
        System.out.println(s.getMaximumCount(new int[]{6,4,4,6,4,4}, 6));
    }
}
