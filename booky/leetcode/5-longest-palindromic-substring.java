class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s; 
        }
        String res = ""; 
        int cnt = 0; 
        for(int i = 0; i < s.length(); i++){
            String str = expandCheck(s, i); 
            if (cnt < str.length()){
                res = str; 
                cnt = str.length(); 
            }
        }
        return res; 
    }
    
    public String expandCheck(String s, int idx){
        String res = "";
        StringBuilder sb = new StringBuilder(); 
        
        for(int i = 0; idx - i >= 0 && idx + i < s.length(); i++){
            if(s.charAt(idx - i) != s.charAt(idx + i)){
                break;
            }
            if(i > 0)
                sb.insert(0, s.charAt(idx - i) ); 
            sb.append(s.charAt(idx + i)); 
        }
        if (res.length() < sb.length()){
            res = sb.toString(); 
        }
        
        sb = new StringBuilder(); 

        for(int i = 0; idx - i >= 0 && idx + 1 + i < s.length(); i++){
            if(s.charAt(idx - i) != s.charAt(idx + 1 + i)){
                break;
            }
            sb.insert(0, s.charAt(idx - i) ); 
            sb.append(s.charAt(idx + 1 + i)); 
                
        }
        if (res.length() < sb.length()){
            res = sb.toString(); 
        }
        
        return res; 
    }
}

// Many edge cases.
// 1. break when seeing 2 chars not match 
// 2. sb needs to be reset before checking another palindrome
// 3. when s.len = 1