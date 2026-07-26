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


//PathSum

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int sum, int target){

        if(root==null){
            return false;
        }
         sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==target){

                return true;
            }
            else{
                return false;
            }   
        }
        
       
        return dfs(root.left,sum,target) || dfs(root.right,sum,target);

    }
}


// path Sum 2

class Solution {
     List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       
          ArrayList<Integer> list = new ArrayList<>();
        backtrack(root, targetSum, 0, list);

        return result;

    }

    private void backtrack(TreeNode root, int target, int sum, List<Integer> list){
       
        if(root==null){
            return;
        }

        

        sum+=root.val;
        list.add(root.val);

        if(sum==target && root.left== null && root.right==null){
            result.add(new ArrayList<>(list));
        }

        backtrack(root.left, target, sum, list);
        backtrack(root.right, target, sum, list);

        sum-=root.val;
        list.remove(list.size()-1);

    }
}


// 2415. Reverse Odd Levels of Binary Tree
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        // Start the DFS with the left and right children at level 1 (odd)
        dfs(root.left, root.right, 1);
        
        return root;
    }

    private void dfs(TreeNode leftNode, TreeNode rightNode, int level) {
        // Base case: Since it's a perfect binary tree, we only need to check one for null
        if (leftNode == null || rightNode == null) {
            return;
        }

        // If we are at an odd level, swap their values
        if (level % 2 != 0) {
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
        }

        // Traverse symmetrically:
        // 1. The "outer" nodes: Left child's left matches with Right child's right
        dfs(leftNode.left, rightNode.right, level + 1);
        
        // 2. The "inner" nodes: Left child's right matches with Right child's left
        dfs(leftNode.right, rightNode.left, level + 1);
    }
}
