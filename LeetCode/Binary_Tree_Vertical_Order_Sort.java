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
    public List<List<Integer>> verticalOrder(TreeNode root) {

        // TreeMap to map column with Node value and store the pair in sorted order by column. 
        Map<Integer,List<Integer>> map = new TreeMap<>();
        Queue<Pair<Integer,TreeNode>> q = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        q.add(new Pair(0,root));

        while(!q.isEmpty()){
            Pair<Integer,TreeNode> item = q.poll();

            Integer col = item.getKey();
            TreeNode node = item.getValue();

            // map column to the node value in TreeMap
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            if(node.left!=null){
                q.add(new Pair(col-1,node.left));
            } 
            if(node.right!=null){
                q.add(new Pair(col+1, node.right));
            }

        }

        // iterate the columns in TreeMap by ascending order
        // add the mapped node values List to result List where index = col
        for(Integer col : map.keySet()){
            result.add(map.get(col));
        }
        return result;
    }
}
