import java.util.*;

public class Main {

    public static void main(String[] args) {
        Integer[] values = {3,5,1,6,2,0,8,null,null,7,4};

        TreeNode root = buildTree(values);

        TreeNode p = findNode(root, 5);
        TreeNode q = findNode(root, 1);

        Solution sol = new Solution();
        TreeNode lca = sol.lowestCommonAncestor(root, p, q);

        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + (lca != null ? lca.val : "null"));
    }

    // TreeNode definition
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    // Build binary tree from level order array
    public static TreeNode buildTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) return null;

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode curr = queue.poll();
            if (i < values.length && values[i] != null) {
                curr.left = new TreeNode(values[i]);
                queue.offer(curr.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                curr.right = new TreeNode(values[i]);
                queue.offer(curr.right);
            }
            i++;
        }

        return root;
    }

    // Find node by value
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    // Your Solution class
    public static class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
                TreeNode node = lca(root,p,q);
                
                if(node == p){
                    return dfs(root,q)?node:null;
                }
                else if(node ==q){
                    return dfs(root,p)?node:null;
                }
                
                return node;
        }
        private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
            if(root==null || root==p || root==q){
                return root;
            }
            
            TreeNode left = lca(root.left,p,q);
            TreeNode right = lca(root.right,p,q);
            
            if(left !=null && right !=null){
                return root;
            } 
            
            return left!=null?left:right;
        }
        
        private boolean dfs(TreeNode root, TreeNode target){
            if(root == null){
                return false;
            }
            
            if(root == target){
                return true;
            }
            
            return dfs(root.left,target)||dfs(root.right,target);
        }
    }
}
