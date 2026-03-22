// 239. Sliding Window Maximum
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];


        int index= 0;

        for(int right=0;right<n;right++){

            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[right]){
                dq.pollLast();
            }

            dq.addLast(right);

            while(dq.peekFirst()<right-k+1){
                dq.pollFirst();
            }

            if(right>=k-1){
                res[index++]= nums[dq.peekFirst()];
            }

           
        }

        return res;
    }
}

// 2398. Maximum Number of Robots Within Budget
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

// 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDq= new ArrayDeque<>();
        Deque<Integer> minDq= new ArrayDeque<>();

        int n= nums.length;

        int left =0;

        int maxLen=0;

        for(int right = 0; right<n;right++){
            while(!maxDq.isEmpty() && nums[maxDq.peekLast()]<=nums[right]){
                maxDq.pollLast();
            }
            maxDq.addLast(right);


            while(!minDq.isEmpty() && nums[minDq.peekLast()]>=nums[right]){
                minDq.pollLast();
            }
            minDq.addLast(right);

            while(nums[maxDq.peekFirst()]- nums[minDq.peekFirst()]>limit){

                if(!maxDq.isEmpty() && left == maxDq.peekFirst()){
                    maxDq.pollFirst();
                }

                if(!minDq.isEmpty() && minDq.peekFirst()==left){
                    minDq.pollFirst();
                }

                left++;
            }

            maxLen = Math.max(maxLen, right-left+1);

        }

        return maxLen;
    }
}
