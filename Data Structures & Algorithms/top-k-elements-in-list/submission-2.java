class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int key : map.keySet()){
            q.offer(key);
        }

        while(q.size() > k){
            q.poll();
        }

        int ans[] = new int[k];

        for(int i = k - 1; i >= 0; i--){
            ans[i] = q.poll();
        }

        return ans;
    }
}
