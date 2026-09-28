class MedianFinder {
    PriorityQueue<Integer> minHeap; //holds the larger elements
    PriorityQueue<Integer> maxHeap; //holds the smaller elements
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);

        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){ //if the largest element of the smaller side is greater than the smallest element of the larger side, we move the newly added element over to minheap
            minHeap.offer(maxHeap.poll());
        }
        
        if(minHeap.size() > maxHeap.size()){ // we want the smaller element size to always be larger or equal to maxHeap size
            maxHeap.offer(minHeap.poll());
        }

        if(maxHeap.size() > minHeap.size() + 1){ //but never larger than one greater than min heap
            minHeap.offer(maxHeap.poll());

        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
