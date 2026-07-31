class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        HashSet<Integer> vis = new HashSet<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new int[]{v, w});
        }

        q.offer(new int[]{0, k});

        int t = 0;
        while(!q.isEmpty()){
            int time = q.peek()[0];
            int n1 = q.peek()[1];
            q.poll();
            if(vis.contains(n1)){
                continue;
            }
            t = time;
            
            vis.add(n1);

            if(adj.containsKey(n1)){
                for(int[] nei : adj.get(n1)){
                    int n2 = nei[0];
                    int t1 = nei[1];

                    if(!vis.contains(n2)){
                        q.offer(new int[]{t1 + time, n2});
                    }
                }
            }
        }
        if(vis.size() == n){
            return t;
        }
        return -1;
    }
}
