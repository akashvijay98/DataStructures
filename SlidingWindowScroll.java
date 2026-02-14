


1423. Maximum Points You Can Obtain from Cards
// first calculate the sum of last k cards from n-k to n
// keep a pointer from the beggining of the array(start)
// move the window to the right by removing element at n-k and add element at start


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

