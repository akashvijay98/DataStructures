package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBST {


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



        public List<List<Integer>> levelOrder(TreeNode root) {

            Queue<TreeNode> q = new LinkedList<>();
            List<List<Integer>> finalList = new ArrayList<List<Integer>>();
            if(root==null){
                return finalList;
            }
            q.add(root);

            while(!q.isEmpty()){
                List<Integer> tempList = new ArrayList<>();
                int size = q.size();
                for(int i=0;i<size;i++){
                    TreeNode item = q.remove();
                    if(item.left!=null){
                        q.add(item.left);

                    }
                    if(item.right!=null){
                        q.add(item.right);
                    }
                    tempList.add(item.val);
                }
                finalList.add(tempList);

            }
            return finalList;


        }



}
