class NumIslands{
    char[][] grid;
    int islandCount;
    public NumIslands(char[][] grid){
        this.grid = grid;
        islandCount = 0;
    }

    public int calcNumIslands(){
        boolean[][] visitedGrid = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(unExploredIsland(grid[i][j], visitedGrid[i][j])){
                    visitedGrid[i][j] = true;
                    dfsIsland(i, j, visitedGrid);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private boolean unExploredIsland(char gridVal, boolean visited){
        return gridVal == '1' && visited == false ? true : false;
    }

    private void dfsIsland(int i, int j, boolean[][] visitedGrid){
        if(grid[i][j] == '0'){
            return;
        }

        if(validUp(i-1) && unExploredIsland(grid[i-1][j], visitedGrid[i-1][j])){
            visitedGrid[i-1][j] = true;
            dfsIsland(i-1, j, visitedGrid);
        }
        if(validDown(i+1) && unExploredIsland(grid[i+1][j], visitedGrid[i+1][j])){
            visitedGrid[i+1][j] = true;
            dfsIsland(i+1, j, visitedGrid);
        }
        if(validLeft(j-1) && unExploredIsland(grid[i][j-1], visitedGrid[i][j-1])){
            visitedGrid[i][j-1] = true;
            dfsIsland(i, j-1, visitedGrid);
        }
        if(validRight(j+1) && unExploredIsland(grid[i][j+1], visitedGrid[i][j+1])){
            visitedGrid[i][j+1] = true;
            dfsIsland(i, j+1, visitedGrid);
        }
    }

    private boolean validUp(int i){
        return i >= 0 ? true : false;
    }

    private boolean validDown(int i){
        return i < grid.length ? true : false;
    }

    private boolean validLeft(int j){
        return j >= 0 ? true : false;
    }

    private boolean validRight(int j){
        return j < grid[0].length ? true : false;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }

        NumIslands object = new NumIslands(grid);
        return object.calcNumIslands();
    }
}
