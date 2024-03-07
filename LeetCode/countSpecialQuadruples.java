class Solution {
    public int countQuadruplets(int[] arr) {
        int n=arr.length;
        int i=0,j=1,k=2,l=3;
        int count=0;
        while(true){
            if(arr[i]+arr[j]+arr[k]==arr[l]){
                count++;
            }
            if(l<n-1){
                l++;
            }
            else if(k<l-1){
                k++;
                l=k+1;
            }
            else if(j<k-1){
                j++;
                k=j+1;
                l=j+2;
            }
            else if(i<j-1){
                i++;
                j=i+1;
                k=i+2;
                l=i+3;
            }
            else{
                break;
            }
        }
        return count;
    }
}
