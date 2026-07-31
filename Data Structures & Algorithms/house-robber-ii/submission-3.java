class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(dfs(0, true, nums), dfs(1, false, nums));
    }

    public int dfs(int n, boolean flag, int[] nums) {
        if (n >= nums.length || (flag && n >= nums.length - 1)) {
            return 0;
        }

        String key = n + "-" + flag;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int ans = Math.max(
            dfs(n + 1, flag, nums),
            nums[n] + dfs(n + 2, n == 0 || flag, nums)
        );

        map.put(key, ans);
        return ans;
    }
}