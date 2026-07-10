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
    public ListNode reverseLL(ListNode node){
        ListNode curr = node;
        ListNode prev = null;

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public ListNode findKthNode(ListNode curr, int k){
        k-=1;
        while(k>0 && curr!= null){
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode kthNode = null;
        ListNode prevGroupEnd = null;

        while(curr != null){
            kthNode = findKthNode(curr,k);
            if(kthNode == null){
                if(prevGroupEnd != null){
                    prevGroupEnd.next = curr;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            ListNode revList = reverseLL(curr);

            if(head == curr){
                head = kthNode;
            }
            else{
                prevGroupEnd.next = kthNode;
            }

            prevGroupEnd = curr;
            curr = nextNode;
        }

        return head;
    }
}
