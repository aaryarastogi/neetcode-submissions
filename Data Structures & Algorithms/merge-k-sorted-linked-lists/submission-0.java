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
    public ListNode mergeList(ListNode list1, ListNode list2){
        ListNode ans = new ListNode(-1001);
        ListNode dummy = ans;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ans.next = list1;
                list1 = list1.next;
                ans=ans.next;
            }
            else{
                ans.next = list2;
                list2 = list2.next;
                ans = ans.next;
            }
        }
        if(list1 != null) ans.next = list1;
        if(list2 != null) ans.next = list2;
        
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        ListNode ans = lists[0];
        for(int i=1;i<lists.length;i++){
            ListNode list1 = lists[i];
            ans = mergeList(ans,list1);
        }

        return ans;
    }
}
