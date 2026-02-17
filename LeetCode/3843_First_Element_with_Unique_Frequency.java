class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> map1 = new HashMap<>();

        for(int  num : nums){
            map1.put(num, map1.getOrDefault(num,0)+1);
        }

        HashMap<Integer,Integer> map2 = new HashMap<>();

    
        for(int key: map1.values()){
            map2.put(key, map2.getOrDefault(key,0)+1);
        }

        for(int n : nums){
            if(map2.get(map1.get(n))==1){
                return n;
            }
        }
        return -1;
    }
}
