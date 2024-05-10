/* 
Approach:
  we know in bst, the left node is the smallest, then comes the root which is greater than left, then comes right which is greater than root.
    left < root < right

    1. so we first recusrively call left. 
    2. for the root we increase the count by 1.
    3. then we recursevely call the right.

    if k == 1?
    recursively call dfs(root.left)
    once the leftmost node is reached, the next dfs(root.left) call will return null;

    then the present node(leftmost) will increase the count by 1.
    since the count is equals k (k=1), the left most node will be returned.
    
*/





class Solution {
    int count = 0;
    int node =0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return node;
    }
    public void dfs(TreeNode root, int k){
        if(root == null){
            return ;
        }
       
        dfs(root.left,k);
        count+=1;
         if(count==k){
            node = root.val;
        }
        dfs(root.right,k);
        
    }
}
