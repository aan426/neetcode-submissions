class KthLargest{
    int[] nums; 
    int k;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public KthLargest(int[] nums, int k){
        this.nums = nums;
        this.k = k;
    }

    public int calcKthLargest(){
        for(int num: nums){
            maxHeap.add(num);
        }
        int count = 1;
        while(count < k){
            maxHeap.poll();
            count++;
        }
        return maxHeap.poll();
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        KthLargest kthLargest = new KthLargest(nums, k);
        return kthLargest.calcKthLargest();
    }
}
