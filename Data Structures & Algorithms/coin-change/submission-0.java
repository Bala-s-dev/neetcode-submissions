class Solution {
    public int findmin(int[] coins, int n, int target){
        //base case
        if(n == 0){
            if(target % coins[n] == 0){
                return target / coins[n];
            }
            else{
                return 10000000;
            }
        }
        //recursive case
        int notTake = findmin(coins, n - 1, target);
        int take = Integer.MAX_VALUE;
        if(coins[n] <= target){
            take = 1 + findmin(coins, n, target - coins[n]);
        }

        return Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length - 1;
        int min = findmin(coins, n, amount);
        if(min == 10000000){
            return -1;
        }
        return min;
    }
}
