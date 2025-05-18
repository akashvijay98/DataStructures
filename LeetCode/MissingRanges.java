class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        
        int prev = lower-1;
        int cur;
        
        List<List<Integer>> result = new ArrayList<>();

       for(int i=0;i<=nums.length;i++){
            if(i < nums.length){
                cur = nums[i];
            }

            // suppose lower = 0, upper = 10 , nums = [0,1,2,3,4,5]
            // when i is at the last position, there is no other element after 5, but upper = 10
            // to handle this, we will make cur = upper+1(11) so that prev+1 = 6 and cur-1 = 10
            else{
                cur = upper+1;
            }

            // we find the missing elements by checking the gap between two elements
            // if the gap is greater than 1, it means the numbers are missing
            if(cur-prev >1){
                List<Integer> range = new ArrayList<>();
                range.add(prev+1);
                range.add(cur-1);

                result.add(range);
            }
            prev = cur;


       }
       return result;
    }
}
