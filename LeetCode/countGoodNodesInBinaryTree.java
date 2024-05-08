class Solution {
    int count = 0;


    public int goodNodes(TreeNode root) {
        

        TreeNode mainRoot = root;


        if(root==null){
            return 0;
        }

        return dfs(root,root.val);
    }

    public int dfs(TreeNode root, int maxVal){
           if(root==null){
            return 0;
        }

        if(root.val >= maxVal){
            count+=1;
            maxVal = root.val;
        }
        dfs(root.left,maxVal);
        dfs(root.right, maxVal);
        return count;

    }

}
