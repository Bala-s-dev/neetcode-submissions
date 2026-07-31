class Solution {
    public void findsubset(int[] nums, List<List<Integer>> ans, List<Integer> sub, int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        findsubset(nums, ans,sub, i + 1);
        sub.remove(sub.size() - 1);
        findsubset(nums, ans, sub, i + 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        findsubset(nums, ans, sub, 0);
        return ans;
    }
}
