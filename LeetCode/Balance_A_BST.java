package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Balance_A_BST {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
          TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    class Solution {
        List<Integer> nodeList = new ArrayList<>();
        public TreeNode balanceBST(TreeNode root) {

            if(root==null){
                return null;
            }
            inOrder(root);

            return constructBST(0,nodeList.size()-1);
        }

        public  void inOrder(TreeNode root){

            if(root == null){
                return;
            }

            inOrder(root.left);
            nodeList.add(root.val);
            inOrder(root.right);


        }

        public TreeNode constructBST(int lo, int hi){

            if(lo>hi){
                return null;
            }

            int mid= (lo+hi)/2;

            TreeNode root = new TreeNode(nodeList.get(mid));

            root.left= constructBST(lo,mid-1);
            root.right= constructBST(mid+1,hi);
            return root;
        }
    }
}
