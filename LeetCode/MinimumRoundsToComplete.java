class Solution {
    public int minimumRounds(int[] tasks) {
       HashMap<Integer,Integer> map = new HashMap<>();

        int count =0;
        int n = tasks.length;
       for(int i=0;i<n;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
       } 

       for(int key: map.keySet()){
            // only 2 or 3 tasks can be processed
            if(map.get(key)==1){
                return -1;
            }
        
          if(map.get(key)%3==0){
            count+=map.get(key)/3;
          }
          else{
             count += map.get(key)/3+1;
          }
       }

       return count;
    }
}
