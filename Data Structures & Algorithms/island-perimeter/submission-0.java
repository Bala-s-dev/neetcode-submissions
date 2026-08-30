class Solution {

    public int islandPerimeter(int[][] grid) {

        int res = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {

                    // Top
                    if (i == 0 || grid[i - 1][j] == 0) {
                        res++;
                    }

                    // Left
                    if (j == 0 || grid[i][j - 1] == 0) {
                        res++;
                    }

                    // Bottom
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        res++;
                    }

                    // Right
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
                        res++;
                    }
                }
            }
        }

        return res;
    }
}