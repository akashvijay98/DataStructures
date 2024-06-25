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
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<Pair<TreeNode,Integer>> q = new LinkedList<>();

        int maxDiameter=Integer.MIN_VALUE;

        q.add(new Pair<> (root,0));

        while(q.size()>0){
            int curLevel = q.size();
            Pair<TreeNode,Integer> head = q.getFirst();
            Pair<TreeNode,Integer> elem = null;

            for(int i=0;i<curLevel;i++){
                elem = q.removeFirst();
                TreeNode node = elem.getKey();

                if(node.left != null){
                    q.addLast(new Pair<>(node.left,2*elem.getValue()));
                }
                if(node.right != null){
                    q.addLast(new Pair<>(node.right,2*elem.getValue()+1));
                }

            }
            maxDiameter = Math.max(maxDiameter, elem.getValue()-head.getValue()+1);
        }
        return maxDiameter;

    }
}
