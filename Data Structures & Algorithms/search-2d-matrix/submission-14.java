class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //eliminate by row first then column
        int lowerRow = 0;
        int upperRow = matrix.length - 1;
        int lowerCol = 0;
        int upperCol = matrix[0].length - 1;

        while(lowerRow < upperRow){
            int medRow = (upperRow + lowerRow + 1) / 2;
            if(matrix[medRow][0] <= target){
                lowerRow = medRow;      // keep medRow as a candidate
            }
            else{
                upperRow = medRow - 1;
            }

        }
        // System.out.println(lowerRow + " " + upperRow);
        // if(lowerRow >= matrix.length && target <= matrix[matrix.length -1][matrix[0].length -1]){
        //     lowerRow = matrix.length - 1;
        // }
        // else if(lowerRow >= matrix.length){
        //     return false;
        // }
        while(lowerCol <= upperCol){
            // System.out.println(lowerCol + " " + upperCol);
            int medRow = (upperCol + lowerCol) / 2;
            // System.out.println(medRow);

            // if(medRow == lowerRow){
            //     return false;
            // }
            if(matrix[lowerRow][medRow] == target){
                return true;
            }
            else if(matrix[lowerRow][medRow] < target){
                lowerCol = medRow + 1;
            }
            else{
                upperCol = medRow - 1;
            }
        }
        return false;
    }
}
