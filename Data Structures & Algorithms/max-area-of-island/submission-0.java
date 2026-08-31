class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0){
            return 0;
        }

        Deque<int[]> bfs = new LinkedList<>();
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    //bfs
                    bfs.offer(new int[] {i,j});
                    int currArea = 0;
                    while(!bfs.isEmpty()){
                        int[] curr = bfs.pollFirst();
                        int row = curr[0];
                        int col = curr[1];
                        if(grid[row][col] == 1 && visited[row][col] == false){
                            currArea++;
                            visited[row][col] = true;
                            //up, down, left, right
                            if(row - 1 >= 0){
                                bfs.offer(new int[] {row -1, col});
                            }
                            if(row + 1 < grid.length){
                                bfs.offer(new int[] {row +1, col});
                            }
                            if(col - 1 >= 0){
                                bfs.offer(new int[] {row, col -1});
                            }
                            if(col + 1 < grid[row].length){
                                bfs.offer(new int[] {row, col + 1});
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }

        return maxArea;
    }
}
