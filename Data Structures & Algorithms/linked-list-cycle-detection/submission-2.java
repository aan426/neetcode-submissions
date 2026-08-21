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
    public boolean hasCycle(ListNode head) {
        //O(n) memory is using a hashset of the nodes
        //O(1) memory is using slow and fast pointers

        ListNode slow = head;
        ListNode fast = head;

        boolean loop = true;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            // System.out.println(slow.val + " " + fast.val);
            if(fast == null){
                return false;
            }
            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}
