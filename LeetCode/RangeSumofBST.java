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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum =0;
        if(root != null){
            if(root.val>=low && root.val<=high){
                sum+=root.val;
            }
        }

        if(root.left!=null && root.val>low){
            sum+= rangeSumBST(root.left, low, high);
        }

        if(root.right !=null && root.val<high){
            sum+= rangeSumBST(root.right, low, high);
        }

        return sum;
    }
    
}
