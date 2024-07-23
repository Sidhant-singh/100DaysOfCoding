/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
//     Using recursion
    public Node flatten(Node head) {
        Node temp = head;
        while(temp!=null){
            Node n = temp.next;
            if(temp.child!=null){
                Node c = flatten(temp.child);
                Node d = c;
                while(d.next!=null) d = d.next;
                temp.next = c;
                c.prev = temp;
                d.next = n;
                if(n!=null) n.prev = d;
                temp.child = null; //making all child null and making it into the single ll
            }
            temp = n;
        }
        return head;
    }
}