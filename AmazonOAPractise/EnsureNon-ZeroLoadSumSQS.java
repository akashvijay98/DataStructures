import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Calculates the minimum insertions to ensure no contiguous sub-array sums to zero.
     *
     * @param queueMessages The array of message values.
     * @return The minimum number of insertions required.
     */
    public int minInsertionsToEnsureNonZeroLoadSum(int[] queueMessages) {
        int insertions = 0;
        long currentSum = 0; // Use long to avoid potential integer overflow with large inputs.

        // This set stores all the prefix sums encountered in the current segment.
        Set<Long> seenSums = new HashSet<>();

        // A sum of 0 is the starting point before processing any elements.
        seenSums.add(0L);

        for (int message : queueMessages) {
            currentSum += message;

            // If the currentSum has been seen before, it means a sub-array
            // between the last occurrence and now sums to zero.
            if (seenSums.contains(currentSum)) {
                // We must make an "insertion" to break this zero-sum segment.
                insertions++;

                // The insertion starts a new, clean segment. We clear all previously
                // seen sums and start over from this point.
                seenSums.clear();

                // The new segment's starting sum is 0 (relative to the insertion point),
                // and the first element brings the sum to 'currentSum'.
                seenSums.add(0L);
                seenSums.add(currentSum);
            } else {
                // If the sum is new, just add it to our set of seen sums.
                seenSums.add(currentSum);
            }
        }

        return insertions;
    }
}
