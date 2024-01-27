/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    Map<Node, Node> map;

    public Node createLL(Node head){

            if(head == null) return head;

            Node node = new Node(head.val);

            node.next = createLL(head.next);

            map.put(head, node);

            return node;

    }

    public Node copyRandomList(Node head) {

        map = new HashMap<>(); // old, new

        Node newhead = createLL(head);

        Node temp = newhead;

        while(temp != null){
            
            temp.random = map.get(head.random);
            temp = temp.next;
            head = head.next;
        }
        return newhead;
        
    }
}
