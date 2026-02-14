class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for(int num: nums){
            List<List<Integer>> list = new ArrayList<>();

            for(List<Integer> p:result){
                // pay attention, i <= p.size
                for(int i=0;i<=p.size();i++){
                    List<Integer> newPermutation = new ArrayList<>(p);

                    newPermutation.add(i,num);

                    list.add(newPermutation);
                }
            }

            result = list;
        }
        return result;
    }
}
