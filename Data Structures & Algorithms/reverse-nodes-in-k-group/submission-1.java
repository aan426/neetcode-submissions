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
    public ListNode reverseKGroup(ListNode head, int k) {
        //reversing list == reversing pointers of nodes
        ListNode dummy = new ListNode(); //reset this every k iterations so that when you add to this and remaing < k, you don't add dummy.next to the actual list
        ListNode dummyPt = dummy;

        ListNode headPt = head;
        ListNode headPt1 = head;
        ListNode kStartPt = head;
        // ListNode prev = dummy;
        ListNode prev = null;
        // prev.next = headPt;
        int counter = 0;
        // while(headPt!= null && counter <= k){
        while(headPt!= null){
            // System.out.println(headPt.val);
            // System.out.println(counter + " counter");
            // if(headPt.val == 4){
            //     return kStartPt;
            // }
            ListNode next = headPt.next;
            headPt.next = prev;
            prev = headPt;
            headPt = next;
            counter++;
            if(counter == k){
                // dummyPt.next = prev;
                // headPt = prev.next;
                // System.out.println(kStartPt.val + " " + headPt.val);
                dummyPt.next = prev;
                dummyPt = kStartPt;
                prev = null;
                kStartPt.next = headPt;
                kStartPt = kStartPt.next;
                // counter++;
                // dummyPt = prev;
                counter = 0;
            }
            
        }

        // System.out.println(kStartPt.val);
        // System.out.println(prev.val);
        // if(counter % k == 0){
        //     kStartPt.next = prev;
        // }
        // else{
            headPt = prev;
            prev = null;
            while(counter != 0){
                ListNode next = headPt.next;
                headPt.next = prev;
                prev = headPt;
                headPt = next;
                counter--;
            }

        // }


        // if(counter % k == 0){
            
        // }

        // kStartPt.next = headPt;


        // return prev;
        return dummy.next;
        // return kStartPt;

    }
}
