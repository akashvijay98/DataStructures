class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int windowSum =0;

        int max=0;

        int start=0;

        int n = cardPoints.length;

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
