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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode pt1 = list1;
        ListNode pt2 = list2;

        ListNode newHead = null; //always points to the first node
        if(pt1.val < pt2.val){
            newHead = pt1;
            pt1 = pt1.next;
        }
        else{
            newHead = pt2;
            pt2 = pt2.next;
        }
        ListNode headPt = newHead; //use a pointer to traverse newHead
        while(pt1 != null && pt2 != null){
            int val1 = pt1.val;
            int val2 = pt2.val;
            System.out.println(val1 + " " + val2);

            if(val1 < val2){
                // ListNode next1 = pt1.next;
                // pt1.next = pt2;
                headPt.next = pt1;
                headPt = headPt.next;
                pt1 = pt1.next;
            }
            else{
                // ListNode next2 = pt2.next;
                // pt2.next = pt1;
                headPt.next = pt2;
                headPt = headPt.next;
                pt2 = pt2.next;
            }
        }

        if(pt1 != null){
            headPt.next = pt1;
        }
        else if (pt2 != null){
            headPt.next = pt2;

        }

        return newHead;
    }
}