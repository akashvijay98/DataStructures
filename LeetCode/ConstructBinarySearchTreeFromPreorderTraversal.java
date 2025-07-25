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
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode > stack = new Stack<>();

        int n = preorder.length;

        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        TreeNode cur = root;

        for(int i=1;i<n;i++){
            TreeNode node = new TreeNode(preorder[i]);

            
            if( node.val< cur.val){
                cur.left = node;
                stack.push(cur);
                cur = cur.left;
                
            }
            else{
                while(!stack.isEmpty() && stack.peek().val<node.val){
                    cur = stack.pop();
                }
                cur.right = node;
                cur=cur.right;

            }
            
        }
        return root;
    }
}
