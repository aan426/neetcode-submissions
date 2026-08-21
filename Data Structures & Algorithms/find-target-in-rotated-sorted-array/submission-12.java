class Solution {
    public int search(int[] nums, int target) {
        int minIndex = -1;
        //first find the min, then look for the window

        //less than equal to upper --> right sorted group
        //or greater than equal to lower --> left sorted group

        //mid is in right sorted group if nums[mid] < nums[upper];
        //mid is in left sorted group if nums[mid] > nums[lower];

        int lower = 0;
        int upper = nums.length -1;

        while(lower <= upper){
            int median = (upper + lower) / 2;
            if(lower == upper){
                minIndex = lower;
                break;
            }
            if(nums[median] > nums[upper]){
                lower = median + 1;
            }
            else if(nums[median] < nums[upper]){
                upper = median;
            }
        }
        // return minIndex;
        if(nums[minIndex] == target){
            return minIndex;
        }
        else if(target <= nums[nums.length -1]){ //left group
            lower = minIndex;
            upper = nums.length - 1;
        }
        else{ //right group
            upper = minIndex - 1;
            lower = 0;
        }
        while(lower <= upper){
            int median = (upper + lower) / 2;
            if(nums[median] == target){
                return median;
            }
            if(nums[lower] == target){
                return lower;
            }
            if(nums[upper] == target){
                return upper;
            }

            if(target < nums[median]){
                upper = median - 1;
            }
            else{
                lower = median + 1;
            }
            
        }

        return -1;
    }
}
