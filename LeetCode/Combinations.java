class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tempList = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        backtrack(n,k,1,tempList,result);
        return result;
    }
    public void backtrack(int n, int k, int pos, List<Integer> comb, List<List<Integer>> result){

        if(comb.size()>=k){
            if(comb.size()==k){
                result.add(new ArrayList<>(comb));
            }
            return;
        }
        for(int i=pos;i<=n;i++){
            comb.addLast(i);
            backtrack(n,k,i+1,comb,result);
            comb.removeLast();
        }

    }
}
