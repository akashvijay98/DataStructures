import java.util.*;

public class Solution {

    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int n = heights.length;

        // add last index because there is nothing right of it
        list.add(n - 1);

        int maxSoFar = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > heights[maxSoFar]) {
                list.add(i);
                maxSoFar = i;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - 1 - i); // reversing the order
        }

        return result;
    }

    // main method to run your code
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] heights = {4, 2, 3, 1}; // sample input
        int[] oceanViewBuildings = sol.findBuildings(heights);

        // Print the result
        System.out.println(Arrays.toString(oceanViewBuildings));
    }
}
