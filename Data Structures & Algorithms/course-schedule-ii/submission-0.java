class Solution {

    HashMap<Integer, List<Integer>> premap = new HashMap<>();

    // Nodes in current DFS path (for cycle detection)
    HashSet<Integer> visiting = new HashSet<>();

    // Nodes already fully processed
    HashSet<Integer> visited = new HashSet<>();

    int ind = 0;

    public boolean dfs(int node, int[] output) {

        if (visiting.contains(node)) {
            return false; // cycle
        }

        if (visited.contains(node)) {
            return true; // already processed
        }

        visiting.add(node);

        for (int pre : premap.get(node)) {
            if (!dfs(pre, output)) {
                return false;
            }
        }

        visiting.remove(node);
        visited.add(node);

        output[ind++] = node;

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            premap.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            premap.get(pre[0]).add(pre[1]);
        }

        int[] output = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, output)) {
                return new int[]{};
            }
        }

        return output;
    }
}