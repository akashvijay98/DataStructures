/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        LinkedList<Node> queue = new LinkedList<>();
        HashMap<Node,Node> visited = new HashMap<>();

        queue.add(node);
        visited.put(node, new Node(node.val,new ArrayList()));

        while(!queue.isEmpty()){
            Node n = queue.remove();

            for(Node neighbor: n.neighbors){

                // if a node is already visited if means it was already removed from the queue
                // hence we dont add them to the queue again .
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val,new ArrayList()));
                    queue.add(neighbor);
                }

                // create an edge between the node and the neighbors
                visited.get(n).neighbors.add(visited.get(neighbor));


            }

        }

        return visited.get(node);
    }
}
