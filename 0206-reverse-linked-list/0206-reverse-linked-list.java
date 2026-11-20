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
    static ListNode solve(ListNode prevNode, ListNode currNode){
        if(currNode == null){
            return prevNode;
        }
        ListNode nextNode = currNode.next;
        currNode.next = prevNode;

        prevNode = currNode;
        currNode = nextNode;
        
        return solve(prevNode,currNode);
    }
    public ListNode reverseList(ListNode head) {
        

        ListNode prevNode = null;
        ListNode currNode = head;
        

        // while(currNode != null){
        //     ListNode nextNode = currNode.next;

        //     currNode.next = prevNode;

        //     prevNode = currNode;
        //     currNode = nextNode;
        // }


        return solve(prevNode, currNode);
    }
}