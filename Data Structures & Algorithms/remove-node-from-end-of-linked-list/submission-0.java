/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int findLength (ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = findLength(head);
        int indexDelete = length - n + 1;
        int i = 1;
        if(indexDelete == 1) return head.next;

        ListNode node = head;
        while(i<indexDelete-1){
            node = node.next;
            i++;
        }

        node.next = node.next.next;
        return head;
    }
}
