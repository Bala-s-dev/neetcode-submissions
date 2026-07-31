class Pair{
    int row;
    int col;

    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647;
        int r = grid.length;
        int c = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 0){
                    q.offer(new Pair(i, j));
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();

            for(int i = 0; i < 4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow < 0 || ncol < 0 || nrow >= r || ncol >= c || grid[nrow][ncol] == -1 || grid[nrow][ncol] != Integer.MAX_VALUE){
                    continue;
                }

                q.offer(new Pair(nrow, ncol));
                grid[nrow][ncol] = grid[row][col] + 1;
            }
        }
    }
}
