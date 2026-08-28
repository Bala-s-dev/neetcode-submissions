class Solution {
    public void bfs(char[][] grid, boolean[][] vis, int i, int j, int n, int m){
        vis[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});

        int rowDelta[] = {-1, 0, 1, 0};
        int colDelta[] = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            q.poll();
            for(int v = 0; v < 4; v++){
                int row = r + rowDelta[v];
                int col = c + colDelta[v];

                if(row >= 0 && col >= 0 && row < n && col < m && vis[row][col] == false && grid[row][col] == '1'){
                    q.offer(new int[]{row, col});
                    vis[row][col] = true;
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean vis[][] = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    bfs(grid, vis, i, j, n, m);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
