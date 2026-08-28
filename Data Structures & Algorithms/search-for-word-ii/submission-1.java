class Solution {
    public boolean dfs(char[][] board, boolean[][] vis, String word, int ind, int row, int col){
        if(ind == word.length()){
            return true;
        }
        
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }

        if(board[row][col] != word.charAt(ind) || vis[row][col]){
            return false;
        }

        vis[row][col] = true;

        boolean res = dfs(board, vis, word, ind + 1, row - 1, col) ||
                      dfs(board, vis, word, ind + 1, row + 1, col) ||
                      dfs(board, vis, word, ind + 1, row, col - 1) ||
                      dfs(board, vis, word, ind + 1, row, col + 1);

        vis[row][col] = false;
        return res;

    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        for(String word : words){
            boolean present = false;
            boolean vis[][] = new boolean[board.length][board[0].length];
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == word.charAt(0)){
                        if(dfs(board, vis, word, 0, i, j)){
                            present = true;
                        }
                    }
                }
            }
            if(present){
                ans.add(word);
            }
        }
        return ans;
    }
}
