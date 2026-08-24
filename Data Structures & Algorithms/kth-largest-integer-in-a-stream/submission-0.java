class KthLargest {
    PriorityQueue<Integer> heap;
    int kTh;
    public KthLargest(int k, int[] nums) {
        kTh = k;
        heap = new PriorityQueue<>(Collections.reverseOrder()); //automatically returns the smallest elements so we need to pass Collections to flip it
        for(int i = 0; i < nums.length; i++){
            heap.offer(nums[i]);
        }
    }
    
    public int add(int val) {
        PriorityQueue<Integer> subHeap = new PriorityQueue<>(Collections.reverseOrder());
        heap.offer(val);
        int counter = 0;
        int retVal = 0;
        while(heap.size() != 0 && counter != kTh){
            int curr = heap.poll();
            retVal = curr;
            subHeap.offer(curr);
            counter++;
        }
        heap.addAll(subHeap);
        return retVal;
    }
}
