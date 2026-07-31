class Solution {
    public int dp(int ind, int n, int[] nums,int[] memo){
        if(ind > n){
            return 0;
        }
        if(memo[ind] != -1){
            return memo[ind];
        }
        memo[ind] = Math.max(dp(ind + 1, n, nums, memo), nums[ind] + dp(ind + 2, n, nums, memo));
        return memo[ind];
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int[] memo = new int[nums.length];
        int n = nums.length - 1;
        Arrays.fill(memo, -1);
        int includeIndOneandExcludeLastInd = dp(0, n - 1, nums, memo);
        Arrays.fill(memo, -1);
        int excludeIndOneandIncludeLastInd = dp(1, n, nums, memo);

        int ans = Math.max(includeIndOneandExcludeLastInd, excludeIndOneandIncludeLastInd);
        return ans;
    }
}
