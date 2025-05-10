import java.util.Random;

class Solution {

    int[] prefixSum;
    Random rand;

    public Solution(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }

        rand = new Random();
    }

    public int pickIndex() {
        int totalSum = prefixSum[prefixSum.length - 1];
        int target = rand.nextInt(totalSum) + 1;  // random int in [1, totalSum]

        int lo = 0;
        int hi = prefixSum.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (prefixSum[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // Test the class locally
    public static void main(String[] args) {
        int[] weights = {1, 3, 2};
        Solution solution = new Solution(weights);

        // Call pickIndex multiple times to observe the distribution
        int[] count = new int[weights.length];
        int trials = 10000;

        for (int i = 0; i < trials; i++) {
            int picked = solution.pickIndex();
            count[picked]++;
        }

        // Print result
        System.out.println("Index selection frequencies after " + trials + " trials:");
        for (int i = 0; i < count.length; i++) {
            System.out.printf("Index %d: %d times (%.2f%%)%n", i, count[i], 100.0 * count[i] / trials);
        }
    }
}
