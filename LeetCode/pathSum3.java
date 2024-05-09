class Solution {
    int count =0;
    HashMap<Long, Integer> map = new HashMap<>();


    public int pathSum(TreeNode root, int targetSum) {
        pathHelper(root,0L,targetSum);

        return count;
    }

    public void pathHelper(TreeNode root, long runningSum, int target ){

        if(root == null){
            return ;
        }

        runningSum += root.val;

        if(runningSum == target){
            count+=1;
        }

        count += map.getOrDefault(runningSum-target,0);
       
        map.put(runningSum, map.getOrDefault(runningSum,0)+1);

        pathHelper(root.left,runningSum,target);
        pathHelper(root.right,runningSum,target);


        map.put(runningSum, map.get(runningSum)-1);

        
    }
}
