class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        backtrack(n,k,comb,0,result);
        return result;
    }

    public void backtrack(int remain, int k, LinkedList<Integer> comb, int nextStart, List<List<Integer>> result){

        if(remain ==0 && comb.size()==k){
            result.add(new ArrayList<Integer>(comb));
            return;
        }
        else if(remain<0 || comb.size()==k){

            return;
        }

        for(int i=nextStart;i<9;++i){
            // add i+1 because i will be 0, so increment to 1 
            comb.add(i+1);
            this.backtrack(remain-i-1,k,comb,i+1,result);
            comb.removeLast();
        }

    }
}
