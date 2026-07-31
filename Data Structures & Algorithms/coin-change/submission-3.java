class Solution {
    HashMap<String, Integer> memo = new HashMap<>();
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
        String key = n + "-" + target;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int notTake = findmin(coins, n - 1, target);
        int take = Integer.MAX_VALUE;
        if(coins[n] <= target){
            take = 1 + findmin(coins, n, target - coins[n]);
        }

        int res = Math.min(take, notTake);
        memo.put(key, res);
        return res;
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
