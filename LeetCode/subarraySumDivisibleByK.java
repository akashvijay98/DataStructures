class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int prefix_sum=0;
        int res =0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefix_sum+=nums[i];
            int rem = prefix_sum%k;

            if(rem<0){
                rem+=k;
            }

            if(map.containsKey(rem)){
                res+=map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem,0)+1);
        }

        return res;
    }

}
