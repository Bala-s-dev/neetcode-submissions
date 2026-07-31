class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        // [2,20,4,10,3,4,5]
        // [2,3,4,5,10,20]
        int longest = 1;
        int currLength = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            else if(nums[i]==nums[i-1]+1){
                currLength++;
            }
            else{
                currLength = 1;
            }
            longest = Math.max(currLength, longest);
        }
        return longest;
    }
}
