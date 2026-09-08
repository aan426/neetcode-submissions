class CaptureRegion{
    Deque<int[]> bfsQueue;
    // List<List<Integer>> allRegions;
    boolean validRegion;
    public CaptureRegion(){
        bfsQueue = new LinkedList<>();
        validRegion = true;
        // allRegions = new ArrayList<>();
    }

    public void findRegions(char[][] board){
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int[] currCell = new int[] {i,j};
                if(currCellIsValid(currCell, board) && !currCellTouchesBoarder(currCell, board) && visited[i][j] == false){
                    // System.out.println("here");
                    
                    visited[i][j] = true;
                    validRegion = true;
                    bfsQueue.offer(currCell);
                    List<int[]> currRegion = new ArrayList<>();
                    multiSourceBFS(currRegion, board, visited);
                    if(validRegion){
                        captureRegion(currRegion, board);
                    }
                }
            }
        }
    }

    private void multiSourceBFS(List<int[]> currRegion, char[][] board, boolean[][] visited){
        //base case
        while(!bfsQueue.isEmpty()){
            int[] currCell = bfsQueue.pollFirst();
            int row = currCell[0];
            int col = currCell[1];
            // System.out.println("Curr coords " + row + " " + col);

            if(currCellTouchesBoarder(currCell, board)){
                // currRegion.clear();
                validRegion = false;
                // return;
            }

            //if(currCellIsValid(currCell, board)){ //only passing valid entries
            currRegion.add(currCell);
            //}
            
            if(validUpperNeighbor(new int[] {row - 1, col}, visited, board)){
                visited[row - 1][col] = true;
                bfsQueue.offer(new int[] {row - 1, col});
            }
            if(validLowerNeighbor(new int[] {row + 1, col}, visited, board)){
                visited[row + 1][col] = true;
                bfsQueue.offer(new int[] {row + 1, col});
            }
            if(validLeftNeighbor(new int[] {row, col - 1}, visited, board)){
                visited[row][col - 1] = true;
                bfsQueue.offer(new int[] {row, col - 1});
            }
            if(validRightNeighbor(new int[] {row, col + 1}, visited, board)){
                visited[row][col + 1] = true;
                bfsQueue.offer(new int[] {row, col + 1});
            }
        }
    }

    private boolean validUpperNeighbor(int[] currCell, boolean[][] visited, char[][] board){
        return currCell[0] >= 0 && currCellIsValid(currCell, board) && visited[currCell[0]][currCell[1]] == false ? true : false;
    }

    private boolean validLowerNeighbor(int[] currCell, boolean[][] visited, char[][] board){
        return currCell[0] < board.length && currCellIsValid(currCell, board) && visited[currCell[0]][currCell[1]] == false ? true : false;
    }

    private boolean validLeftNeighbor(int[] currCell, boolean[][] visited, char[][] board){
        return currCell[1] >= 0 && currCellIsValid(currCell, board) && visited[currCell[0]][currCell[1]] == false ? true : false;
    }

    private boolean validRightNeighbor(int[] currCell, boolean[][] visited, char[][] board){
        return currCell[1] < board[0].length && currCellIsValid(currCell, board) && visited[currCell[0]][currCell[1]] == false ? true : false;
    }

    private boolean currCellIsValid(int[] currCell, char[][] board){
        // System.out.println("valid cell");

        int row = currCell[0];
        int col = currCell[1];
        return board[row][col] == 'O' ? true : false;
    }

    private boolean currCellTouchesBoarder(int[] currCell, char[][] board){
        // System.out.println("touching boarder");

        int row = currCell[0];
        int col = currCell[1];
        return row == board.length - 1 || row == 0 || col == board[row].length - 1 || col == 0 ? true : false;
    }

    private void captureRegion(List<int[]> currRegion, char[][] board){
        for(int[] coord: currRegion){
            int row = coord[0];
            int col = coord[1];
            board[row][col] = 'X';
        }
    }
}

class Solution {
    public void solve(char[][] board) {
        CaptureRegion check = new CaptureRegion();
        check.findRegions(board);
    }
}
