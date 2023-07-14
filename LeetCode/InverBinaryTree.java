package LeetCode;

public class InverBinaryTree {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return root;
            }
            return bfs(root);

        }

    public TreeNode bfs(TreeNode root){
        if(root.left != null && root.right != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            bfs(root.left);
            bfs(root.right);
        }
        else if(root.left!=null && root.right==null){
            System.out.println(root.left.val);
            root.right = root.left;
            root.left = null;
            bfs(root.right);
        }
        else if(root.right!=null && root.left == null){
            root.left = root.right;
            root.right = null;
            bfs(root.left);
        }
        return root;
    }

}
