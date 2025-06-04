class Solution {

    // this problem is similar to Koko eating banana
    public int maxLength(int[] ribbons, int k) {
        int max = 0;
        int maxLength =0;

        for(int num: ribbons){
            max = Math.max(max,num);
        }

        // lower limit will for Binary search will be 1 as mentioned in constraints
        // the upper limit for Binary Search would be the maxNumber in ribbons.

        int lo=1;
        int hi = max;

        while(lo<=hi){
            int mid = (lo+hi)/2;

            // the cut method will return the total number of ribbons of length mid that can be cut from the ribbons array

            int count = cut(ribbons, mid);

            // if the number of ribbons is >= k, we already have a potential max, so we will search for a greater length hence we reduce the left search space.
            if(count>=k){
                maxLength = Math.max(maxLength, mid);
                lo = mid+1;
            }
            // if count<k, it means we can only cut a maximum of count ribbons of length mid.
            //  hence we need to reduce the search space to the right, in order to find  a smaller length mid.
            else{
                hi = mid-1;
            }
            
        }
        return maxLength;
    }

    private int cut(int[] ribbons, int size){
        int counter = 0;
        for(int i=0;i<ribbons.length;i++){
            counter += ribbons[i]/size;
        }
        return counter;
    }
}
