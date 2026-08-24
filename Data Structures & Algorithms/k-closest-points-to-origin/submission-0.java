class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i = 0; i < points.length; i++){
            int[] pair = new int[3];
            for(int j = 0; j < points[i].length; j++){
                pair[j+1] = points[i][j];
                System.out.println(pair[j+1]);
            }
            // double x1 = Math.pow(pair[1], 2);
            // double y1 = Math.pow(pair[2], 2);
            int euclidean = pair[1] * pair[1] + pair[2] * pair[2];
            pair[0] = euclidean;
            minHeap.add(pair); 
        }

        int counter = 0;
        int[][] ret = new int[k][2];
        while(counter < k && minHeap.size() > 0){
            int[] curr = minHeap.poll();
            System.out.println(curr[0]);

            ret[counter][0] = curr[1];
            ret[counter][1] = curr[2];
            
            counter++;
        }

        return ret;
    }
}
