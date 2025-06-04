/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/


/*
    Approach is similar to flatten bst to linkedlist.

    During traversal:
    1. We maintain a 'prev' pointer to the previously visited node.
    2. For each node visited:
        - If 'prev' is not null, link 'prev.right' to the current node,
            and 'current.left' back to 'prev'.
        - If 'prev' is null, we're at the leftmost (smallest) node, so we store it
            as the 'head' of the doubly linked list.
    3. After traversal, we complete the circularity by connecting:
        - 'head.left' to 'prev' (the last node visited).
        - 'prev.right' to 'head'.

    Time Complexity: O(n), where n is the number of nodes in the BST.
    Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
*/
class Solution {
   
    Node prev = null;

    Node head=null;

    Node leastNode = null;
    public Node treeToDoublyList(Node root) {
        
        if(root==null){
            return null;
        }

        inorder(root);
        
        head.left = prev;
        prev.right=head;

        return head;
    }


    // indorder
    private void inorder(Node root){
        if(root==null){
            return;
        }
    
       
       inorder(root.left);
    
        if(prev != null){
            prev.right = root;
            root.left = prev;
        }
        else{
            head=root;
        }
        
            prev = root;
    
     

        inorder(root.right);
    }

    
}
