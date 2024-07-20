import java.util.*;

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
    int postIdx;
    int[] postOrder;
    int [] inOrder;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrder=postorder;
        inOrder=inorder;

        postIdx = postOrder.length-1;

        if (postOrder == null || postOrder.length == 0) {
            return null;
        }

        int idx= 0 ;

    
        for (Integer val : inOrder) {
            map.put(val,idx++);
        }

        return dfs(0, inOrder.length - 1);
    }

    private TreeNode dfs(int left, int right) {
        if (left > right) {
            return null;
        }

        // Poll elements from the queue and process them as needed
        int nodeVal = postOrder[postIdx];
        TreeNode root = new TreeNode(nodeVal);

        int index = map.get(nodeVal);

        postIdx--;

        root.right = dfs(index+1,right);
        root.left = dfs(left,index-1);
  

        return root;
    }


}
