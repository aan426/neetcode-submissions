class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); //bc output can be in any order

        int i = 1;
        int j = nums.length - 1;
        int stable = 0;
        List<List<Integer>> retArr = new ArrayList<>();
        int count = 10;
        while(stable < nums.length-2){
        // while(count > 0){
            if (stable != 0 && nums[stable] == nums[stable-1]){
                stable++;
                i = stable + 1;
                j = nums.length - 1;
            }
            else if(i >= j){
                stable++;
                i = stable + 1;
                j = nums.length - 1;
            }
            else if(nums[stable] + nums[i] + nums[j] < 0){
                i++;
            }
            else if(nums[stable] + nums[i] + nums[j] > 0){
                j--;
            }
            else{
                List<Integer> found = new ArrayList<>();
                found.add(nums[stable]);
                found.add(nums[i]);
                found.add(nums[j]);
                System.out.println(nums[stable] + " " + nums[i] + " " + nums[j]);
                System.out.println(stable + " " + i + " " + j);
                
                retArr.add(found);
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) i++; //skip duplicate for i
                while (i < j && nums[j] == nums[j + 1]) j--; // skip duplicate for j
            }
            count--;
        }
        return retArr;
    }
}
