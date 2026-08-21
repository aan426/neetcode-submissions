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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode firstList = lists[0];
        // System.out.println(firstList.val);

        for(int i = 1; i < lists.length; i++){    
            // System.out.println(lists[i].val);
            firstList = merge2Lists(firstList, lists[i]);
        }

        return firstList;
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode head = null;

        ListNode l1PT = l1;
        ListNode l2PT = l2;
        if(l1.val <= l2.val){
            head = l1PT;
            l1PT = l1PT.next;
        }
        else{
            head = l2PT;
            l2PT = l2PT.next;
        }

        ListNode headPt = head;
        ListNode retHeadPt = headPt;

        while(l1PT != null && l2PT != null){
            // System.out.println(l1PT.val + " " + l2PT.val);

            if(l1PT.val > l2PT.val){
                // ListNode next1 = headPt.next;
                headPt.next = l2PT;
                headPt = headPt.next;
                l2PT = l2PT.next;
            }
            else{
                headPt.next = l1PT;
                headPt = headPt.next;
                l1PT = l1PT.next;
            }
        }
        if(l2PT != null){
            headPt.next = l2PT;
        }
        else if(l1PT != null){
            headPt.next = l1PT;
        }

        return retHeadPt;
    }
}
