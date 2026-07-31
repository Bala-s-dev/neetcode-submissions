class Solution {
    HashMap<Integer, List<Integer>> premap = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();

    public boolean dfs(int n){
        if(set.contains(n)){
            return false;
        }
        if(premap.get(n).isEmpty()){
            return true;
        }
        set.add(n);
        for(int pre : premap.get(n)){
            if(!dfs(pre)){
                return false;
            }
        }
        set.remove(n);
        // premap.put(n, new ArrayList<>());
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++){
            premap.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            premap.get(pre[0]).add(pre[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }
}
