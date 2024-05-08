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

/* 
In this problem, we try to find the maximum path from adjacent nodes.
so  lets take example of binary tree:                       

                        -10
                        / \
                      9    20
                           / \
                        15     7
          we will start from the left bottom, so in the begining max will be 9.
          then max will be 15+20+7 = 42.
          finaly we check for 9+ -10 + 20, since it is less than 42 our max will be 42.

                        10
                        / \
                      1    20
                           / \
                        15     7

                here first max will be 10(root value).
                then max will be 15+20+7 = 42.
                but to root value 10, function calls dfs(root.left) will return 1 and dfs(root.right) will return 35.
                since 10+35+1=46 will be greater than 42, max will be 46.
                
          
*/
class Solution {
    int max= 0;
    public int maxPathSum(TreeNode root) {

      max = root.val;
        dfs(root);
        return max;
    
    }
    public int dfs(TreeNode root){
        
        if(root == null){
            return 0;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);

        left = Math.max(left,0);
        right = Math.max(right,0);

        max = Math.max(max, (root.val + left + right));

     
        return  Math.max(left,right)+root.val;

    }

   
}
