/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while(slow!=null && fast!=null){
            if(slow==fast.next) return true;

            slow=slow.next;
            if(fast.next!=null)fast=fast.next.next;
        }

        return false;
    }
}