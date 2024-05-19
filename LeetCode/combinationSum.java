class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(target,comb,0,candidates,result);
        return result;
    }

      public void backtrack(int remain, LinkedList<Integer> comb, int start,int[] candidates, List<List<Integer>> result){

        if(remain ==0){
            result.add(new ArrayList<Integer>(comb));
            return;
        }
        else if(remain<0){

            return;
        }

        for(int i=start;i<candidates.length;i++){
            comb.add(candidates[i]);
            this.backtrack(remain-candidates[i],comb,i,candidates,result);
            comb.removeLast();
        }

    }
}
