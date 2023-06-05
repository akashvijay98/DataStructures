package Sorting;

public class MergeSort {
    public void partition(int a[], int l, int r){

        if(l<r) {


            int mid = l + (r - 1) / 2;

            partition(a, l, mid);
            partition(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    public void merge(int arr[],int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String args[])
        {
            int arr[] = { 12, 11, 13, 5, 6, 7 };

            System.out.println("Given array is");
            printArray(arr);

            MergeSort ob = new MergeSort();
            ob.partition(arr, 0, arr.length - 1);

            System.out.println("\nSorted array is");
            printArray(arr);
        }
    }



