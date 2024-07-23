// Definition for a Node.
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }

class Solution {
    public Node deepCopy(Node head) {
        if (head == null) return null;

        // Step 1: Create a deep copy of the linked list without random connections
        Node head2 = new Node(head.val);
        Node t1 = head.next;
        Node t2 = head2;
        while (t1 != null) {
            Node temp = new Node(t1.val);
            t2.next = temp;
            t2 = t2.next;
            t1 = t1.next;
        }
        return head2;
    }

    public void connectAlternate(Node head, Node head2) {
        if (head == null || head2 == null) return;

        Node dummy = new Node(-1);
        Node t = dummy;
        Node temp1 = head;
        Node temp2 = head2;
        while (temp1 != null && temp2 != null) {
            t.next = temp1;
            temp1 = temp1.next;
            t = t.next;

            t.next = temp2;
            temp2 = temp2.next;
            t = t.next;
        }
    }

    public void split(Node head, Node head2) {
        if (head == null || head2 == null) return;

        Node t1 = head;
        Node t2 = head2;
        while (t1 != null) {
            t1.next = t2.next;
            t1 = t1.next;
            if (t1 == null) break;
            t2.next = t1.next;
            t2 = t2.next;
        }
    }

    public void assignRandom(Node head, Node head2) {
        Node t1 = head;
        Node t2 = head2;
        while (t1 != null) {
            t2 = t1.next;
            if(t1.random!=null) t2.random = t1.random.next;
            t1 = t1.next.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create a deep copy of the linked list without random connections
        Node head2 = deepCopy(head);

        // Step 2: Join the nodes head and head2 alternately
        connectAlternate(head, head2);

        // Step 3: Assign random pointers
        assignRandom(head, head2);

        // Step 4: Split the linked list
        split(head, head2);

        return head2;
    }
}
