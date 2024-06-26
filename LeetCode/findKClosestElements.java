class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        
        List<Integer> result = new ArrayList<>();
        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            
            return result;
        }
        
// Binary search for finding the closest possible position.
        while(left<=right){
            mid = (left + right) / 2;
            
            
            if(arr[mid]==x){
                
                // if an element if found, then we just keep mid as the left most position because that is where we begin
                // our expansion of sliding window and also that is the position with the minimum difference between x and array element
                left = mid;
                break;
            }else if(arr[mid]<x){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        left -=1;
        right = left+1;

        while(right-left-1 < k){
            if(left ==-1 ){
                right+=1;
                continue;
            }

            if(right==arr.length || Math.abs(arr[left]-x) <= Math.abs(arr[right]-x)){
                left-=1;
             }
            else{
                right+=1;
            }
            
        }
        for(int i= left+1;i<right;i++){
            result.add(arr[i]);
        }
        return result;

    }
}
