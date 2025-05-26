class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

         
       // int i=0 will add empty [] to result, and i <= nums.length ---- pay attention  
        for(int k=0;k<=nums.length;k++){
            backtrack(result,tempList,k,0,nums);
        }
        return result;

    }

    public void backtrack(List<List<Integer>> result, List<Integer> tempList,int k,int start, int[] nums){
        if(tempList.size()==k){
            result.add(new ArrayList<Integer>(tempList));
        }

        for(int i=start;i<nums.length;i++){
            tempList.add(nums[i]);

            // we do i+1 because we want totally unique combinations. here [1,2] and [2,1] are the same.
            backtrack(result,tempList,k,i+1,nums);

            tempList.remove(tempList.size()-1);

        }

    }
}
