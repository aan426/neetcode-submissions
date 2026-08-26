class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> totalSets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>(); // empty subset is still a subset
        int i = 0;
        totalSets = dfs(i, nums, subset, totalSets);
        return totalSets;
    }

    private List<List<Integer>> dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> totalSets){
        if(i >= nums.length){ //base case, we've reached the end of the array
            totalSets.add(new ArrayList<>(subset)); //copy bc subset is mutable
            return totalSets;
        }

        //left branch --> add nums[i]
        subset.add(nums[i]);
        dfs(i+1, nums, subset, totalSets);

        //right branch --> don't add nums[i]
        subset.remove(subset.size() -1); //remove last element added which was current nums[i] because we've already done the recursion with it
        dfs(i+1, nums, subset, totalSets);
        return totalSets;
    }
}
