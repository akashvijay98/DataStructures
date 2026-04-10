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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Node> q= new LinkedList<>();

        q.add(new Node(root,0,0));

        while(!q.isEmpty()){
            Node node = q.poll();

            int r = node.row;
            int c = node.col;
            TreeNode tNode = node.node;
            int val = tNode.val;

            map.computeIfAbsent(c, k-> new TreeMap<Integer, PriorityQueue<Integer>>())
            .computeIfAbsent(r, k-> new PriorityQueue<Integer>())
            .add(val);

            if(tNode.left!=null){
                q.add(new Node(tNode.left, r+1, c-1));

            }

            if(tNode.right!=null){
                q.add(new Node(tNode.right,r+1, c+1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> rowMap : map.values()){
            List<Integer> colList = new ArrayList<>();
            for(PriorityQueue<Integer> pq : rowMap.values() ){
                while(!pq.isEmpty()){
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;

    }

    class Node{
        TreeNode node;
        int row;
        int col;

        public Node(TreeNode node, int row, int col){
            this.node= node;
            this.row=row;
            this.col = col;
        }
    }
}
