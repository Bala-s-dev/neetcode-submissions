class Solution {
    public void findSum(int[] nums, int target, List<List<Integer>> ans, List<Integer> sum, int i){
        if(target == 0){
            ans.add(new ArrayList<>(sum));
            return;
        }

        if(i == nums.length){
            return;
        }

        if(target < 0){
            return;
        }

        if(nums[i] <= target){
            sum.add(nums[i]);
            findSum(nums, target - nums[i], ans, sum, i);
            sum.remove(sum.size() - 1);
        }
        findSum(nums, target, ans, sum, i + 1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> sum = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        findSum(nums, target, ans, sum, 0);
        return ans;
    }
}
