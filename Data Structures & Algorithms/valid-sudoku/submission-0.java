class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check through each respective row and column
        //or 2 hashmaps for row and cols to check if theres a number that already exists
        //3rd hashmap for boxes with [a,b]  where a,b is which 3rd the row or col is
    
        Map<Integer,Set<Character>> rowMap = new HashMap<>();
        Map<Integer,Set<Character>> colMap = new HashMap<>();
        Map<String,Set<Character>> boxMap = new HashMap<>();

        for (int row = 0; row < board.length; row++){
            Set<Character> currRow = rowMap.getOrDefault(row, new HashSet<>());

            for (int col = 0; col < board[row].length; col++){
                char val = board[row][col];
                if(val != '.'){
                    Set<Character> currCol = colMap.getOrDefault(col, new HashSet<>());
                    System.out.println(val);
                    
                    String coords = (row / 3) + "," + (col / 3);
                    Set<Character> currBox = boxMap.getOrDefault(coords, new HashSet<>());

                    if (currRow.contains(val) || currCol.contains(val) || currBox.contains(val)){
                        return false;
                    }
                    else{
                        currRow.add(val);
                        currCol.add(val);
                        currBox.add(val);

                        rowMap.put(row, currRow);
                        colMap.put(col, currCol);
                        boxMap.put(coords, currBox);
                    }
                }
            }
        }
        return true;
    }
}
