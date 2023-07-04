package LeetCode;

import Trees.BinarySearchTree;


class BalancedBinaryTree {

    class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            left = null;
            right = null;
        }

    }
    public boolean isBalanced(Node root) {

        int result = dfs(root);

        if(result != -1){
            return true;
        }
        else{
            return false;
        }

    }

    public int dfs(Node root){
        if(root == null){
            return 0;
        }

        int lHeight= dfs(root.left);
        int rHeight = dfs(root.right);


        if(lHeight == -1){
            return -1;
        }

        if(rHeight == -1)
        {

            return -1;
        }

        if(Math.abs(lHeight-rHeight)>1){
            return -1;
        }

        return 1+Math.max(lHeight, rHeight);


    }



}