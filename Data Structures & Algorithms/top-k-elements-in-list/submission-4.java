class TopKFreq{
    int[] nums;
    int k;
    Map<Integer, Integer> freqMap;
    PriorityQueue<int[]> minHeap;
    public TopKFreq(int[] nums, int k){
        this.nums = nums;
        this.k = k;
        freqMap = new HashMap<>();
        minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
    }

    public int[] main(){
        countFreqofNums();
        return getTopKMostFreq();
    }

    private void countFreqofNums(){
        for(int num: nums){
            addToFreqCount(num);
        }
    }

    private void addToFreqCount(int num){
        int numFreqCount = freqMap.getOrDefault(num, 0) + 1;
        freqMap.put(num, numFreqCount);
    }

    private int[] getTopKMostFreq(){
        sortTopKFreq();
        int[] retKTop = new int[k];
        int counter = 0;
        while(minHeap.size() != 0){
            retKTop[counter] = minHeap.poll()[1];
            counter++;
        }
        return retKTop;
    }

    private void sortTopKFreq(){ //this uses priorityqueue aka heap
        for(Integer num: freqMap.keySet()){
            int numFreq = freqMap.get(num);
            int[] freqNumPair = new int[] {numFreq, num};
            if(minHeap.size() >= k){
                if(minHeap.peek()[0] < numFreq){
                    minHeap.poll();
                    minHeap.add(freqNumPair); 
                }
            }
            else{
                minHeap.add(freqNumPair); 
            }
        }
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TopKFreq topKFreqObject = new TopKFreq(nums, k);
        return topKFreqObject.main();
    }
}
