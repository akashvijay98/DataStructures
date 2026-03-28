class Solution {
     public boolean exist(char[][] board, String word) {
        if (word.length() > board.length * board[0].length) return false;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){

                    if(board[i][j]==word.charAt(0)){
                        if(dfs(board,i,j,word, 0)){
                        return true;
                    }
                }
               
            }
        }

        return false;
    }

    private boolean  dfs(char [][] board, int row, int col, String word, int idx){
        if(idx==word.length()){
            return true;
        }
        int r = board.length;
        int c = board[0].length;
        if(row>=r || row<0 || col>=c || col<0 || board[row][col]!=word.charAt(idx)){
            return false;
        }
      char temp = board[row][col];
        board[row][col] = '#';
        idx++;
        
        boolean found=  dfs(board, row+1, col, word, idx) || dfs(board, row-1, col, word, idx) || dfs(board, row, col+1, word, idx) || dfs(board, row, col-1, word, idx);   
        
        board[row][col]=temp;
        
        return found;

    }
}
