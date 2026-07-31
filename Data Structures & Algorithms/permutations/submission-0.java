class Solution {
    public void findPermute(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] mark){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
        }

        for(int i = 0; i < nums.length; i++){
            if(mark[i]){
                continue;
            }
            else{
                mark[i] = true;
                temp.add(nums[i]);
                findPermute(nums, ans, temp, mark);
                temp.remove(temp.size() - 1);
                mark[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] mark = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        findPermute(nums, ans, temp, mark);
        return ans;
    }
}
