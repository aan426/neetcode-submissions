class Solution {
    public int numIslands(char[][] grid) {
        //look through each value for a 1, check if its already part of an island or the start of a new one
        if(grid.length == 0){
            return 0;
        }
        int islandCount = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<int[]> bfs = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    bfs.offer(new int[] {i,j});
                    while(!bfs.isEmpty()){
                        int[] curr = bfs.pollFirst();
                        int row = curr[0];
                        int col = curr[1];
                        if(grid[row][col] == '1' && visited[row][col] == false){
                            visited[row][col] = true;

                            if(row - 1 >= 0){
                                bfs.offer(new int[] {row-1, col});
                            }
                            if(row + 1 < grid.length){
                                bfs.offer(new int[] {row+1, col});
                            }
                            if(col - 1 >= 0){
                                bfs.offer(new int[] {row, col-1});
                            }
                            if(col + 1 < grid[0].length){
                                bfs.offer(new int[] {row, col+1});
                            }
                        }
                    }
                    islandCount++;
                    // dfs(grid, visited, i, j);
                }
            }
        }
        return islandCount;
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col){
        //check up, down, left, right
        if(grid[row][col] != '1'){
            return;
        }
        if(visited[row][col] == false){
            visited[row][col] = true;

            if(row - 1 >= 0){
                dfs(grid, visited, row -1, col);
            }
            if(row + 1 < grid.length){
                dfs(grid, visited, row +1, col);
            }
            if(col - 1 >= 0){
                dfs(grid, visited, row, col-1);
            }
            if(col + 1 < grid[0].length){
                dfs(grid, visited, row, col+1);
            }
        }
        return;
    }
}
