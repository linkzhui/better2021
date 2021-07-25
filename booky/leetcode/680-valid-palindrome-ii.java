class Solution {
    public boolean validPalindrome(String s) {
        if(s.length() < 2) {
            return true; 
        }
        int l = 0, r = s.length() - 1; 
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++; 
                r--; 
                continue; 
            } 
            boolean t1 = false, t2 = false; 
            if(l + 1 <= r) {
                t1 = isPalindrome(s, l + 1, r);
            }
            if(r - 1 >= 0) {
                t2 = isPalindrome(s, l, r - 1); 
            }
            return t1 || t2; 
        }
        return true; 
    }
    
    public boolean isPalindrome(String s, int l, int r){
        // int l = 0, r = s.length() - 1; 
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false; 
            }
            l++; 
            r--; 
        }
        return true; 
    }
}