class TimeMap {
    Map<String, TreeMap<Integer,String>>m;
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        m.putIfAbsent(key, new TreeMap<>());
        m.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)) return "";

        TreeMap<Integer,String>tm = m.get(key);
        Integer nearest = tm.floorKey(timestamp);

        if(nearest == null) return "";
        return tm.get(nearest);
    }
}
