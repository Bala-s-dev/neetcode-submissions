class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();

        for(int val : map.values()){
            if(val > 0){
                max.offer(val);
            }
        }
        
        int time = 0;
        while(!max.isEmpty() || !q.isEmpty()){
            time++;
            if(!max.isEmpty()){
                int cnt = max.poll();
                cnt--;
                if(cnt > 0){
                    q.offer(new int[]{cnt, time+n});
                }
            }

            if(!q.isEmpty() && time == q.peek()[1]){
                max.offer(q.poll()[0]);
            }

        }
        return time;
    }
}
