class Solution {
    public int findMin(int[] nums) {
        int lower = 0;
        int upper = nums.length -1;

        while(lower <= upper){
            //upper< lower
            //if lower < upper, min is lower
            if(lower == upper){
                return nums[lower];
            }
            int median = (upper + lower) / 2;
            if(nums[median] > nums[upper]){
                lower = median + 1;
            }
            else if(nums[median] < nums[upper]){
                upper = median;
            }

        }

        return lower;
    }
}
