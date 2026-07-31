class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int findMax(int ind, int prev , int[] nums){
        if(ind == nums.length){
            return 0;
        }
        String key = ind + "-" + prev;

        if(map.containsKey(key)){
            return map.get(key);
        }
        int excludeInd = findMax(ind + 1, prev, nums);
        int includeInd = 0;
        if(prev == -1 || nums[ind] > nums[prev]){
            includeInd = 1 + findMax(ind + 1, ind, nums);
        }
        int res = Math.max(includeInd, excludeInd);
        map.put(key, res);
        return res;
    }
    public int lengthOfLIS(int[] nums) {
        int ans = findMax(0, -1, nums);
        return ans;
    }
}
