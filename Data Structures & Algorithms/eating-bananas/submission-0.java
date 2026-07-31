class Solution {
    public int calRate(int[] piles, int r){
        int th = 0;
        for(int i = 0; i < piles.length; i++){
            th += (int)Math.ceil((double)piles[i]/r);
        }
        return th;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int n = piles.length;
        for(int i = 0; i < n; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }

        int l = 1;
        int r = max;
        int ans = max;
        while(l <= r){
            int mid = (l + r) / 2;
            int rate = calRate(piles, mid);
            if(rate <= h){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}
