class Solution {
    public boolean bs(int[] arr, int target){
        int l = 0;
        int r = arr.length;

        while(l <= r){
            int mid = (l + r)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] < target){
                l = mid + 1;
            }
            else{
                r = mid -1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i = 0; i < r; i++){
            if(matrix[i][0] <= target && target <= matrix[i][c - 1]){
                if(bs(matrix[i], target)){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
}
