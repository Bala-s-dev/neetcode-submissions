class Solution {
    public int dfs(int[][] grid, boolean[][] vis, int row, int col, int n, int m, int[] rowDelta, int[] colDelta){
        vis[row][col] = true;
        int cnt = 1;
        
        for(int i = 0; i < 4; i++){
            int nrow = row + rowDelta[i];
            int ncol = col + colDelta[i];

            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == false){
                cnt += dfs(grid, vis, nrow, ncol, n, m, rowDelta, colDelta);
            }
        }
        return cnt;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean vis[][] = new boolean[r][c];
        int area = 0;
        int rowDelta[] = {-1, 0, 1, 0};
        int colDelta[] = {0, 1, 0, -1};

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    int cnt = dfs(grid, vis, i, j, r, c, rowDelta, colDelta);
                    area = Math.max(area, cnt);
                }
            }
        }
        return area;
    }
}
