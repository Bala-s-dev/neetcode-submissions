class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        HashSet<Integer> vis = new HashSet<>();
        int len = points.length;

        heap.offer(new int[]{0, 0});
        int total_cost = 0;

        while(vis.size() < len){
            int[] curr = heap.poll();
            int d = curr[0];
            int n = curr[1];

            if(vis.contains(n)){
                continue;
            }

            total_cost += d;
            int x1 = points[n][0];
            int y1 = points[n][1];

            vis.add(n);

            for(int i = 0; i < len; i++){
                if(!vis.contains(i)){
                    int x2 = points[i][0];
                    int y2 = points[i][1];

                    int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                    heap.offer(new int[]{dis, i});
                }
            }
        }
        return total_cost;
    }
}
