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
    public boolean isEvenOddTree(TreeNode root) {
        boolean isEven = true;
        TreeNode current = root;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int prev = Integer.MAX_VALUE;

            if(isEven){
                prev = Integer.MIN_VALUE;
            }

            while(size>0){
                current = q.poll();

                if(isEven){
                    if(current.val%2==0 || current.val<=prev){
                        return false;
                    }

                }
                else if(!isEven){
                    if(current.val%2==1 || current.val>=prev){
                        return false;
                    
                    }
                    
                }

                prev=current.val;

                if(current.left != null){
                    q.add(current.left);
                }
                if(current.right != null){
                    q.add(current.right);
                }

                size--;
                
            }

            isEven = !isEven;
        }

        return true;
        
    }
}
