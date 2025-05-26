class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums);

        for(int i=0;i<=nums.length;i++){
            backtrack(0,nums,i,list);
        }

        return result;
    }

    private void backtrack(int index, int[] nums, int k, ArrayList<Integer> list){
        
        if(list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=index; i<nums.length; i++){
            // suppose nums = [1,2,2], and in the result we already have[ [],[1],[2],[1,2,2]]. 
            // when index = 1 and i=2, i>index, and nums[i]=nums[i-1]
            //  this will again add [1,2,2] to the result which is duplicate combination.
            // hence we skip i.
            if(i>index && nums[i]==nums[i-1]){
               continue;
            }
             list.add(nums[i]);
                backtrack(i+1, nums, k, list);

                list.remove(list.size()-1);

        }
    }
}
