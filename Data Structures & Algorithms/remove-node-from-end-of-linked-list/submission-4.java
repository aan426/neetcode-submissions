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
        ListNode currNode = head;
        int count = 1;
        ListNode prevNode = null;

        //reverse first
        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        //prevNode is now the head of the reversed list
        ListNode reversedHead = prevNode;
        ListNode headPt = prevNode;
        prevNode = null;
        while (count < n){
            prevNode = headPt;
            headPt = headPt.next;
            count ++;
        }
        // System.out.println(prevNode.val);
        if(prevNode == null){
            reversedHead = headPt.next; //new head of reversed list
        }
        else{
            prevNode.next = headPt.next;
            headPt = prevNode;
        }

        //unreverse reverse first
        currNode = reversedHead;
        prevNode = null;

        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        return prevNode;
    }
}
