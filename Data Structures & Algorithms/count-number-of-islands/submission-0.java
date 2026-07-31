class Solution {
    class Pair{
        int row;
        int col;
        
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void dfs(int i, int j, char[][] grid, boolean[][] vis, int n, int m){
        vis[i][j] = true;
    
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();

            for(int v = 0; v < 4; v++){
                int nrow = row + delRow[v];
                int ncol = col + delCol[v];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && !vis[nrow][ncol]){
                    q.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
               
            
        }
    }
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean vis[][] = new boolean[r][c];
        int cnt = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(i, j, grid, vis, r, c);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
