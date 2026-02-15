//687. Longest Univalue Path
class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root,-10001);
        return max;

    }

    private int dfs(TreeNode root, int parent){
        if(root==null){
            return 0;
        }

        int left=  dfs(root.left, root.val);
        int right = dfs(root.right, root.val);

        max = Math.max(max, left+right);

        if(root.val==parent){
            return Math.max(left, right)+1;
        }
        else{
            return 0;
        }

    }
}
