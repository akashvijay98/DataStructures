class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int total = 0;

        int k = goal;

        map.put(0,1);

        for(int i =0;i<nums.length;i++){
            sum+=nums[i];

            if(map.containsKey(sum-k)){
                total+=map.get(sum-k);
            }          

            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        return total;
    }
}
