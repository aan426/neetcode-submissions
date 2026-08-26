class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> totalCombos = new ArrayList<>();
        dfs(0, nums, target, new ArrayList<>(), totalCombos,0);
        return totalCombos;
    }

    private void dfs(int i, int[] nums, int target, List<Integer> subset, List<List<Integer>> totalCombos, int currSum){
        if(currSum > target || i >= nums.length){
            return;
        }

        if(currSum == target){
            totalCombos.add(new ArrayList<>(subset));
            return;
        }


        //left branch adds currnet value repeatidly
        currSum += nums[i];
        subset.add(nums[i]);
        dfs(i, nums, target, subset, totalCombos, currSum);

        //right branch never re-adds nums[i] into the equation
        currSum -= nums[i];
        subset.remove(subset.size() -1);
        dfs(i+1, nums, target, subset, totalCombos, currSum);

        // return totalCombos;//totalCombos is mutable from the parent function
    }

}
