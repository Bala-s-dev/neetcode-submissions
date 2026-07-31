class TimeMap {
    private Map<String, Map<Integer, List<String>>> store;
    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            store.put(key, new HashMap<>());
        }
        if(!store.get(key).containsKey(timestamp)){
            store.get(key).put(timestamp, new ArrayList<>());
        }
        store.get(key).get(timestamp).add(value);
    }
    
    public String get(String key, int timestamp) {
        if(!store.containsKey(key)){
            return "";
        }
        int time = 0;

        for(int t : store.get(key).keySet()){
            if(t <= timestamp){
                time = Math.max(time, t);
            }
        }

        if(time == 0){
            return "";
        }

        int last = store.get(key).get(time).size() - 1;
        return store.get(key).get(time).get(last);
    }
}
