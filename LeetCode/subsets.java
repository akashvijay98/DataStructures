class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();

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
            backtrack(result,tempList,k,i+1,nums);

            tempList.remove(tempList.size()-1);

        }

    }
}
