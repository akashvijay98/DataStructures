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

/* return a list containing all the paths whose sum equals to the target Sum */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> pathNodes = new ArrayList<>();
        int pathSum=0;

        dfs(root,pathNodes,result,targetSum,pathSum);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> pathNodes,List<List<Integer>> result,int targetSum, int pathSum){

        if(root == null){
            return;
        }

        pathSum+=root.val;
        pathNodes.add(root.val);

        if(pathSum==targetSum && root.left == null && root.right == null){
            result.add(new ArrayList<>(pathNodes));

        }

        dfs(root.left,pathNodes,result,targetSum,pathSum);
        dfs(root.right,pathNodes,result,targetSum,pathSum);

        //remove the node once we are done processing all its subtrees.
        pathNodes.remove(pathNodes.size()-1);

    }
}
