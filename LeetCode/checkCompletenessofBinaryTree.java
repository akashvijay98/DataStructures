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
    public boolean isCompleteTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();

    boolean isNodeNull = false; 

    q.add(root);

    while(!q.isEmpty()){

        int size = q.size();

        for(int i=0;i<size;i++){
            TreeNode node = q.poll();

            if(node==null){
                isNodeNull = true;
            }
            else{
                if(isNodeNull){
                    return false;
                }

                q.add(node.left);
                q.add(node.right);
            }


        }
    
    }
    return true;
    }
}
