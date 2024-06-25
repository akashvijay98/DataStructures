class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int bottom = matrix.length-1;
        int top = 0;
        int row=-1;

        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target) {
                row = i;
            }
        }
        if(row ==-1){
            return false;
        }
        
        int left=0, right = matrix[row].length-1;
        while(left<=right){
            int mid = (left+right)/2;

            if(target<matrix[row][mid]){
                right = mid-1;
            }
            else if(target>matrix[row][mid]){
                left = mid+1;
            }
            else{
                return true;
            }
        }
        return false;

    }
}
