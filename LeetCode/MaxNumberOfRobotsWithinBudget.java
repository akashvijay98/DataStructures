class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<Integer> dq = new ArrayDeque<>();
        long  currentSum = 0;
        int n = chargeTimes.length;
        int left=0;

        int maxRobots = 0;

        for(int i=0;i<n;i++){

            while(!dq.isEmpty() && chargeTimes[dq.peekLast()]<=chargeTimes[i]){
                dq.pollLast();
            }

            dq.addLast(i);

            currentSum+=runningCosts[i];


            while(!dq.isEmpty() && chargeTimes[dq.peek()] + (long)(i-left+1) * currentSum > budget){
                currentSum-= runningCosts[left];
              
                if(dq.peekFirst() == left){
                    dq.pollFirst();
                }

                left++;

            }

            maxRobots = Math.max(maxRobots, i-left+1);


        }

        return maxRobots;
    }
}
