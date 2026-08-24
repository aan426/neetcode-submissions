class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0){
            return 0;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for(char task: tasks){
            int count = freq.getOrDefault(task, 0) + 1;
            freq.put(task, count);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        freq.forEach((key, value) -> {
            maxHeap.add(value);
        });
        Queue<int[]> timeOut = new LinkedList<>();
        int cycles = 0;
        while(maxHeap.size() != 0 || timeOut.size() != 0){
            cycles++;
            if(!maxHeap.isEmpty()){
                int[] curr = new int[2];
                curr[0] = maxHeap.poll() - 1;
                if(curr[0] != 0){
                    curr[1] = cycles + n;
                    timeOut.add(curr); //now we can't access this element until cycles + n is reached
                }
            }
            if(!timeOut.isEmpty()){
                int[] curr = timeOut.peek();
                if(curr[1] == cycles){
                    curr = timeOut.poll();
                    maxHeap.add(curr[0]);
                }
            }
            
        }

        return cycles;
    }
}
