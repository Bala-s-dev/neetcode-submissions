class Solution {
    public void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;

        for(int nei : adj.get(node)){
            if(!vis[nei]){
                dfs(nei, adj, vis);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[n];

        for(int i = 0; i < n; i++){
            adj.add(i, new ArrayList<>());
        }

        for(int[] node : edges){
            adj.get(node[0]).add(node[1]);
            // adj.get(node[1]).add(node[0]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                ans++;
                dfs(i, adj, vis);
            }
        }
        return ans;
    }
}
