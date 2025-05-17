class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){

            // skip duplicate values of nums[i]
            if(i>0 && nums[i]==nums[i-1]) continue;

            // two sum
            int lo=i+1, hi = nums.length-1;
            while(lo<hi){
                int sum = nums[i] + nums[lo] + nums[hi];

                if(sum>0){
                  hi--;
                }
                else if(sum<0){
                    lo++;
                }
                else{
                    result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                    hi--;
                    lo++;

                    // check for duplcate values of nums[lo]
                    while(lo<hi && nums[lo]==nums[lo-1]){
                        lo++;
                    }

                    // we dont need to check for duplicate values of hi because: lo is already handled, so combination will not repeat

                    
                }
            }
        }   
        return result;
    }
}
