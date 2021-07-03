class HitCounter {
    List<int[]> hit; 
    int curr;
    /** Initialize your data structure here. */
    public HitCounter() {
        hit = new ArrayList<>(); 
        curr = 0; 
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        curr++; 
        if(hit.size() > 0 && hit.get(hit.size() - 1)[0] == timestamp){
            hit.set(hit.size() - 1, new int[] {timestamp, curr}); 
        } else {
            hit.add(new int[] {timestamp, curr}); 
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (timestamp <= 300){
            return findTotal(timestamp); 
        }
        return findTotal(timestamp) - findTotal(timestamp -  300); 
    }
    
    public int findTotal(int timestamp){
        if(hit.size() == 0){
            return 0; 
        }
        int lo = 0, hi = hit.size() - 1, mid = 0; 
        while(lo + 1 < hi){
            mid = (hi - lo) / 2 + lo; 
            if(hit.get(mid)[0] == timestamp){
                return hit.get(mid)[1]; 
            }
            if(hit.get(mid)[0] >= timestamp){
                hi = mid; 
            } else{
                lo = mid; 
            }
        }
        
        if(hit.get(hi)[0] <= timestamp){
            return hit.get(hi)[1]; 
        } 
        if(hit.get(lo)[0] <= timestamp){
            return hit.get(lo)[1];  
        }
        return 0; 
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */


// 1. 同一个ts，可以hit多次；
// 2. 所以在写入数据时判断是否重复ts，重复ts的hit，要计入同一个ts 
// 3. 与前一个ts比较时，检查是否为空list
// 4. 返回total hits前，lo & hi都需要检查是否<= ts，再决定取值
