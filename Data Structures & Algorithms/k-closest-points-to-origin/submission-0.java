class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int[] point : points){
            int a = point[0];
            int b = point[1];
            int dis = (a*a) + (b*b);
            q.offer(new int[]{dis, a, b});
        }

        while(q.size() > k){
            q.poll();
        }

        int res[][] = new int[k][2];
        for(int i = 0; i < k; i++){
            int temp[] = q.poll();
            res[i][0] = temp[1];
            res[i][1] = temp[2];
        }
        return res;
    }
}
