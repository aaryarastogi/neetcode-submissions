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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        int carry = 0;
        while(l1 != null || l2 != null){
            int sum=0;
            sum += (l1 == null) ? 0 : l1.val;
            sum += (l2 == null) ? 0 : l2.val;
            if(l1 != null) l1=l1.next;
            if(l2 != null) l2 = l2.next;
            sum += carry;

            ans.next = new ListNode(sum%10);
            ans=ans.next;
            carry = sum/10;
        }
        if(carry != 0) ans.next = new ListNode(carry);

        return dummy.next;
    }
}
