public class quicksort {

    void sort(int[] a, int start, int end) {
        // keep sorting until start<end
        if (start < end) {
            int index = partition(a, start, end);

            sort(a, start, index - 1);
            sort(a, index + 1, end);
        }
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    // move all elements less than pivot to its left
    // after the for loop, the position of startIndex is the position where all elements before the position are smaller.
    // hence swap with pivot elements so that smaller elements < pivot < larger elements
    int partition(int[] a, int start, int end) {
        int pivot = a[end];
        int startIndex = start;

            for (int i = start; i < end; i++) {
                if (a[i] < pivot) {
                    swap(a, startIndex, i);
                    startIndex++;
                }

            }





        swap(a, startIndex, end);
        return startIndex;

    }









    public static void main(String[] args){

        int[] arr = new int[] {1,3,8,2,4};

        quicksort q = new quicksort();

        q.sort(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
