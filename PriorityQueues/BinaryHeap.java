package PriorityQueues;

public class BinaryHeap {

    static void heapify(int [] arr, int index ){

        int leftChildIndex = 2*index;
        int rightChildIndex = 2*index+1;
        int largestElementIndex = index;

        // check if root element is smaller than children
        if(arr[index]< arr[leftChildIndex] || arr[index] < arr[rightChildIndex]){
            if(arr[leftChildIndex] > arr[rightChildIndex]){
                    largestElementIndex = leftChildIndex;
            }

            largestElementIndex = rightChildIndex;

            swap(arr,index,largestElementIndex);

           //recursive call to heapify array starting from the swapped index.
            heapify(arr,largestElementIndex);

        }

    }

    static void buildHeap(int [] arr, int size){
        // Index of last non-leaf node
        int startIdx = (size / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int index = startIdx; index >= 0; index--) {
            heapify(arr, index);
        }
    }
    public static void swap(int[] a, int x, int y){
        int temp;

        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        int N = arr.length;

        buildHeap(arr, N);
    }


}
