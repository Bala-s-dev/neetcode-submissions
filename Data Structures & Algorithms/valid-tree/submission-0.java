class Solution {
    public boolean dfs(int node, int prev, List<List<Integer>> adj, HashSet<Integer> vis){
        if(vis.contains(node)){
            return false;
        }
        vis.add(node);
        
        for(int nei : adj.get(node)){
            if(nei == prev){
                continue;
            }
            if(!dfs(nei, node, adj, vis)){
                return false;
            }
        }
        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adjList.add(i, new ArrayList<>());
        }

        for(int[] node : edges){
            adjList.get(node[0]).add(node[1]);
            adjList.get(node[1]).add(node[0]);
        }
        
        HashSet<Integer> vis = new HashSet<>();
        if(!dfs(0, -1, adjList, vis)){
            return false;
        }
        return vis.size() == n;
    }
}
