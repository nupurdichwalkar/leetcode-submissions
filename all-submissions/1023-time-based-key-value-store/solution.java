class TimeMap {

    Map<String, TreeMap<Integer, String>> myMap;

    public TimeMap() {
        this.myMap = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!myMap.containsKey(key)) {
            myMap.put(key, new TreeMap<>(Collections.reverseOrder()));
        }
        myMap.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!myMap.containsKey(key)) return "";
        TreeMap<Integer, String> treeMap = myMap.get(key);
        if(treeMap == null) return "";
        for(int timestamp_prev: treeMap.keySet()){
            if(timestamp_prev <= timestamp) {
                return treeMap.get(timestamp_prev);
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
