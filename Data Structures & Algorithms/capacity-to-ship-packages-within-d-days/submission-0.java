class Solution {
    public int checkValid(int mid, int[] nums){
        int sum = 0;
        int days = 1;
        for(int i = 0; i < nums.length; i++){

            if(sum + nums[i] > mid){
                days++;
                sum = nums[i];
            }
            else{
                sum = sum + nums[i];
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int i = 0; i < weights.length; i++){
            if(weights[i] > low){
                low = weights[i];
            }
            high += weights[i];
        }

        System.out.println(low);
        System.out.println(high);

        int ans = 0;

        while(low <= high){
            int mid = (low + high)/2;
            if(checkValid(mid, weights) <= days){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}