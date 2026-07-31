class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Brute force
        int n = nums.length;
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            int prd = 1;
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                prd = prd * nums[j];
            }
            ans[i] = prd;
        }
        return ans;
    }
}  
