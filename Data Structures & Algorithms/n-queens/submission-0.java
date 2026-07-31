class Solution {
    public boolean validPos(int row, int col, char[][] board, int n){
        int r = row;
        int c = col;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c--;
        }
        r = row;
        c = col;
        while(c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            c--;
        }
        r = row;
        c = col;
        while(r < n && c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r++;
            c--;
        }
        return true;
    }

    public void solveProb(int col, char[][] board, List<List<String>> ans, int n){
        if(col == n){
            ans.add(convertToList(board));
            return;
        }
        for(int row = 0; row < n; row++){
            if(validPos(row, col, board, n)){
                board[row][col] = 'Q';
                solveProb(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }
    public List<String> convertToList(char[][] board){
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        return temp;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        solveProb(0, board, ans, n);
        return ans;
    }
}
