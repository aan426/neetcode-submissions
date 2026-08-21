class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        1235123412315 find top 3 most freq

        5
        3
        3
        1
        2

        */

        Map<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] - b[1]);   
        // use min instead of max to always keep the most frequent values 
        // this says that a (the first element) is what the queue will be sorted on

        for(int i = 0; i < nums.length; i++){
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){   
            // System.out.println(entry);
            // System.out.println(entry.getKey());
            // System.out.println(entry.getValue());
        
            int[] entryArry = new int[] {entry.getKey(), entry.getValue()};
            minHeap.add(entryArry);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // System.out.println(minHeap.poll()[0]);
        int count = 0;
        int[] retKVals = new int[k];
        while (count < k) {
            int[] currentArray = minHeap.poll(); 
            // System.out.println("Key: " + currentArray[0] + ", Value: " + currentArray[1]);
            retKVals[count] = currentArray[0];
            count ++;
        }

        return retKVals;
    }
}
