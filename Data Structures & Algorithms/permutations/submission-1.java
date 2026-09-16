class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), ret);
        return ret;
    }

    public void dfs(int[]nums, boolean[]used, List<Integer> permutation, List<List<Integer>> ret){
        //base case
        if(permutation.size() == nums.length){
            ret.add(new ArrayList<>(permutation)); //MUST make a copy of permutation
        }

        //each recursion needs to go through each value in nums
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){ //iterate through nums until a value that hasn't been used yet is found
                permutation.add(nums[i]);
                used[i] = true;
                dfs(nums, used, permutation, ret); 
                //back tracking after each level of recursion
                permutation.remove(permutation.size() -1);
                used[i] = false;
            }
        }
    } 

}
