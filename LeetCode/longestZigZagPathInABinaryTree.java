class Solution {
    int pathLength = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, false, 0);
        dfs(root, true, 0);
        return pathLength;
    }

    public void dfs(TreeNode root, boolean goLeft, int step){
        if(root == null){
            return ;
        }
        
        pathLength = Math.max(pathLength, step);

        if(goLeft){
            dfs(root.left, false, step+=1);
            dfs(root.right, true, 1);
        }
        else{
            dfs(root.right, true, step+=1);
            dfs(root.left, false,1);
        }

    }
        
    
       
    
}
