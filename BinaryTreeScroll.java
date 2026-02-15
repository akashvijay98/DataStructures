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


// 543. Diameter of Binary Tree

class Solution {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(max, left+right);

        return 1+Math.max(left,right);
    }
}


// Kth Smallest element in a BST
class Solution {
    int val;
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return val;
    }

    private void dfs(TreeNode root, int k){
        if(root==null){
            return;
        }

        dfs(root.left,k);
        
        count++;
        
        if(count==k){
            val = root.val; 
            return;  
        }

        dfs(root.right,k);
    }
}


//98. Validate Binary Search Tree

class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int left, int right){
        if(root==null){
            return true;
        }

        if(root.val>right || root.val<left){
            return false;
        }

        return dfs(root.left,left,root.val) && dfs(root.right,root.val,right);
    }

   
}
