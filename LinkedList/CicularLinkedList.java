
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};


public class CircularLinkedList {
    // inserts the node at relevant position in the CLL
    public Node insert(Node head, int insertVal) {

        Node newNode = new Node(insertVal);

        // Case 1: Empty list
        if (head == null) {
            head = newNode;
            head.next = newNode;
            return head;
        }

        Node cur = head;

        // Case 2: Insert in correct position
        while (true) {
            // Insert value if it falls exactly between two nodes
            if (insertVal >= cur.val && insertVal <= cur.next.val) {
                break;
            }

            
            if (cur.val > cur.next.val) {
                // Insert at the start or end of the list
                //   if insertval is greater than curVal, insert at end
                //   if insertval is less than cur.next.val, insert at beginning (in CLL start and end are the same)
                if (insertVal >= cur.val || insertVal <= cur.next.val) {
                    break;
                }
            }

            cur = cur.next;

            // Case 3: All elements are the same or no valid position found after one loop
            if (cur == head) {
                break;
            }
        }

        // Insert new node between cur and cur.next
        Node next = cur.next;
        cur.next = newNode;
        newNode.next = next;

        return head;
    }

    // Utility method to print the circular linked list
    public void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node cur = head;
        do {
            System.out.print(cur.val + " ");
            cur = cur.next;
        } while (cur != head);
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        // Test Case 1: Insert into an empty list
        Node head = null;
        head = cll.insert(head, 1);
        cll.printList(head);  // Output: 1

        // Test Case 2: Insert into an existing list
        head = cll.insert(head, 3);
        head = cll.insert(head, 5);
        head = cll.insert(head, 2);
        cll.printList(head);  // Output: 1 2 3 5

        // Test Case 3: Insert at the end (wrap-around case)
        head = cll.insert(head, 6);
        cll.printList(head);  // Output: 1 2 3 5 6

        // Test Case 4: Insert at the beginning (wrap-around case)
        head = cll.insert(head, 0);
        cll.printList(head);  // Output: 0 1 2 3 5 6

        // Test Case 5: Insert duplicate value
        head = cll.insert(head, 3);
        cll.printList(head);  // Output: 0 1 2 3 3 5 6
    }
}
