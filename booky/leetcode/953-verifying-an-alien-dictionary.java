class Solution {
    Map<Character, Integer> map = new HashMap<>(); 
    public boolean isAlienSorted(String[] words, String order) {
        int pos = 0; 
        while(pos < order.length()){
            map.put(order.charAt(pos), pos);
            pos++; 
        }
        
        pos = 1; 
        while(pos < words.length) {
            if (!compareTwoString(words[pos-1], words[pos])){
                return false; 
            }
            pos++; 
        }
        
        return true; 
    }
    
    public boolean compareTwoString(String s1, String s2){
        int p1 = 0, p2 = 0; 
        while(p1 < s1.length() && 
              p2 < s2.length()){
            char ch1 = s1.charAt(p1++);
            char ch2 =  s2.charAt(p2++); 
            if(ch1 == ch2){
                continue;
            }
            if(map.get(ch1) > map.get(ch2)){
                return false; 
            } else {
                return true; 
            }
        }
        
        if(p1 == s1.length() && p2 < s2.length()){
            return true; 
        }
        if(p2 == s2.length() && p1 < s1.length()){
            return false; 
        }
        return true; 
    }
}

// map + compare func