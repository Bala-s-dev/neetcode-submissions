class Solution {
    int delrow[] = {-1, 0, 1, 0};
    int delcol[] = {0, 1, 0, -1};

    public void dfs(char[][] board, boolean[][] vis, int r, int c, int n,int m){
        vis[r][c] = true;

        for(int i = 0; i < 4; i++){
            int nrow = r + delrow[i];
            int ncol = c + delcol[i];

            if(nrow > 0 && ncol > 0 && nrow < n && ncol < m && board[nrow][ncol] == 'O' && vis[nrow][ncol] == false){
                dfs(board, vis, nrow, ncol, n, m);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean vis[][] = new boolean[n][m];

        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O')
                dfs(board, vis, i, 0, n, m);

            if(board[i][m - 1] == 'O')
                dfs(board, vis, i, m - 1, n, m);
        }

        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O')
                dfs(board, vis, 0, j, n, m);

            if(board[n - 1][j] == 'O')
                dfs(board, vis, n - 1, j, n, m);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O' && vis[i][j] == false){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
