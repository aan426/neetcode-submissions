class Solution {
    public int longestConsecutive(int[] nums) {
         //the difference between 2 and 20 is larger than the size of the array --> can't be in the same group / set
        //nums.length - current index > abs|2-4| so they could be in the same set
        //keep track of min and max values for each set to compare to closest value
        //then go through each set, sort to ensure that each value is exactly one greater --> keep track of subgroups

        Set<Integer> allNums = new HashSet<>();

        for(int num: nums){
            allNums.add(num);
        }
        int counter = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            if(!allNums.contains(nums[i] - 1)){
                counter = 0;
                while(allNums.contains(nums[i] + counter)){
                    counter++;
                }
                maxLen = Math.max(counter, maxLen);
            }
        }
        return maxLen;
    }
}
