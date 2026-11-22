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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1){
            head = null;
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = head;
        for(int i = 1; i<=n; i++){
            forward = forward.next;
        }
        while(forward != null){
            forward = forward.next;
            prev = curr;
            curr = curr.next;
        }
        if(prev == null){
            head = head.next;
            return head;
        }
        prev.next = curr.next;

        return head;
    }
}