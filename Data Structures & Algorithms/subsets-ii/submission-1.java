class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, new ArrayList<>(), ret);
        return ret;
    }
    public void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> ret){
        // if(i >= nums.length){// we don't need this base case anymore because we want [], [1], [2] etc to be in the subset
        ret.add(new ArrayList<>(subset)); //--> every recursion is a subset because we start with [], then the loop starts i = 0 and subset is now [1], then we save that too, then i = 1 and subset becomes [1,1]


        for(int j = i; j < nums.length; j++){ //set j = i so we don't restart from the beginning each time
            if(j > i && nums[j] == nums[j - 1]){
                continue;
            }
            subset.add(nums[j]);
            dfs(j+1, nums, subset, ret); //this is what creates the new branch, so our if statement catches duplicates and skips them from starting as a new branch
            subset.remove(subset.size() -1); //we've done all the combinations with all values up to and including the current value, so now we need to find all the combos without this value --> remove from subset and loop increments j
        }

    }
}
