/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperS(root, sb);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return helperD(list);
    }

    private void helperS(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null").append(',');
            return;
        }

        sb.append(root.val).append(',');

        helperS(root.left,sb);
        helperS(root.right, sb);
    }

    private TreeNode helperD(List<String> list){

        if(list.get(0).equals("null")){
            list.remove(0);

            return null;
        }        
        
        TreeNode root = new TreeNode(Integer.parseInt(list.remove(0)));

        root.left = helperD(list);
        root.right = helperD(list);

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
