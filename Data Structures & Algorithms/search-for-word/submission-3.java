class Solution {
    boolean found;
    public boolean exist(char[][] board, String word) {
        found = false;
        //check if that coord has already been used or not
        //check the bounds of each potential neighbor 
        //go through a look for every potential start of the string
        int currCharPt = 0;
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                  
                // System.out.println(board[i][j]);
                if(board[i][j] == word.charAt(currCharPt) && used[i][j] == false){
                    if (currCharPt == word.length() - 1) { //another base case
                        return true;
                    } 
                    // System.out.println("here " + i + " " + j);
                    //set
                    used[i][j] = true;

                    //above
                    if(i - 1 >= 0){
                        backtracking(i - 1, j, currCharPt+1, board, word, used);
                    }

                    //below
                    if(i + 1 < board.length){
                        backtracking(i + 1, j, currCharPt+1, board, word, used);
                    }

                    //left
                    if(j - 1 >= 0){
                        backtracking(i, j-1, currCharPt+1, board, word, used);
                    }

                    //right
                    if(j + 1 < board[i].length){
                        backtracking(i, j + 1, currCharPt+1, board, word, used);
                    }

                    //backtrack
                    used[i][j] = false;
                }
            }
        }
        
        return found;
    }

    public void backtracking(int i, int j, int currCharPt, char[][] board, String word, boolean[][] used){
        // System.out.println(i + " " + j + " " + board[i][j]);
        if(used[i][j] || board[i][j] != word.charAt(currCharPt)){ //always check the disqualifying case first
            return;
        }
        if(currCharPt == word.length() -1 && board[i][j] == word.charAt(currCharPt)){
            // System.out.println("?");
            found = true;
            return; 
        }
    

        if(board[i][j] == word.charAt(currCharPt) && used[i][j] == false){
    
            //set
            used[i][j] = true;

            //above
            if(i - 1 >= 0){
                backtracking(i - 1, j, currCharPt+1, board, word, used);
            }

            //below
            if(i + 1 < board.length){
                backtracking(i + 1, j, currCharPt+1, board, word, used);
            }

            //left
            if(j - 1 >= 0){
                backtracking(i, j-1, currCharPt+1, board, word, used);
            }

            //right
            if(j + 1 < board[i].length){
                backtracking(i, j + 1, currCharPt+1, board, word, used);
            }

            //backtrack
            used[i][j] = false;
        }
        
        return;
    }
}
