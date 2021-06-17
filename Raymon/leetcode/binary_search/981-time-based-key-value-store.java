class TimeMap {

    class Data {
        int timestamp;
        String val;
        public Data (int timestamp, String value) {
            this.timestamp = timestamp;
            this.val = value;
        }
    }

    HashMap<String, List<Data>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            List<Data> list = new ArrayList<>();
            list.add(new Data(timestamp, value));
            map.put(key, list);
        } else {
            map.get(key).add(new Data(timestamp, value));
        }
        value = map.get(key).get(0).val;
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            return binarySearch(map.get(key), timestamp);
        } else {
            return "";
        }
    }

    private String binarySearch(List<Data> list, int timestamp) {
        //special case, the timstamp may less than smallest timestamp
        if (timestamp < list.get(0).timestamp) {
            return "";
        }
        int low = 0;
        int high = list.size() - 1;
        while (low < high) {
            int mid = low + (high - low) /2;
            if (list.get(mid).timestamp < timestamp) {
                if (list.get(mid + 1).timestamp > timestamp) {
                    return list.get(mid).val;
                } else {
                    low = mid + 1;
                }
            } else if (list.get(mid).timestamp > timestamp) {
                high = mid - 1;
            } else {
                return list.get(mid).val;
            }
        }
        String result = list.get(low).val;
        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
