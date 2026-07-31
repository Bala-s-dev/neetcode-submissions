class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++){
            minHeap.add(nums[i]);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        while(minHeap.size() > k){
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
