package Trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    public void insert(int data){
        if(root == null){
            root = new Node(data);
        }
        else {
            dfs(root, data);
        }
    }

    public void dfs(Node root, int data){


        if(data < root.val){
          if(root.left!=null){
              dfs(root.left,data);
          }

          else {
              System.out.println("left side and  paren"+root.val);
              Node newNode = new Node(data);
              root.left = newNode;
          }
        }
        else if(data > root.val) {

            if (root.right != null) {
                dfs(root.right, data);
            } else {
                System.out.println("right side and  paren"+root.val);

                Node newNode = new Node(data);
                root.right = newNode;
            }
        }
        else {
            System.out.println("value exists");
        }

    }

    public List<Integer> inOrder(){
       List<Integer> dataList = new ArrayList<Integer>();

       if(root == null){
           return dataList;
       }

       List<Integer> result = inOrderHelper(root, dataList);
       return result;
    }

    public List<Integer> inOrderHelper(Node root, List<Integer> list){
        if(root == null){
            return null;
        }
        inOrderHelper(root.left, list);
        list.add(root.val);
        inOrderHelper(root.right, list);

        return list;


    }



    public static void main(String[] args){

        BinarySearchTree bs = new BinarySearchTree();
        bs.insert(8);
        bs.insert(3);
        bs.insert(1);
        bs.insert(6);
        bs.insert(12);
        bs.insert(10);
        System.out.println(bs.inOrder());


    }

}

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

