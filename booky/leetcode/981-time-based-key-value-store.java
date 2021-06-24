class Pair {
    int ts; 
    String val;
    public Pair(int ts, String val){
        this.ts = ts;
        this.val = val;
    }
}

class TimeMap {
    Map<String, List<Pair>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<String, List<Pair>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<Pair>()); 
        }
           map.get(key).add( new Pair(timestamp, value) );
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key) || 
           timestamp < map.get(key).get(0).ts){
            return ""; 
        }
        List<Pair> list = map.get(key); 
        int low = 0, high = list.size() - 1, mid = 0;
        while(low < high - 1){
            mid = low + (high - low) / 2; 
            if(list.get(mid).ts > timestamp) {
                high = mid;
            } else if (list.get(mid).ts < timestamp){
                low = mid;
            } else{
                return list.get(mid).val; 
            }
        }
        if(list.get(high).ts > timestamp){
            return list.get(low).val; 
        }
        return list.get(high).val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

// 易错corner case：
// getter ts比最早的setter所取ts还小，返回“”
// timestamp < map.get(key).get(0).ts