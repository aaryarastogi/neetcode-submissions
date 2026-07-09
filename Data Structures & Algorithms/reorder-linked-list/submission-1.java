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
    public ListNode reverseLL(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
    
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNode = slow.next;
        slow.next = null;

        ListNode reverselinkedlist = reverseLL(midNode);
        slow = head;

        while(slow != null && reverselinkedlist != null){
            ListNode nextNode = slow.next;
            ListNode nextRev = reverselinkedlist.next;

            slow.next = reverselinkedlist;
            reverselinkedlist.next = nextNode;

            slow = nextNode;
            reverselinkedlist = nextRev;
        }
    }
}
