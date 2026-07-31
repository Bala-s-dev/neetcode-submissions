class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < stones.length; i++){
            q.offer(stones[i]);
        }

        while(q.size() > 1){
            int num1 = q.poll();
            int num2 = q.poll();

            if(num1 > num2){
                q.offer(num1 - num2);
            }
            else if(num1 < num2){
                q.offer(num2 - num1);
            }
        }
        return q.isEmpty() ? 0 : q.poll();
    }
}
