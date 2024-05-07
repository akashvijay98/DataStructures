/*
You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.

For chosen indices i0, i1, ..., ik - 1, your score is defined as:

The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
Return the maximum possible score.

A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.

 

Example 1:

Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
Output: 12
Explanation: 
The four possible subsequence scores are:
- We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
- We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6. 
- We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12. 
- We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
Therefore, we return the max score, which is 12.
Example 2:

Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
Output: 30
Explanation: 
Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.
 

Constraints:

n == nums1.length == nums2.length
1 <= n <= 105
0 <= nums1[i], nums2[j] <= 105
1 <= k <= n

*/








class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] pairs = new int[n][2];

        for(int i =0; i<nums1.length;i++){
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i]; 
        }
        /* 
        The array pairs should be sorted in descending order based on n2.
        This is because as we choose k elements from nums1, we need to choose the minimum element from subarray of corresponding nums2 elements.
        hence as we choose elements from nums1, the corresponding nums2 elements values must decrease so that the most recent n2 value will be the minimum value(values  to its left would always be greater since sorted in descending order).

        for example: after sorting the pairs array ---> [[14,13],[2,11],[1,7],[12,16]] where in every row first element is nums1 and second element is nums2.
        let k =3; so as we add 14+2+1 and multiply the sum with 7 which is the least element out of 13,11 and 7. 
        */
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
       

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum=0, res = 0;


        for(int i= 0; i<pairs.length;i++){
            int n1= pairs[i][0];
            int n2= pairs[i][1];  

            sum+=n1;
            minHeap.add(n1);
            

            if(minHeap.size()>k){
               
                /* if size exceeds k, then we remove the minimum element from heap because we want only the top k larger elements to be present in the sum to yield maximum result when multiplied with n2(min element from nums2) */
                
                sum-=minHeap.poll();
                

            }
            if(minHeap.size() == k ){
                res = Math.max(res,sum*n2);
            }
        }


        return res;

    }
}
