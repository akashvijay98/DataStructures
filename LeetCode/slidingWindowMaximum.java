class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length-k+1];
        int c=0;

        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekLast()<nums[i]){
                dq.pollLast();
            }

            dq.addLast(nums[i]);

            if(i>k-1 && dq.peek()==nums[i-k] ){
                dq.poll();
            }

            if(i>=k-1){
                result[c++] = dq.peekFirst();
            }

        }
        return result;
    }
}
