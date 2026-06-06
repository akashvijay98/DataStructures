
import java.util.Arrays;
class Main {
    
    public static void partition(int [] arr, int start, int end){
        
        if(start == end){
            return;
        }
        
        int mid = (start + end)/2;
        
        partition(arr, start, mid);
        partition(arr, mid+1, end);
        
        merge(arr, start, mid, end);
        
    }
    
    public static void merge(int[] arr, int start, int mid, int end){
         int[] left = Arrays.copyOfRange(arr, start, mid+1);
         int[] right = Arrays.copyOfRange(arr, mid+1, end+1);
        
        int l = 0, r=0, idx=start;
        
        while(l<left.length && r<right.length){
        	if(left[l] < right[r]){
        		arr[idx]=left[l];
        		l++;
        	}
        	else{
        		arr[idx] = right[r];
        		r++;
        	}
        	idx++;
        }
        
        while(l<left.length){
        	arr[idx] = left[l];
        	l++;
        	idx++;
        }
        
        
        while(r<right.length){
        	arr[idx] = right[r];
        	r++;
        	idx++;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{36,27,41,52,10};
        
        partition(arr,0,arr.length-1);
        
        for(int num: arr){
                System.out.println(num);
        
        }

    }
}
