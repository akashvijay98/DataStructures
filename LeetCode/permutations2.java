class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> tempList = new ArrayList<>();

       HashMap<Integer,Integer> map = new HashMap<>();

       for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,0);
            }
            map.put(num,map.get(num)+1);
            

       }
       backtrack(tempList,result,nums,map);
       return result; 

    }

    public void backtrack(List<Integer>tempList, List<List<Integer>> result, int[] nums, HashMap<Integer,Integer> map){
        if(tempList.size()==nums.length){
            result.add(new ArrayList<Integer>(tempList));
            return;
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Integer num = entry.getKey();
            Integer count = entry.getValue();

            if(count==0){
                continue;
            }
            tempList.add(num);
            map.put(num,count-1);

            backtrack(tempList,result,nums,map);

            tempList.remove(tempList.size()-1);

            map.put(num,count);

        }
    }
}
