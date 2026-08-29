class Solution {
    public List<List<String>> solveNQueens(int n) {
        // if(n == 1){
        //     return new ArrayList<>("Q");
        // }
        // if(n < 4){
        //     return new ArrayList<>();
        // }

        List<List<String>> ret = new ArrayList<>();
        dfs(n, 0, ".".repeat(n), 0, new ArrayList<>(), ret, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return ret;
    }

    public void dfs(int n, int countN, String rowStr, int row, List<String> board, List<List<String>> ret, Set<Integer> col, Set<Integer> negDiag, Set<Integer> posDiag){
        if(countN == n){
            ret.add(new ArrayList<>(board));
            return;
        }

        if(board.size() == n && board.get(n-1).length() == n && countN != n){
            return;
        }



        // for(int i = row; i < n; i++){
            rowStr = ".".repeat(n); 
            
            for(int j = 0; j < n; j++){
                if(col.contains(j)){ //check for overlapping cols
                    continue; //to skip use cont, to reject use return
                }
                if(negDiag.contains(row-j)){
                    continue;
                }
                if(posDiag.contains(row+j)){
                    continue;
                }
                    
                rowStr = rowStr.substring(0, j) + "Q" + rowStr.substring(j, n-1);
                col.add(j);
                negDiag.add(row-j);
                posDiag.add(row+j);
                board.add(rowStr);
                dfs(n, countN + 1, rowStr, row + 1, board, ret, col, negDiag, posDiag);
                //back tracking
                col.remove(j);
                negDiag.remove(row-j);
                posDiag.remove(row+j);
                board.remove(board.size() -1);
                rowStr = ".".repeat(n); 

                
            }
        // }
    }
}
