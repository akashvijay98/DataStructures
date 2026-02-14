


1423. Maximum Points You Can Obtain from Cards
// Use a fixed-length sliding window of size n - k to find the minimum sum of any consecutive n - k cards. 
// For each window position, calculate total - window_sum to get the corresponding score, and track the maximum.
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int windowSum =0;


        int max=0;


        int start=0;


        int n = cardPoints.length;


       // initially we take the sum of last k cards by iterating from n-k to n. 
       for(int i = n-k; i<cardPoints.length;i++){
            windowSum+=cardPoints[i];
        }


        max = Math.max(max, windowSum);


        int r = n-k;
        while(r<cardPoints.length){
            windowSum = windowSum-cardPoints[r] + cardPoints[start];
            start++;
            r++;


            max= Math.max(max, windowSum);
        }


        return max;
    }
}

