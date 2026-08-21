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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2Pt = slow.next;
        ListNode headPt = head;

        slow.next = null;


        ListNode prevNode = null;
        while(head2Pt != null){
                System.out.println(head2Pt.val);

                ListNode nextNode = head2Pt.next;
                head2Pt.next = prevNode;
                prevNode = head2Pt;
                head2Pt = nextNode;           
        }

        // System.out.println(prevNode.val);

        while(prevNode != null && headPt != null){
            ListNode headPtNext = headPt.next;
            headPt.next = prevNode;
            ListNode prevNodeNext = prevNode.next;
            prevNode.next = headPtNext;
            headPt = headPtNext;
            prevNode = prevNodeNext;
        }

    }
}
