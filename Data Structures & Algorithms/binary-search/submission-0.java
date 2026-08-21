class Solution {
    public int search(int[] nums, int target) {
        int lower = 0;
        int upper = nums.length -1;
        while(lower <= upper){
            int median = (upper + lower) / 2;
            if(nums[median] == target){
                return median;
            }
            else if(nums[median] < target){
                lower = median + 1;
            }
            else{
                upper = median -1;
            }
        }
        return -1;
    }
}
