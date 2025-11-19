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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(!isLeaf(root)){
            res.add(root.val);
        }

        TreeNode t = root.left;

        while(t!=null){
            if(!isLeaf(t)){
                res.add(t.val);
            }

            if(t.left!=null){
                t=t.left;
            }
            else{
                t=t.right;
            }
            
        }
        addLeaves(root,res);

        Stack<Integer> stack = new Stack<>();

        t=root.right;

        while(t!=null){
            if(!isLeaf(t)){
                stack.push(t.val);
            }
            
            if(t.right!=null){
                t=t.right;
            }
            else{
                t=t.left;
            }
        }

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }

        return res;

        

    }

    private boolean isLeaf(TreeNode node){
        if(node.left==null && node.right==null){
            return true;
        }
        else{
            return false;
        }
    }

    private void addLeaves(TreeNode root, List<Integer> res){
        if(isLeaf(root)){
            res.add(root.val);
        }

        if(root.left != null){
            addLeaves(root.left, res);
        }
        if(root.right != null){
            addLeaves(root.right,res);
        }
    }
}
