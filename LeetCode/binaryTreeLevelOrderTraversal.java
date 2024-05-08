/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */




/*  
The approach is pretty straight forward:
    first we append the root to the queue.
    
    then until the que is empty
        
        //inside the while loop
        1. We first count the length of the que (this will be 1 initially q=[root])
            the length of the que will be the number of children of the root.
        2. we run a for loop in range the length of the que.

            // inside the for loop
            3. we deque an element from the que, then check if it has subNodes(left , right) and enque if any.
            4.then we add the dequed element to a temporary array.
        
        //outside the for loop
        5. when the for loop ends, then we add this temp array to the final list.
    
     suppose the root has two children, then the length of queue will be 2.
     hence the for loop will execute two times.
*/



class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        Deque<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

         if(root ==null){
            return result;
        }
        
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> tempResult = new ArrayList<>();  
            int levels = q.size();

            for(int i =0;i<levels;i++){
                TreeNode x = q.remove();
            
                if(x.left!=null){
                    q.add(x.left);
                }
                if(x.right != null){
                    q.add(x.right);
                
                }
                tempResult.add(x.val);

            }

           result.add(tempResult);
            

        }

        return result;

    }
}
