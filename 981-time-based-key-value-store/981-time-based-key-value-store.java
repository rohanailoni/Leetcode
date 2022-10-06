class TimeMap {
    HashMap<String,String>map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        String s=key+"_"+Integer.toString(timestamp);
        map.put(s,value);
    }
    
    public String get(String key, int timestamp) {
        for(int i=timestamp;i>=1;i--){
            String s=key+"_"+Integer.toString(i);
            if(map.containsKey(s)){
                return map.get(s);
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