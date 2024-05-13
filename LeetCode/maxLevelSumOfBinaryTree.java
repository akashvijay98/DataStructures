class Solution {
    int ans=0;
    int maxSum=Integer.MIN_VALUE;
    int level=0;
    List<Integer> tempList = new ArrayList<>();
    Deque<TreeNode> q  = new ArrayDeque<>();

    public int maxLevelSum(TreeNode root) {

        if(root==null){
            return level;
        }

        q.add(root);
        while(! q.isEmpty()){
            
            int currentSum=0;

            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode item = q.poll();
                currentSum+=item.val;

                if(item.left != null){
                    q.addLast(item.left);
                }
                if(item.right != null){
                    q.addLast(item.right);
                }
            }
            level+=1;
            if(currentSum>maxSum){
                maxSum=currentSum;
                ans=level;
                
            }

        }
        return ans;
    }
}
