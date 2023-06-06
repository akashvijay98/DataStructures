package Sorting;

import java.util.Arrays;

public class QuickSort {

    public int partition(int a[],int start , int end){

        int pivot = a[end];
        int pivotIndex = start;

        if(start<end){
            for(int i=start ; i< a.length;i++){

                if(a[i]< pivot){
                    swap(a, pivotIndex, i);
                    pivotIndex+=1;
                }

            }
            swap(a,pivotIndex,end);
            //System.out.println("intermediate array Result"+ Arrays.toString(a));
           // System.out.println("End"+ end);

            //System.out.println("PivotIndex"+ pivotIndex);

        }
        return pivotIndex;
    }

    public void sort(int a[], int start, int end){
        if(start<end) {

            int partitionIndex = partition(a, start, end);

            sort(a, start, partitionIndex-1);
            sort(a, partitionIndex + 1, end);

        }

    }

    static void swap(int a[], int i, int j){

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static void main(String args[]){

        int a[] ={7,3,5,1,4,40,32,50,21};

        QuickSort obj = new QuickSort();
        obj.sort(a,0, a.length-1);
        System.out.println("Sorted Array ==>"+Arrays.toString(a));

    }

}
