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
    public ListNode reverseList(ListNode head) {
        // head.next; //1
        // head.next.next; //2
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = null;
        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        // currNode.next = null;
        // last.next = head;
        // if(head.next != null){
        //     last = head.next.next;
        //     reverseList(head.next);
        // }
        // System.out.println(last.val);
        return prevNode;
    }
}
