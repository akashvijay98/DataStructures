class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(tempList,result,nums);
        return result;

        
    }

    public void backtrack(List<Integer> tempList, List<List<Integer>>result, int[]nums){

 
        if(tempList.size()==nums.length){
            result.add(new ArrayList<Integer>(tempList));
            return;
        }
        for(int num:nums){
           

            if(!tempList.contains(num)){
                tempList.add(num);
                backtrack(tempList,result,nums);
                tempList.remove(tempList.size()-1);


            }
           

        }

    }
}
