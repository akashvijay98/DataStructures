package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int size = nums.length;

        List<List<Integer>> finalList = new ArrayList<List<Integer>>();

        Arrays.sort(nums);

        for(int i=0;i<size-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i+1;
            int  hi = size-1;

            while(lo < hi){
                int sum = nums[i]+nums[lo]+nums[hi];

                if(sum==0){
                    finalList.add(Arrays.asList(nums[i],nums[lo],nums[hi]));

                    while(lo<hi && nums[lo]==nums[lo+1]){
                        lo++;
                    }
                    while(lo<hi && nums[hi]==nums[hi-1]){
                        hi--;
                    }
                    lo++;
                    hi--;

                }
                if(sum<0){
                    lo++;
                }
                else if(sum>0){
                    hi--;
                }
            }


        }
        return finalList;

    }
}