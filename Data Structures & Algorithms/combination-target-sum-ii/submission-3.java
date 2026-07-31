class Solution {
    public void findSum(int[] arr, int target, List<List<Integer>> ans, List<Integer> sum, int ind){
        if(target == 0){
            ans.add(new ArrayList<>(sum));
            return;
        }

        for(int i = ind; i < arr.length; i++){
            if(i > ind && arr[i] == arr[i - 1]){
                continue; 
            }

            if(arr[ind] > target){
                return;
            }
            
            sum.add(arr[i]);
            findSum(arr, target - arr[i], ans, sum, i + 1);
            sum.remove(sum.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        findSum(candidates,target, ans, sum, 0);
        return ans;
    }
}
