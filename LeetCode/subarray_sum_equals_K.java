class Solution {


    /*
        Approach: We keep adding the current num to prefixSUm.

        so if we add any number to prefixSum, if that number = k then
        prefixSum-k will give that sum.

    */

    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        int prefixSum=0;
        int sum = 0;

        map.put(0,1);

        for(int num:nums){
            prefixSum+=num;

            // Since we have prefix sum, find if a number prefixSum - k exists, so it satisifies equation or find missing complementing the equation.
            sum+=map.getOrDefault(prefixSum-k,0);

            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return sum;
    }
}
