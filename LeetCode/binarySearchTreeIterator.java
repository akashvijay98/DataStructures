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
class BSTIterator {
    ArrayList<Integer> nodeSorted;
    int index;

    public BSTIterator(TreeNode root) {
        nodeSorted = new ArrayList<>();
        index = -1;
        inOrder(root);
    }
    
    public void inOrder(TreeNode root){
        if(root ==null){
            return ;

        }

        inOrder(root.left);
        nodeSorted.add(root.val);
        inOrder(root.right);

    }
    public int next() {
        int item = nodeSorted.get(++index);
        
        return item;
        
    }
    
    public boolean hasNext() {
        if(index+1< nodeSorted.size()){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
