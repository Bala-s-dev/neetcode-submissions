class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};

        heap.offer(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;
        
        while(!heap.isEmpty()){
            int t = heap.peek()[0];
            int r = heap.peek()[1];
            int c = heap.peek()[2];

            if(r == n - 1 && c == m - 1){
                return t;
            }
            heap.poll();

            for(int i = 0; i < 4; i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !vis[nrow][ncol]){

                    vis[nrow][ncol] = true;
                    heap.offer(new int[] {Math.max(t, grid[nrow][ncol]), nrow, ncol});

                }
            }
        }
        return n*m;
    }
}
