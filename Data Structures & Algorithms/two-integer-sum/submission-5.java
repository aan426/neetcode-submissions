class TwoSum{
    int[] nums;
    int target;
    int pair2Index;
    Map<Integer, Integer> seen; //<nums[i], i>

    public TwoSum(int[] nums, int target){
        this.nums = nums;
        this.target = target;
        pair2Index = -1;
        seen = new HashMap<>();
    }

    public int[] findPair(){
        for(int i = 0; i < nums.length; i++){
            if(pairValExists(nums[i])){ //check for pair first
                int pair2Index = getPairIndex(nums[i]);
                return new int[] {pair2Index, i}; //pair2Index is going to be smaller because it's an index we've already seen
            }
            seen.put(nums[i], i); //add curr ith vals if pair dne
        }
        return null;
    }

    private boolean pairValExists(int pair1Val){
        return seen.containsKey(target - pair1Val) ? true:false;
    }

    private int getPairIndex(int pair1Val){
        return seen.get(target - pair1Val);
    }

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        TwoSum pairs = new TwoSum(nums, target);
        return pairs.findPair();
    }
}
