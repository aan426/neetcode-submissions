class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> check = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            int value = nums[i];
            if (check.contains(value)){
                return true;
            }

            check.add(value);
        }

        return false;
    }
}