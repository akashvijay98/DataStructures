class Solution {
    public void setZeroes(int[][] matrix) {

        // brute force solution

            
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();

            int r = matrix.length;
            int c = matrix[0].length;

            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(matrix[i][j]==0){
                        rowSet.add(i);
                        colSet.add(j);
                    }
                }
            }

            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(rowSet.contains(i) || colSet.contains(j)){
                        matrix[i][j]=0;
                    }
                    
                }
            }


        
    }
}
