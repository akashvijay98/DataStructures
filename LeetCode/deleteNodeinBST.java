class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root,key);
    }
    public TreeNode dfs(TreeNode root,int key){
        if(root==null){
            return null;
        }
        if(root.val == key){

            if(root.right==null && root.left!=null){
                return root.left;
            }
            else if(root.right!=null && root.left==null){
                return root.right;
            }

            else if(root.right != null && root.left!=null){
                TreeNode cur  = root.right;
                while(cur.left!=null){
                    cur = cur.left;

                }
                cur.left = root.left;
                root.left=null;
                return root.right;
            }
            else if(root.left==null && root.right==null){
                return null;
            }
        }
        root.left=dfs(root.left,key);
        root.right=dfs(root.right,key);

        return root;

    } 
}
