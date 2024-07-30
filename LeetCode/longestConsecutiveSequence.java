class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int maxLen = 0;

        for(int num : nums){
            set.add(num);
        } 

        for(int num: nums){
            if(!set.contains(num-1)){
                int currentNum = num;
                int curLength = 1;

                while(set.contains(currentNum+1)){
                    currentNum+=1;
                    curLength+=1;
                }
                maxLen = Math.max(maxLen,curLength);
            }
        } 
        return maxLen;  
    }
}
