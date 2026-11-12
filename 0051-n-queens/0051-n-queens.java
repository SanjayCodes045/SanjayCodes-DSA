class Solution {
    static boolean isSafeToPlace(char[][] board,int n,int rowIndex,int colIndex){
        //left horizental----->
        int row = rowIndex;
        int col = colIndex;
        while(col>=0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        col = colIndex;
        // left upper diogonal ------>
        while(row>=0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
            row--;
        }

        col = colIndex;
        row = rowIndex;
        //left down Diogonal--------->

        while(col>=0 && row < n){
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }

        return true;
    }
    static void solve(int n, char[][] board, List<List<String>> ans, int colIndex){
        if(colIndex >= n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i<n; i++){
                temp.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int rowIndex = 0; rowIndex<n; rowIndex++){
            if(isSafeToPlace(board, n, rowIndex, colIndex)){
                board[rowIndex][colIndex] = 'Q';
                solve(n,board,ans,colIndex+1);
                 board[rowIndex][colIndex] = '.';
            }
           
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        int colIndex = 0;
        solve(n,board,ans,colIndex);
        return ans;
    }
}