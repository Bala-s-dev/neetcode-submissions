class Solution {
    public static int findMax(int[] nums, int l, int r){
        int max = -1;
        for(int i = l; i <= r; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = k - 1;
        int n = nums.length;
        while(r < n){
            int max = findMax(nums, l, r);
            nums[l] = max;
            l++;
            r++;
        }
        int ans[] = new int[l];
        for(int i = 0; i < l; i++){
            ans[i] = nums[i];
        }

        return ans;
    }
}
