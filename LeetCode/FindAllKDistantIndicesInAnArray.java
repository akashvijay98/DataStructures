class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
      

        int idx=0;
        boolean[] visited = n boolean[n];

        List<Integer> res= new ArrayList<>();
        for(int j=0;j<n;j++){
            ac
            if(nums[j]==key){
               int  l = Math.max(0, j-k);
               int  r = Math.min(n-1, j+k);

                for(int i=l;i<=r;i++){
                    if(!visited[i]){
                        res.add(i);
                        visited[i]=true;
                    }
                    
                }
            }
            
        }
        
        Collections.sort(res);
        return res;
    }
}
