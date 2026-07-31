class Solution {
    //optimal
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> premap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
         int inedge[] = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            premap.put(i, new ArrayList<>());
        }

        for(int[] node : prerequisites){
            inedge[node[1]]++;
            premap.get(node[0]).add(node[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(inedge[i] == 0){
                q.offer(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;

            for(int nei : premap.get(node)){
                inedge[nei]--;

                if(inedge[nei] == 0){
                    q.offer(nei);
                }
            }
        }
        if(cnt == numCourses){
            return true;
        }
        return false;
    }
}






// class Solution {
// Brute force
//     HashMap<Integer, List<Integer>> premap = new HashMap<>();
//     HashSet<Integer> set = new HashSet<>();

//     public boolean dfs(int n){
//         if(set.contains(n)){
//             return false;
//         }
//         if(premap.get(n).isEmpty()){
//             return true;
//         }
//         set.add(n);
//         for(int pre : premap.get(n)){
//             if(!dfs(pre)){
//                 return false;
//             }
//         }
//         set.remove(n);
//         premap.put(n, new ArrayList<>());
//         return true;
//     }

//     public boolean canFinish(int numCourses, int[][] prerequisites) {

//         for(int i = 0; i < numCourses; i++){
//             premap.put(i, new ArrayList<>());
//         }

//         for(int[] pre : prerequisites){
//             premap.get(pre[0]).add(pre[1]);
//         }

//         for(int i = 0; i < numCourses; i++){
//             if(!dfs(i)){
//                 return false;
//             }
//         }
//         return true;
//     }
// }
