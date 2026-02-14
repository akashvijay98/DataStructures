class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left =0, right =  removable.length-1;
        int res = 0;

        while(left<=right){
            int mid = (left+right)/2;

            // if you observe in the isSubsequence method, the for loop executes 'k' times which is nothing but..........
            //     the value of mid+1
            // for example if mid = 2, it means that we are checking for first 2 elements of the removable array .......
            //     in the isSubsequence() method, and the for loop runs from 0 to 1. 
            if(isSubsequence(s,p,removable,mid+1)){
                res=Math.max(res,mid+1);
                left = mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return res;

    }

    public boolean isSubsequence(String s,String p, int[] removable, int k){

        int m = s.length();
        int n = p.length();

       
        boolean[] removed = new boolean[m];

        for(int i=0;i<k;i++){
            removed[removable[i]] = true;
        }

        int i=0;
        int j=0;


        while(i<m && j<n){
            if(!removed[i] && s.charAt(i)==p.charAt(j)){
                j++;
            }
            i++;
        }
        return j==n;
    }
}
