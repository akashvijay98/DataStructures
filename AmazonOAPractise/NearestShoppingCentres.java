/*
Statement:
Amazon has multiple delivery centers all over the world. A city is given in the form of a grid where the delivery centers are marked as 1 and all other places are marked as 0.
Distance between two cell is defined as the maximum absolute distance between x-coordinates and y-coordinates.
For example, distance between (1, 2) and (0, 4) is max(|1-0|, |2-4|) = 2.
The incovenience of the grid is defined as the maximum distance of any place marked 0 from its nearest delivery center.

Amazon is planning to open a new delivery center to reduce the incovenience of the grid. Minimize the inconvenience of the grid by converting at most one 0(any place) to 1(a delivery center) and report this minimum value.

Input

0 0 0 1
0 0 0 1

Distances to nearest delivery centeres
3 2 1 0
3 2 1 0
Initial incovenience is 3

Converting the (0, 0) to a delivery center
1 0 0 1
0 0 0 1

Now the inconvenience is 1 with distance as
0 1 1 0
1 1 1 0
Constraints

n, m <= 500

*/


import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // Defines the 8 directions for Chebyshev distance (king's moves in chess)
    private static final int[] D_ROW = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] D_COL = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int solve(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;

        // --- Step 1: Multi-Source BFS to find initial distances ---
        int[][] dist = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize distances and queue with all existing delivery centers (1s)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Run the BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + D_ROW[i];
                int nc = c + D_COL[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && dist[nr][nc] == Integer.MAX_VALUE) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        // --- Step 2: Binary Search on the answer (inconvenience) ---
        int low = 0;
        int high = n + m; // A safe upper bound for the max possible distance
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, n, m, dist)) {
                // If we can achieve inconvenience 'mid', it's a potential answer.
                // Try for an even smaller inconvenience.
                ans = mid;
                high = mid - 1;
            } else {
                // If 'mid' is not achievable, we need to allow a larger inconvenience.
                low = mid + 1;
            }
        }

        return ans;
    }

    /**
     * Checks if an inconvenience of 'd' is achievable by adding at most one new center.
     */
    private boolean check(int d, int n, int m, int[][] dist) {
        // These variables define the rectangular region where a new center could be placed
        // to cover ALL "problem cells".
        int minRowReq = Integer.MIN_VALUE, maxRowReq = Integer.MAX_VALUE;
        int minColReq = Integer.MIN_VALUE, maxColReq = Integer.MAX_VALUE;
        boolean hasProblemCells = false;

        // --- Step 3: Identify problem cells and their required coverage intersection ---
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // A "problem cell" is one that is currently farther than 'd' from any center.
                if (dist[i][j] > d) {
                    hasProblemCells = true;
                    // For this problem cell (i,j) to be covered, a new center (x,y) must satisfy:
                    // max(|i-x|, |j-y|) <= d
                    // This is equivalent to: i-d <= x <= i+d AND j-d <= y <= j+d.
                    
                    // We find the intersection of these required squares for ALL problem cells.
                    minRowReq = Math.max(minRowReq, i - d);
                    maxRowReq = Math.min(maxRowReq, i + d);
                    minColReq = Math.max(minColReq, j - d);
                    maxColReq = Math.min(maxColReq, j + d);
                }
            }
        }

        if (!hasProblemCells) {
            // If there are no problem cells, the current grid already satisfies inconvenience 'd'.
            return true;
        }

        // A valid placement exists if the intersection region is not empty.

        // any position between this range will be an overlapping interval.
        return minRowReq <= maxRowReq && minColReq <= maxColReq;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example from the problem description
        int[][] grid1 = {
            {0, 0, 0, 1},
            {0, 0, 0, 1}
        };
        // Initial inconvenience is 3. By placing a center at (0,0), new inconvenience becomes 1.
        System.out.println("Minimum inconvenience for grid 1: " + solution.solve(grid1)); // Expected: 1

        // Example with no delivery centers
        int[][] grid2 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        // Place a center in the middle (1,1). Max distance is 1.
        System.out.println("Minimum inconvenience for grid 2: " + solution.solve(grid2)); // Expected: 1
        
        // Example where adding a center doesn't help much
         int[][] grid3 = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        // Inconvenience is 4 (cell 0,4 or 0,5). Place center at (0,4). New inconvenience is 2.
        System.out.println("Minimum inconvenience for grid 3: " + solution.solve(grid3)); // Expected: 2
    }
}
