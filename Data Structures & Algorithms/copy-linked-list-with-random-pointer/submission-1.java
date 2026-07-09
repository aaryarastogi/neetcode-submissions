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
    public Node copyRandomList(Node head) {
        Node curr = head;
        HashMap<Node,Node>copiedNode = new HashMap<>();

        while(curr != null){
            copiedNode.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            copiedNode.get(curr).next = copiedNode.get(curr.next);
            copiedNode.get(curr).random = copiedNode.get(curr.random);
            curr = curr.next;
        }

        return copiedNode.get(head);
    }
}
