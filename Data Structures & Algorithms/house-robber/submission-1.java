class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int dfs(int[] nums, int n){
        if(n >= nums.length){
            return 0;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        int memo = Math.max(dfs(nums, n + 1), nums[n] + dfs(nums, n + 2));
        if(!map.containsKey(n)){
            map.put(n, memo);
        }
        return memo;
    }
    public int rob(int[] nums) {
        int len = 0;
        return dfs(nums, 0);
    }
}
