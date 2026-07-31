class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] f : flights){
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});   //step, node, cost
        dis[src] = 0;

        while(!q.isEmpty()){
            int current[] = q.poll();
            int step = current[0];
            int node = current[1];
            int cost = current[2];

            if(step > k){
                continue;
            }

            for(int[] nei : adj.get(node)){
                int nextNode = nei[0];
                int edge = nei[1];

                if(dis[nextNode] > cost + edge && step <= k){
                    dis[nextNode] = cost + edge;
                    q.offer(new int[]{step + 1, nextNode, cost + edge});
                }
            }
        }
        if(dis[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return dis[dst];
    }
}
