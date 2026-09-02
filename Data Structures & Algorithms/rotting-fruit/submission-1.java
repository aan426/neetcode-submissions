class OrangesRotting{
    int minutes;
    int freshFruitCount;
    Deque<int[]> bfsQueue;
    OrangesRotting(){
        minutes = 0;
        bfsQueue = new LinkedList<>();
        freshFruitCount = 0;

    }

    public void bfs(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(rottenFruit(grid[i][j])){
                    bfsQueue.offer(new int[] {i, j});
                }
                if(grid[i][j] == 1){
                    freshFruitCount++;
                }
            }
        }

        while(!bfsQueue.isEmpty()){
            int sizeOfQueue = bfsQueue.size();
            boolean fruitRotted = false;
            for(int i = 0; i < sizeOfQueue; i++){ // we need to count minutes by layer, each layer is counted from after every entry into the queue b4 the next round
                int[] currCell = bfsQueue.pollFirst();
                int row = currCell[0];
                int col = currCell[1];
                //check valid neighbors
                    //mark as rotten
                    //add to queue;
                if(validUpperNeighbor(row - 1) && isfreshFruit(grid[row-1][col])){
                    grid[row - 1][col] = 2;
                    fruitRotted = true;
                    freshFruitCount--;
                    bfsQueue.offer(new int[] {row - 1, col});
                }
                if(validLowerNeighbor(row + 1, col, grid)){
                    grid[row + 1][col] = 2;
                    fruitRotted = true;
                    freshFruitCount--;
                    bfsQueue.offer(new int[] {row + 1, col});
                }
                if(validRightNeighbor(col + 1, row, grid)){
                    grid[row][col + 1] = 2;
                    fruitRotted = true;
                    freshFruitCount--;
                    bfsQueue.offer(new int[] {row, col + 1});
                }
                if(validLeftNeighbor(col - 1) && isfreshFruit(grid[row][col-1])){
                    grid[row][col - 1] = 2;
                    fruitRotted = true;
                    freshFruitCount--;
                    bfsQueue.offer(new int[] {row, col - 1});
                }
            }

            if(fruitRotted){
                //increase minute count
                minutes++;
            }
            
        }
    }

    //return true is currVal is a rotten fruit
    private boolean rottenFruit(int currVal){
        return currVal == 2 ? true : false;
    }

    //returns true if row - 1 is in bounds 
    private boolean validUpperNeighbor(int row){
        return row >= 0 ? true : false;
    }

    //returns true if row + 1 is in bounds and currVal is a freshFruit
    private boolean validLowerNeighbor(int row, int col, int[][] grid){
        return row < grid.length && isfreshFruit(grid[row][col]) ? true : false;
    }

    //returns true if col - 1 is in bounds
    private boolean validLeftNeighbor(int col){
        return col >= 0 ? true : false;
    }

    //returns true if col + 1 is in bounds and currVal is a freshFruit
    private boolean validRightNeighbor(int col, int row, int[][] grid){
        return col < grid[0].length && isfreshFruit(grid[row][col]) ? true : false;
    }

    //returns true if current value is a fresh fruit
    private boolean isfreshFruit(int currVal){
        return currVal == 1;
    }

    public int getMinutes(){
        if(freshFruitCount > 0){
            return -1;
        }
        return minutes;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        OrangesRotting countMinutes = new OrangesRotting();
        countMinutes.bfs(grid);
        return countMinutes.getMinutes();
    }
}
