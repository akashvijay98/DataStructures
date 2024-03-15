class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev = -1, suffix= -1, maxMid= -1, zeros=0;

        for(int i=0; i<seats.length; i++){
            if(seats[i]==0){
                zeros++;
            }
            else {
                if(prev == -1){
                    prev = zeros;

                }

                else{
                    maxMid = Math.max(maxMid,zeros);
                   
                }
                zeros=0;
            }


        }
        suffix = zeros;
        return Math.max(Math.max(suffix, prev), (maxMid+1)/2);
    }
}
