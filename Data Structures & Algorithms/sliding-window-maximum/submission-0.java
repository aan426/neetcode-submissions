class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //nums.length - k + 1
        if(nums.length < k){
            return new int[]{};
        }

        //freq map of elements in window
        Deque<Integer> decMonotonic = new LinkedList<>(); //alwasy the indicies
        int[] maxArr = new int[nums.length - k + 1];
        int counter = 0;
        int upper = 0;
        int lower = 0;

        while(upper < nums.length){
            while(decMonotonic.size() != 0 && nums[upper] > nums[decMonotonic.peekLast()]){
                    decMonotonic.removeLast();
                }
                decMonotonic.add(upper);
            if(upper - lower + 1 >= k){ //outside window
                maxArr[counter] = nums[decMonotonic.peekFirst()];
                counter++;
                if(decMonotonic.peekFirst() <= lower){
                    decMonotonic.removeFirst();
                }  
                lower++;            
            }
            upper++;
        }

        return maxArr;

    }
}
