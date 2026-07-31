class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r){
            int mid = l + (r - l) / 2;

            if(nums[mid] > nums[r]){
                // Minimum is on right side
                l = mid + 1;
            }
            else{
                // Minimum could be mid itself
                r = mid;
            }
        }

        return nums[l];
    }
}