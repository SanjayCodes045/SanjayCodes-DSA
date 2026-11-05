class Solution {
    static boolean isSafeToPlace(int rowIndex,int colIndex,char[][] board,int n){
        int col = colIndex;
        int row = rowIndex;
        // left horizontal
        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }
        // upper-left digonal 
        col = colIndex;
        row = rowIndex;
        while(col >= 0 && row >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
            row--;
        }
        // down-left digonal 
        col = colIndex;
        row = rowIndex;
        while(col >= 0 && row < n){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
            row++;
        }
        return true;
    }
    static void solve(int n, char[][] board, int colIndex, List<List<String>> ans){
        if(colIndex >= n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i<n; i++){
                temp.add(new String (board[i]));
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

            for(int rowIndex = 0; rowIndex < n; rowIndex++){
                if(isSafeToPlace(rowIndex,colIndex,board,n)){
                    board[rowIndex][colIndex] = 'Q';
                    solve(n,board,colIndex+1,ans);
                    // backtraking step--->
                    board[rowIndex][colIndex] = '.';
                }
            }
        
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(board[i],'.');
        }

        int colIndex = 0;
        List<List<String>> ans = new ArrayList<>();
        solve(n,board,colIndex,ans);
        return ans;
    }
}