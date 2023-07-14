package LeetCode;

import java.util.HashMap;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int size = nums.length;
        for(int i=0;i<size;i++){
            if(map.containsKey(nums[i])){
                int pos = map.get(nums[i]);
                return new int[]{pos,i};
            }
            else{
                map.put((target-nums[i]),i);
            }

        }
        return new int[2];
    }

}