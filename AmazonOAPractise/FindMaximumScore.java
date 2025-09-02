import java.util.HashSet;
import java.util.Set;

/**
 * Solves the maximum score of a string problem.
 */
public class AmazonDataScore {

    /**
     * Calculates the score contribution from a block of length L.
     * This represents the number of valid substrings of length >= 2.
     */
    private long getBlockScore(long L) {
        if (L <= 1) {
            return 0;
        }
        // This is the formula for the sum of integers from 1 to L-1, or nC2.
        return L * (L - 1) / 2;
    }

    /**
     * Finds the maximum achievable score by changing at most one character.
     *
     * @param data The input string.
     * @return The maximum possible score.
     */
    public int findMaxScore(String data) {
        int n = data.length();
        if (n <= 1) {
            return n;
        }

        // 1. Pre-computation Step
        // L[i]: length of the "adjacent" block ending at index i
        // R[i]: length of the "adjacent" block starting at index i
        int[] l = new int[n];
        int[] r = new int[n];

        l[0] = 1;
        for (int i = 1; i < n; i++) {
            if (Math.abs(data.charAt(i) - data.charAt(i - 1)) <= 1) {
                l[i] = l[i - 1] + 1;
            } else {
                l[i] = 1;
            }
        }

        r[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (Math.abs(data.charAt(i) - data.charAt(i + 1)) <= 1) {
                r[i] = r[i + 1] + 1;
            } else {
                r[i] = 1;
            }
        }

        // 2. Calculate Initial Score (no changes)
        long initialScore = n; // Each character is worth 1 point
        Set<Integer> visitedBlockStarts = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int startIdx = i - l[i] + 1;
            if (visitedBlockStarts.add(startIdx)) {
                long len = r[startIdx];
                initialScore += getBlockScore(len);
            }
        }

        long maxScore = initialScore;

        // 3. Iterate through each position to find the best possible change
        for (int i = 0; i < n; i++) {
            // Identify the current block and its left/right neighbors
            int startCurr = i - l[i] + 1;
            int endCurr = i + r[i] - 1;
            long lenCurr = endCurr - startCurr + 1;
            long lenLeft = (startCurr > 0) ? l[startCurr - 1] : 0;
            long lenRight = (endCurr < n - 1) ? r[endCurr + 1] : 0;
            
            // Original score from the local area (current block and its direct neighbors)
            long scoreLocalOriginal = getBlockScore(lenLeft) + getBlockScore(lenCurr) + getBlockScore(lenRight);
            
            // A change at `i` splits the current block into two pieces
            long lenPieceLeft = i - startCurr;
            long lenPieceRight = endCurr - i;

            // --- Option A: Extend left ---
            long newLenA = lenLeft + 1 + lenPieceLeft;
            long scoreLocalNewA = getBlockScore(newLenA) + getBlockScore(lenPieceRight) + getBlockScore(lenRight);
            maxScore = Math.max(maxScore, initialScore - scoreLocalOriginal + scoreLocalNewA);

            // --- Option B: Extend right ---
            long newLenB = lenPieceRight + 1 + lenRight;
            long scoreLocalNewB = getBlockScore(lenLeft) + getBlockScore(lenPieceLeft) + getBlockScore(newLenB);
            maxScore = Math.max(maxScore, initialScore - scoreLocalOriginal + scoreLocalNewB);

            // --- Option C: Merge left and right blocks (if `i` is a 1-char gap) ---
            if (lenCurr == 1 && i > 0 && i < n - 1) {
                if (Math.abs(data.charAt(i - 1) - data.charAt(i + 1)) <= 2) {
                    long newLenC = lenLeft + 1 + lenRight;
                    long scoreLocalNewC = getBlockScore(newLenC);
                    maxScore = Math.max(maxScore, initialScore - scoreLocalOriginal + scoreLocalNewC);
                }
            }
        }
        
        return (int) maxScore;
    }
}
