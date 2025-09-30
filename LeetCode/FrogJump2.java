class Solution {
    // we need to minimize the maximum jump 
    public int maxJump(int[] stones) {
        int n = stones.length;

        int cost = stones[1] - stones[0];

        // the frog need to step on all stones but only once
        // the minimum longest jump would be stones[i] to stones[i+2](skipping one stone)
        // any jump longer than that cannot be minimized
        // Assume the frog jumps on even numbered stones from start to end and 
        // odd number of stones from end to start thereby covering all the stones once
        for(int i=2;i<n;i++){
            cost = Math.max(cost, stones[i]-stones[i-2]);
        }

        return cost;
    }
}
