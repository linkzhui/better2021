class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2 ){
            return s.length();  
        }
        
        Map<Character, Integer> map = new HashMap<>(); 
        int i = 0, j = 0, res = 0, tot = 0; 
        
        while(i <= j && i < s.length() && j < s.length()){
            char r = s.charAt(j); 
            if(map.getOrDefault(r, 0) == 0){
                tot++; 
            }
            map.put(r, map.getOrDefault(r, 0) + 1);

            // delete dup on left
            while(tot < j - i + 1 && i <= j && i < s.length() && j < s.length()){
                // res = Math.max(res, j - i + 1); 
                char l = s.charAt(i++); 
                // System.out.printf("1 - i: %d, j: %d, tot: %d, res: %d\n", i, j, tot, res); 
                map.put(l, map.get(l) - 1); 
                if(map.get(l) == 0){
                     tot--; 
                } 
            }
            
            res = Math.max(res, j - i + 1); 
            // System.out.printf("2 - i: %d, j: %d, tot: %d, res: %d\n", i, j, tot, res); 

            j++; 
            // char ch = s.charAt
        }
        
        return res; 
    }
}


// 1. 用sliding window则不需要记录每个元素所有位置
// 2. map.size() != total distinct   !!!! 用set才可以，因为即使value=0，key也还存在！！！
// 3. 因此用arr index表示char，value表示window内出现与否/次数最合适。
// 4. 如果一定要用map存，需要另用一变量存当前window内distinct元素数量，每次自增/自减还需要检查原/新value，判断该元素是否原本就在window内/从window删去。繁琐。