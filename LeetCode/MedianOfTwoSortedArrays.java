package LeetCode;

class MedianOfTwoSortedArrays {
    int count=0;
    public double findMedian(int[] nums1, int[] nums2) {

        int count = 0;
        int index1 = 0;
        int index2 = 0;

        int l1  = nums1.length;
        int l2 = nums2.length;
        int length = (nums1.length + nums2.length);
        int arr[] = new int[length];


        while (index1 < l1 && index2 < l2 ) {

            if (nums1[index1] <= nums2[index2]) {
                arr[count] = nums1[index1];
                index1++;
            } else {
                arr[count] = nums2[index2];
                index2++;
            }
            count++;

        }

        if(index1 < l1){
            while(index1<l1){
                arr[count] = nums1[index1];
                index1++;
                count++;
            }

        }

        if(index2<l2){
            while(index2<l2){
                arr[count] = nums2[index2];
                index2++;
                count++;
            }
        }

        System.out.println("Array"+arr[count-1]);
        if (count % 2 == 0) {
            return (arr[count / 2 - 1] + arr[count / 2]) / 2.0;
        } else {
            return arr[count / 2];
        }


    }

    public static void main(String args[]){

        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();

        int[] array1 = {1,2,3,4};
        int[] array2 = {3,4,5};

        double result  = obj.findMedian(array1, array2);

        int a= 9;
        double b = a;

        System.out.println(b);

        System.out.println("result= "+result);

    }


}

