class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses,
        int[][] prerequisites,
        int[][] queries
    ) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            dfs(i, i, adj, isPrerequisite);
        }

        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {
            result.add(isPrerequisite[query[0]][query[1]]);
        }

        return result;
    }

    private void dfs(
        int start,
        int node,
        List<List<Integer>> adj,
        boolean[][] isPrerequisite
    ) {
        for (int nei : adj.get(node)) {

            if (isPrerequisite[start][nei]) {
                continue;
            }

            isPrerequisite[start][nei] = true;

            dfs(start, nei, adj, isPrerequisite);
        }
    }
}