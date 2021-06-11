class Freq{
    char ch; 
    int f; 
    public Freq(char ch, int f){
        this.ch = ch; 
        this.f = f; 
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxfreq = 0; 
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i); 
            map.put(curr, map.getOrDefault(curr, 0) + 1); 
            maxfreq = Math.max(maxfreq, map.get(curr)); 
        }
        if(s.length() - maxfreq < maxfreq - 1){
            return ""; 
        }
        
        PriorityQueue<Freq> pq = new PriorityQueue<>((a, b) -> b.f - a.f); 
        for(Map.Entry entry: map.entrySet()){
            pq.add(new Freq((char)entry.getKey(), 
                            (int)entry.getValue()) ); 
        }
        
        StringBuilder sb = new StringBuilder(""); 
        Freq[] arr = new Freq[map.size()]; 
        int index = 0;
        while(!pq.isEmpty()){
            Freq a = pq.poll();             
            sb.append(a.ch);
            if(pq.isEmpty()){
                if(--a.f > 0){
                    pq.add(a); 
                }
                break; 
            }
            Freq b = pq.poll(); 
            sb.append(b.ch); 
            if(--a.f > 0){
                pq.add(a); 
            }
            
            if(--b.f > 0){
                pq.add(b); 
            }
            
        }
        return sb.toString(); 
    }
}

// 观察例子，如果maxfreq > 1/2 length，一定不成立。
// 形成<char, freq> pq后，需要两两取出和存回去，以实现相邻char不同。