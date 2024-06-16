class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE; 

    
    if((long)m*k>bloomDay.length) return -1;

    for(int i=0;i<bloomDay.length;i++){
        min = Math.min(min,bloomDay[i]);
        max = Math.max(max,bloomDay[i]);
    }

    int left = min;
    int right = max;

    while(left<=right){
        int mid = (left+right)/2;

        boolean possible = checkPossibility(bloomDay,mid,k,m);

        if(possible){
            right = mid-1;
        }
        else{
            left = mid+1;
        }


    }
   return left;
    }
    public boolean checkPossibility(int[] bloomDay, int day, int k, int m){
        int count = 0;
        int noOfBoq =0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count++;
            }
            else{
                noOfBoq += count/k;      
                count =0;         
            }
        }
        noOfBoq+= count/k;
        if(noOfBoq>=m){
            return true;
        }
        else{
            return false; 
        }
    }
}
