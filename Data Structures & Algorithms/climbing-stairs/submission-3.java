class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        int cnt = 0;
        
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }

        cnt += climbStairs(n - 1);
        cnt += climbStairs(n - 2);

        if(!map.containsKey(n)){
            map.put(n, cnt);
        }

        return cnt;
    }
}
