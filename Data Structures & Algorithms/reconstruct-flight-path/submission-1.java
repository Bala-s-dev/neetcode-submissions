class Solution {
    public boolean dfs(String airport, HashMap<String, List<String>> map, List<String> ans, int len){
        if(ans.size() == len){
            return true;
        }
        if(!map.containsKey(airport)){
            return false;
        }

        List<String> des = map.get(airport);

        for(int i = 0; i < des.size(); i++){
            String nextStop = des.get(i);
            ans.add(nextStop);
            des.remove(i);

            if(dfs(nextStop, map, ans, len)){
                return true;
            }

            ans.remove(ans.size() - 1);
            des.add(i, nextStop);
        }
        return false;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(List<String> l : tickets){
            if(!map.containsKey(l.get(0))){
                map.put(l.get(0), new ArrayList<>());
            }
        }

        //sort
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));

        for(List<String> l : tickets){
            String from = l.get(0);
            String to = l.get(1);
            map.get(from).add(to);
        }

        List<String> ans = new ArrayList<>();
        ans.add("JFK");
        int len = tickets.size() + 1;

        dfs("JFK", map, ans, len);

        return ans;
            
    }
}
