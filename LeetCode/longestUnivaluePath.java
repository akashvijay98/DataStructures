/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxCount=0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root,-1);
        return maxCount;
    }

    public int dfs(TreeNode root, int parent){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left,root.val);
        
        int right = dfs(root.right,root.val);
        
        
        maxCount = Math.max(maxCount, left+right);

        return root.val == parent? Math.max(left,right)+1:0;


    }
}
