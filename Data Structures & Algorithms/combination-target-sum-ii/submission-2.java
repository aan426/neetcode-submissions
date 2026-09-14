class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> totalSets = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>(), totalSets, 0);
        return totalSets;
    }

    public void dfs(int i, int[] candidates, int target, List<Integer> subset, List<List<Integer>> totalSets, int currSum){
        if(currSum == target){ //needs to come first, otherwise when i == length, it tosses out a valid option on the last check
            totalSets.add(new ArrayList<>(subset));
            return;
        }


        if(i >= candidates.length || currSum > target){
            return;
        }

        //New:
            //need a way to make repeating values children, not siblings, of the previous repeated value so we want 
        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j-1]){ //there's a repeating value and we are at the second copy of it, we don't want to create another subset using that repeating value, but that value has already been processes / used by the previous value
                continue;
            }

            if(currSum + candidates[j] > target){
                break;
            }

            //leftside, add num[i]
            currSum += candidates[j];
            subset.add(candidates[j]);
            dfs(j+1, candidates, target, subset, totalSets, currSum);

            //don't need a "right side" because j is doing the choosing for us
            currSum -= candidates[j];
            subset.remove(subset.size() - 1);
        }        
    }
}
