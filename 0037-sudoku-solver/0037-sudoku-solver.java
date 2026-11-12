class Solution {
    static boolean isSafeToPlace(char[][] board, char charValue, int rowIndex, int colIndex){
        for(int i = 0; i<9; i++){
            if(board[rowIndex][i] == charValue) return false;
        }

        for(int i = 0; i<9; i++){
            if(board[i][colIndex] == charValue) return false;
        }

        int startingRow = rowIndex - (rowIndex%3);
        int startingCol = colIndex - (colIndex%3);
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int row = startingRow+i;
                int col = startingCol+j;
                if(board[row][col] == charValue) return false;
            }
        }
        return true;
    }
    static boolean findEmptyCell(char[][] board, int[] emptyCell){
        for(int i = 0; i<9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    emptyCell[0] = i;
                    emptyCell[1] = j;
                    return true;
                }
            }
        }
        return false;
    }
    static boolean solve(char[][] board){
        int emptyCell[] = new int[2];
        if(!findEmptyCell(board,emptyCell)) return true;

        int rowIndex = emptyCell[0];
        int colIndex = emptyCell[1];

        for(int i = 1; i<=9; i++){
            char charValue = (char)(i+'0');
            if(isSafeToPlace(board,charValue,rowIndex,colIndex)){
                board[rowIndex][colIndex] = charValue;
                if(solve(board) == true) return true;
                board[rowIndex][colIndex] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}