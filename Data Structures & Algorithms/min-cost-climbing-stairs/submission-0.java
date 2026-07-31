class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 1;
        int temp[] = new int[n];
        //[1, 2, 3, 0]
        for(int i = 0; i < n - 1; i++){
            temp[i] = cost[i];
        }

        // System.out.print(Arrays.toString(temp));

        for(int i = n - 3; i >= 0; i--){
            temp[i] = temp[i] + Math.min(temp[i + 1], temp[i + 2]);
        }

        return Math.min(temp[0], temp[1]);
    }
}
