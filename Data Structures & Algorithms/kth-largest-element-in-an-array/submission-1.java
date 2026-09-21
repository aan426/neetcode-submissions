class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: nums){
            maxHeap.add(num);
        }

        int counter = 0;
        int ret = 0;
        while(counter < k){
            ret = maxHeap.poll();
            counter++;
        }

        return ret;
    }
}
