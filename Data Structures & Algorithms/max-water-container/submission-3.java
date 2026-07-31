class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxWater = -1;
        while(l < r){
            int minHeight = Math.min(heights[l], heights[r]);
            int area = r - l;
            int water = minHeight * area;

            maxWater = Math.max(water, maxWater);

            if(heights[l] < heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxWater;
    }
}
