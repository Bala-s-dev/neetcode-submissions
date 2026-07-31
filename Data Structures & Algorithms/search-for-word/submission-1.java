class Solution {
    public boolean dfs(char[][] board, String word, boolean[][] vis, int r, int c, int ind, int row, int col){

        if(ind == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || c >= col || r >= row){
            return false;
        }
        if(board[r][c] != word.charAt(ind) || vis[r][c]){
            return false;
        }
        
        vis[r][c] = true;
        boolean path = dfs(board, word, vis, r + 1, c, ind + 1, row, col) ||
                       dfs(board, word, vis, r , c + 1, ind + 1, row, col) ||
                       dfs(board, word, vis, r - 1, c, ind + 1, row, col) ||
                       dfs(board, word, vis, r , c - 1, ind + 1, row, col);

        vis[r][c] = false; 
        return path;
    }
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        
        boolean vis[][] = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(board, word, vis, i, j, 0, row, col)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
