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



/* 
We use a pointer prev that always keeps track of the last node in the flattened list.

So for each node, you:

    1. Flatten the right subtree (so it's already a chain).

    2. Flatten the left subtree (and connect it before the right).

    3. Set root.right = prev, and root.left = null.

The key idea: You’re rewiring the tree from bottom to top, not from root downward.
 */

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        
        if(root==null){
            return;
        }

        flatten(root.right);
        
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev= root;


    }
}
