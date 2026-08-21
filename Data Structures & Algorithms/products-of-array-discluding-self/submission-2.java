class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProd = 1;
        int[] output = new int[nums.length];
        Map<Integer, Integer> zeros = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 && zeros.size() <=2 ){
                zeros.put(i, nums[i]);
                if (zeros.size() == 2){
                    totalProd = 0;
                }
            }
            else{
                totalProd *= nums[i];
            }
            
        }

        for(int i = 0; i < nums.length; i++){
            if(zeros.size() >= 2){
                output[i] = 0;
            }
            else{
                if(zeros.size() == 1){
                    if(nums[i] == 0){
                        output[i] = totalProd;
                    }
                    else{
                        output[i] = 0;
                    }
                }
                else {
                    output[i] = totalProd / nums[i];
                }
            }
        }

        return output;
    }
}  
