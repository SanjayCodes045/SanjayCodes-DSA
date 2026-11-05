class Solution {
    static boolean isSafePlace(int rowIndex,int colIndex,char charValue,char[][] board){
        //check row ---
        for(int col = 0; col < 9; col++){
            if(board[rowIndex][col] == charValue) return false;
        }
        //check column ---
        for(int row = 0; row < 9; row++){
            if(board[row][colIndex] == charValue) return false;
        }

        // check sunBoard --->
        int startRow = rowIndex - rowIndex%3;
        int startCol = colIndex - colIndex%3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int actualRow = startRow+i;
                int actualCol = startCol+j;
                if(board[actualRow][actualCol] == charValue) return false;
            }
        }
        return true;
    }
    static boolean findEmptyCell(char[][] board, int[] emptyCell){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.'){
                    emptyCell[0] = row;
                    emptyCell[1] = col;
                    return true;
                }
            }
        }
        return false;
    } 
    static boolean solve(char[][] board){
        int[] emptyCell = new int[2];
        if(!findEmptyCell(board,emptyCell)) return true;

        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        for(int value = 1; value <= 9; value++){
            char charValue = (char)(value + '0');
            if(isSafePlace(rowIndex,colIndex,charValue,board)){
                board[rowIndex][colIndex] = charValue;
                if(solve(board) == true) return true;

                //backtraking step --->
                board[rowIndex][colIndex] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}