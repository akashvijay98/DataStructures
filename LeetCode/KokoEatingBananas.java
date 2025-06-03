class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // note: if  piles[i]< k , then koko will eat only piles[i] bananas that hour
        //      if(piles[i]>k), then koko will eat k bananas that hour, then piles[i]-k in the next hour,

        //        e.g: piles[i]=6, k=4, then 4 bananas in first hour, then 6-4=2 in the next hour
        //       = 2 hours to eat 6 banans, when k=4

        //        hence Math.ceil((double) piles[i]/mid) will give Math.ceil((double)6/4) -> Math.ceil(1.8) -> 2
        //       = 2 hours to eat 6 bananas, when k = 4.

         int n= piles.length;
      
        int max = Integer.MIN_VALUE;

        for(int num:piles){
            max = Math.max(max,num);
        }
        

          int minHours = max;

        int lo=0;
        int hi = max;

        while(lo<=hi){
            int mid = (lo+hi)/2;
            int hours=0;
            for(int i=0;i<n;i++){
                hours+= Math.ceil((double)piles[i]/mid);  // in order to get decimal values we need to use casting (double)
                // because suppose piles[i] = 6 and mid = 4, 6/4 will result 1 if we dont use (double)
                // if we use (double) , then 6/4 will result in 1.8, and then Math.ceil(1.8) will give 2.
            }

            if(hours<=h){
                minHours = Math.min(minHours,mid);
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }

        }

        return minHours;


    }
}
