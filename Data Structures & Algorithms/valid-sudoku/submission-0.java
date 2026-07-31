class Solution {
    public static boolean checkRow(char[] row){
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < 9; i++){
            if(row[i] == '.') continue;
            if(set.contains(row[i])){
                return false;
            }
            set.add(row[i]);
        }
        return true;
    }

    public static boolean checkCol(char[] col){
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < 9; i++){
            if(col[i] == '.') continue;
            if(set.contains(col[i])){
                return false;
            }
            set.add(col[i]);
        }
        return true;
    }

    public static boolean checkMat(int srow, int scol, char[][] board){
        Set<Character> set = new HashSet<>();
        for(int i = srow; i < srow + 3; i++){
            for(int j = scol; j < scol + 3; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;
        
    }
    public boolean isValidSudoku(char[][] board) {
        //write code for row
        for(char row[] : board){
            if(!checkRow(row)){
                return false;
            }
        }

        //write code for col
        for(int i = 0; i < 9; i++){
            char[] col = new char[9];
            for(int j = 0; j < 9; j++){
                col[j] = board[j][i];
            }
            if(!checkCol(col)){
                return false;
            }
        }
        //write code for box

        for(int i = 0; i < 9; i = i + 3){
            for(int j = 0; j < 9; j = j + 3){
                if(!checkMat(i, j, board)){
                    return false;
                }
            }
        }
        return true;

    }
}
