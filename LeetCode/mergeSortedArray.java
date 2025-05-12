class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

          // Initialize pointers to the last valid elements of nums1 and nums2
          int p1 = m - 1; // Last element in the valid portion of nums1
          int p2 = n - 1; // Last element in nums2

       // in this problem, the size of nums1 is m+n,and nums1 contains m elements. so we will use nums1 to merge all the elements

        for(int p=m+n-1;p>=0;p-- ){
            // if all elements of nums2[p2] is added to nums1, we can exit the loop
            if(p2<0){
                break;
            }

            // if p1 is in bounds and nums1[p1] is greater, we add nums1[p1] to nums1[p]
            // the greater element will go to the end of nums1
            if(p1>=0 && nums1[p1]> nums2[p2]){
                nums1[p]=nums1[p1--];
            }
            else{
                nums1[p]=nums2[p2--]; 
            }
        }
    }
}
