class IslandsAndTreasure{
    Deque<int[]> bfs; //holds: [i, j, countFromZero]
    public IslandsAndTreasure(){
        bfs = new LinkedList<>();
    }

    public void bfs(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(isTreasure(grid[i][j])){
                    bfs.offer(new int[] {i, j, 0});
                }
            }
        }

        while(!bfs.isEmpty()){
            int[] currSpot = bfs.pollFirst();
            int row = currSpot[0];
            int col = currSpot[1];
            int countFromZero = currSpot[2];

            //we only need to check for valid neighbors because we've now only added treasures to the queue
            if(hasValidUpperNeighbor(row) && isTraversableLand(grid[row - 1][col])){
                grid[row-1][col] = countFromZero + 1;
                bfs.offer(new int[] {row - 1, col, countFromZero + 1});
            }
            if(hasValidRightNeighbor(grid, col) && isTraversableLand(grid[row][col + 1])){
                grid[row][col+1] = countFromZero + 1;
                bfs.offer(new int[] {row, col + 1, countFromZero + 1});
            }
            if(hasValidLeftNeighbor(col) && isTraversableLand(grid[row][col - 1])){
                grid[row][col-1] = countFromZero + 1;
                bfs.offer(new int[] {row, col - 1, countFromZero + 1});
            }
            if(hasValidLowerNeighbor(grid, row) && isTraversableLand(grid[row + 1][col])){
                grid[row+1][col] = countFromZero + 1;
                bfs.offer(new int[] {row + 1, col, countFromZero + 1});
            }
            
        }
    }

    //returns true if value == 0 which is treasure
    private boolean isTreasure(int value){
        return value == 0 ? true : false;
    }

    //returns true if value == INF
    private boolean isTraversableLand(int value){
        return value == Integer.MAX_VALUE ? true : false;
    }

    //returns true if row - 1 is greater than or == 0
    private boolean hasValidUpperNeighbor(int row){
        return row - 1 >= 0 ? true : false;
    }

    //returns true if col + 1 is less than grid[0].length
    private boolean hasValidRightNeighbor(int[][] grid, int col){
        return col + 1 < grid[0].length ? true : false;
    }

    //returns true if col - 1 is greater than or == 0
    private boolean hasValidLeftNeighbor(int col){
        return col - 1 >= 0 ? true : false;
    }

    //returns true if row + 1 is less than grid.length
    private boolean hasValidLowerNeighbor(int[][] grid, int row){
        return row + 1 < grid.length ? true : false;
    }

}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        //closest treasure chest to INF == bfs of choords
        //start at 0 instead of INF
        //ignore -1 and 0, take the smallest of any valid adjacent value and add 1
        IslandsAndTreasure check = new IslandsAndTreasure();
        check.bfs(grid);
    }
}
