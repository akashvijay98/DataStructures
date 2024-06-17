class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxVal=Integer.MIN_VALUE;
        int totalSum=0;
        int res = Integer.MAX_VALUE;
        
       

        for(int weight: weights){
            totalSum+=weight;
            maxVal = Math.max(maxVal,weight);
        }

        int left = maxVal;
        int right = totalSum;

        while(left<=right){
            int mid = (left+right)/2;

            boolean feasible = isFeasible(mid,weights,days);
            if(feasible){
                res = Math.min(res,mid);
                right = mid-1;
            }
            else{
                left= mid+1;
            }
        }

        return res;
    }

     boolean isFeasible(int capacity, int[] weights,int days){
            int total = 0;
            int tempDays = 1;
            for(int weight:weights){
                if(total+weight<=capacity){
                    total+=weight;
                }
                else{
                    tempDays++;
                    total=weight;
                }

            }
            if(days<tempDays){
                return false;
            }
            else{
                return true;
            }
            
        }
   
}
