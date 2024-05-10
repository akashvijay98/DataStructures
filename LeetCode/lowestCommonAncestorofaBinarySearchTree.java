/* 
if both p and q are less than root, that means they both exist in the left subtree. so wee keep traversing to the left until we find a common parent node.

if both p and q are greater than root, then they exist in the right subtree.

else they both exist in left and right subtrees or one is a parent node of the other. hence we just return the current root.
*/ 

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while(root!=null){
            if(p.val<root.val && q.val<root.val){
                root=root.left;
            }
            else if(p.val>root.val && q.val>root.val){
                root=root.right;
            }
            else{
                node = root;
                root=null;
            }

        }
        return node;
    }
}
