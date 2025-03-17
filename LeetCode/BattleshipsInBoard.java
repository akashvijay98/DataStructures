// Approach
// since this problem specifies that all adjacent Xs horizontally or vertically are counted as single X we can solve 
//this by recursion (DFS)
// so we recursively visit the neighbouring Xs and count them only once.
class Solution {
    int count =0;
    public int countBattleships(char[][] board) {
        
        boolean[][] visited  = new boolean[board.length][board[0].length]; 
        // we just count the number of X's from the outer forloops and mark any visited cell as '.' so that they are not visited again
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    count++;
                    dfs(board,i,j);
                }
            }
        }
        return count;

    }

    private void dfs(char[][] board, int r, int c){

        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!='X'){
            return;
        }

        board[r][c] = '.';

        dfs(board, r+1,c);
        dfs(board, r-1,c);
        dfs(board, r,c+1);
        dfs(board, r,c-1);

    }
}
