class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numSet = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int key = i;
            int value = nums[i];

            numSet.put(key, value);
        }

        int value = -1;
        int valueIndex = -1;
        int diff = -1;
        for(int i = 0; i < nums.length; i++){
            value = nums[i];
            valueIndex = i;
            diff = target - value;

            numSet.remove(valueIndex, value);

            if(numSet.containsValue(diff)){
                break;
            }

            numSet.put(valueIndex, value);
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == diff && i != valueIndex){
                return new int[] {valueIndex, i};
            }
        }

        return new int[] {0,0};

    }
}
