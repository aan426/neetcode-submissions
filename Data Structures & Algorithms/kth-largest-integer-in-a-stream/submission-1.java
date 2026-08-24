class KthLargest {
    PriorityQueue<Integer> heap;
    int kTh;
    public KthLargest(int k, int[] nums) {
        kTh = k;
        //max heap verison
        // heap = new PriorityQueue<>(Collections.reverseOrder()); //automatically returns the smallest elements so we need to pass Collections to flip it
        
        //minheap verison
        heap = new PriorityQueue<>(); //we want minheap because we only want to keep all values kth and up everytime add is called --> we can get rid of the earlier ones because k never changes ==> we don't need to consider previously not kth largest values

        for(int i = 0; i < nums.length; i++){
            heap.offer(nums[i]);
        }
    }
    
    public int add(int val) {
    //Using Maxheap
    //     PriorityQueue<Integer> subHeap = new PriorityQueue<>(Collections.reverseOrder());
    //     heap.offer(val);
    //     int counter = 0;
    //     int retVal = 0;
    //     while(heap.size() != 0 && counter != kTh){
    //         int curr = heap.poll();
    //         retVal = curr;
    //         subHeap.offer(curr);
    //         counter++;
    //     }
    //     heap.addAll(subHeap);
    //     return retVal;
    // }

    //Using minheap
        heap.offer(val);
        while(heap.size() > kTh){
            heap.poll();
        }
        return heap.peek();
    }
}
