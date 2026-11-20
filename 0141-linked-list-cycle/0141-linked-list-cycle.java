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
        // ListNode slow = head;
        // ListNode fast = head;
        // while(fast != null){
        //     fast = fast.next;
        //     if(fast != null){
        //         fast = fast.next;
        //         slow = slow.next;
        //     }
        //     if(fast == slow) return true;
        // }
        // return false;
        HashSet<ListNode> map = new HashSet<>();
        ListNode temp = head;
        while(temp != null){
            if(map.contains(temp)) return true;
            map.add(temp);
            temp = temp.next;
        }
        return false;
    }
}