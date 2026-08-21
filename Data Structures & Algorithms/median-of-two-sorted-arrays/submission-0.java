class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //take the median of the medians --> add, divide by two
        if(nums1.length < nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int half = (nums1.length + nums2.length) / 2;
        int lower = -1;
        int upper = nums2.length - 1; //only want to binary search on the smaller array
        while(lower <= upper){
            int mid = (upper + lower) / 2; //getting the first part of the left side

            int leftGroup1 = half - mid - 2; //getting the index for the second part of the left side   

            //checking for valid partition
            // int 
            int nums1Left, nums1Right, nums2Left, nums2Right;

            nums2Left = (mid < 0) ? Integer.MIN_VALUE : nums2[mid];
            nums1Left = (leftGroup1 < 0) ? Integer.MIN_VALUE : nums1[leftGroup1];

            nums2Right = (mid + 1 >= nums2.length) ? Integer.MAX_VALUE : nums2[mid + 1];
            nums1Right = (leftGroup1 + 1 >= nums1.length) ? Integer.MAX_VALUE : nums1[leftGroup1 + 1];

            
            //good partition
            if(nums1Left <= nums2Right && nums1Right >= nums2Left){
                //odd
                if((nums2.length + nums1.length) % 2 != 0){
                    return Math.min(nums1Right, nums2Right);
                }
                else{
                    return (Math.max(nums1Left, nums2Left) + Math.min(nums1Right, nums2Right)) / 2.0;
                }
            }

            else if(nums1Left > nums2Right){ //need to reduce nums2 left window size
                lower = mid + 1;
            }
            else{
                upper = mid - 1;
            }

        }
        
        // int lower = 0;
        // int upper = nums1.length -1;

        // double median1 = (nums1[upper] + nums1[lower]) / 2.0;

        // int lower2 = 0;
        // int upper2 = nums2.length -1;

        // double median2 = (nums2[upper2] + nums2[lower2]) / 2.0;

        // double med = (median1 + median2) / 2.0;

        return -1;
    }
}
