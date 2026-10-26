class ThreeSum{
    int[] nums;
    List<List<Integer>> allTriplets;
    public ThreeSum(int[] nums){
        this.nums = nums;
        allTriplets = new ArrayList<>();
    }

    public List<List<Integer>> calcThreeSumIndicies(){
        Arrays.sort(nums);
        int curr = 0;
        int lower = 1;
        int upper = nums.length - 1;
        // System.out.println(curr);
        int count = 0;

        //loop through nums
        //if curr + lower + upper < target --> lower ++
        //if curr + lower + upper > target -> upper --
        //if curr + lower + upper != target && lower >= upper, curr++
        //duplicates: if curr - 1 > 0 && nums[curr] == nums[curr -1] skip curr
        while(curr < nums.length - 2){
        // while(count < 10){
            // System.out.println(curr);
            if(curr > 0 && nums[curr] == nums[curr -1]){ //duplicates
                curr++;
            }
            else{
                lower = curr + 1;
                upper = nums.length -1;
                while(lower < upper){
                    int currVal = nums[curr] + nums[lower] + nums[upper];
                    // System.out.println("what");
                    if(currVal == 0){
                        // System.out.println("triplets");
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[curr]);
                        triplet.add(nums[lower]);
                        triplet.add(nums[upper]);
                        allTriplets.add(triplet);
                        lower++;
                        upper--;

                        // Skip duplicate lower values
                        while (lower < upper && nums[lower] == nums[lower - 1]) {
                            lower++;
                        }
                        // Skip duplicate upper values
                        while (lower < upper && nums[upper] == nums[upper + 1]) {
                            upper--;
                        }
                    }
                    else if (currVal < 0){
                        lower++;
                    }
                    else if (currVal > 0){
                        upper--;
                    }
                    else{
                        // System.out.println("here");
                        curr++;
                        lower = curr + 1;
                        upper = nums.length - 1;
                    }
                }
                curr++;   
            }
        }

        return allTriplets;
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ThreeSum object = new ThreeSum(nums);
        return object.calcThreeSumIndicies();
    }
}
