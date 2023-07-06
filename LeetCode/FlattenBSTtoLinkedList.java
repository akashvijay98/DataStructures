package LeetCode;

public class FlattenBSTtoLinkedList {

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


        public void flatten(TreeNode root) {
            dfs(root);

        }

        public void dfs(TreeNode root){

            if(root == null){
                return;
            }

            dfs(root.left);

            if( root.left != null){
                TreeNode right = root.right;
                root.right = root.left;
                root.left=null;

                TreeNode cur = root.right;
                while(cur.right != null){
                    cur = cur.right;
                }
                cur.right=right;
            }
            dfs(root.right);





        }
}

