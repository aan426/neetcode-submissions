class Solution {
    public int lastStoneWeight(int[] stones) {
        //continuously want the two largest elements --> max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int weight: stones){
            maxHeap.add(weight);
        }

        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x > y){
                maxHeap.add(x-y);
            }
            else if(y > x){
                maxHeap.add(y-x);
            }
        }
        if(maxHeap.size() == 0){
            return 0;
        }
        return maxHeap.peek();
    }
}
