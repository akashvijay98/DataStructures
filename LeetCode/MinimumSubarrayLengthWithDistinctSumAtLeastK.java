class Solution {
    public int minLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;

        int left = 0;

        int sum = 0;

        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(map.getOrDefault(nums[i],0)==0){
                sum+=nums[i];
            }
            
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);

            while(sum>=k){
                min=  Math.min(min, i-left+1);
                int leftVal = nums[left];
                map.put(leftVal, map.get(leftVal)-1);

                if(map.getOrDefault(leftVal,0)==0){
                    sum-=leftVal;
                }

                left++;
            }

        }

        return min==Integer.MAX_VALUE?-1:min;
    }
}
