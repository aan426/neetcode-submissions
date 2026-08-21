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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode prev1 = null;
        ListNode prev2 = null;
        int carryOver = 0;

        while(head1 != null || head2 != null){
            if(head1 == null){
                head1 = new ListNode(0);
                prev1.next = head1;
                head1.next = null;
            }
            if(head2 == null){
                head2 = new ListNode(0);
                prev2.next = head2;
                head2.next = null;
            }
            int newVal = head1.val + head2.val;
            System.out.println(newVal);
            System.out.println(newVal % 10);
            System.out.println(newVal / 10);
            if(newVal > 9){
                head1.val = newVal % 10;
                if(head1.next == null){
                    ListNode newEnd = new ListNode(newVal / 10);
                    head1.next = newEnd;
                    prev1 = head1;
                    head1 = head1.next;
                }
                else{
                    prev1 = head1;
                    head1 = head1.next;
                    head1.val = head1.val + (newVal / 10);
                }
            }
            else{
                head1.val = newVal;
                System.out.println(head1.val);
                prev1 = head1;
                head1 = head1.next;
            }
            prev2 = head2;
            head2 = head2.next;
        }
        return l1;
        // ListNode head1 = l1;
        // ListNode prev1 = null;

        // while(head1 != null){
        //     ListNode nextNode = head1.next;
        //     head1.next = prev1;
        //     prev1 = head1;
        //     head1 = nextNode;
        // }

        // ListNode head2 = l2;
        // ListNode prev2 = null;

        // while(head2 != null){
        //     ListNode nextNode = head2.next;
        //     head2.next = prev2;
        //     prev2 = head2;
        //     head2 = nextNode;
        // }

        // ListNode combined = prev1;
        // while(prev1 != null && prev2 != null){
        //     int newVal = prev1.val + prev2.val;
        //     System.out.println(newVal);
        //     System.out.println(newVal % 10);
        //     System.out.println(newVal / 10);
        //     if(newVal > 9){
        //         prev1.val = newVal / 10;
        //         if(newVal % 10 > 0 && prev1.next == null){
        //             ListNode newEnd = new ListNode(newVal % 10);
        //             prev1.next = newEnd;
        //             prev1 = prev1.next;
        //         }
        //         else{
        //             prev1 = prev1.next;
        //             prev1.val = prev1.val + (newVal % 10);
        //         }
        //     }
        //     else{
        //         prev1.val = newVal;
        //         prev1 = prev1.next;
        //     }
            
        //     prev2 = prev2.next;
        // }

        // prev1 = null;
        // while(combined != null){
        //     ListNode nextNode = combined.next;
        //     combined.next = prev1;
        //     prev1 = combined;
        //     combined = nextNode;
        // }

        // return prev1;
    }
}
