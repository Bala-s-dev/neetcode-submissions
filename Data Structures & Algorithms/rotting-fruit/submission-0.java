class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] vis = new boolean[r][c];
        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[] rowDelta = {-1, 0, 1, 0};
        int[] colDelta = {0, 1, 0, -1};

        int minutes = 0;

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int k = 0; k < size; k++) {

                int row = q.peek().row;
                int col = q.peek().col;
                q.poll();

                for (int i = 0; i < 4; i++) {
                    int nrow = row + rowDelta[i];
                    int ncol = col + colDelta[i];

                    if (nrow < 0 || ncol < 0 ||
                        nrow >= r || ncol >= c ||
                        grid[nrow][ncol] != 1 ||
                        vis[nrow][ncol]) {
                        continue;
                    }

                    q.offer(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                    grid[nrow][ncol] = 2;
                    fresh--;
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}