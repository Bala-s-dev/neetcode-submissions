class Solution {
    public int uniquePaths(int m, int n) {
        int r = 0;
        int c = 0;
        int[][] memo = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                memo[i][j] = -1;
            }
        }

        return dfs(r, c, m, n, memo);
    }

    public int dfs(int r, int c, int m, int n, int[][] memo){
        if(r == (m - 1) && c == (n - 1)){
            return 1;
        }
        if(r >= m || c >= n){
            return 0;
        }

        if(memo[r][c] != -1){
            return memo[r][c];
        }
        
        int right = dfs(r, c + 1, m, n, memo);
        int down = dfs(r + 1, c, m, n, memo);

        int path = right + down;
        memo[r][c] = path;
        return path;
    }
}
