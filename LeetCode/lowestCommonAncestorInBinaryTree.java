/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode  q){
        if(root==null){
            return null;
        }
        if(root.val==p.val || root.val==q.val){
            return root;
        }

        TreeNode left = dfs(root.left,p,q);
        TreeNode right = dfs(root.right,p,q);
        if(left==null && right ==null){
            return null;
        }
        if(left == null && right!=null){
            return right;
        }
        else if(right == null && left!=null){
            return left;
        }
        else{ return root;}
    }
}
