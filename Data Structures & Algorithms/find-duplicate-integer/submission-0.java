class Solution {
    public int findDuplicate(int[] nums) {
        //this is a linked list cycle problem that needs Floyd's algo to find the beginning of the cycle
        //think of the values in the nums ARRAY is an index to the node (repeating values create a cycle ) 
        //floyd's algo --> fast and slow pointer until they intersect, then ignore fast pointer and start another slow pointer at the head of the list and run until the two slow pointers meet

        int slow1 = 0;
        int slow2 = 0;
        int fast = 0;
        do{
            slow1 = nums[slow1];
            fast = nums[fast];
            fast = nums[fast];
        }while(slow1 != fast);

        do{
            slow1 = nums[slow1];
            slow2 = nums[slow2];
        }while(slow1 != slow2);

        return slow1;
    }
}
