class Solution {
    public String addStrings(String num1, String num2) {
        char[] s1 = reverseString(num1).toCharArray();
        char[] s2 = reverseString(num2).toCharArray(); 
        int[] res = new int[Math.max(s1.length, s2.length) + 1];
        int carry = 0, pos = 0; 
        // for(int i = 0; i < s1.size() && i < s2.size(); i++)
        while(pos < s1.length && pos < s2.length) {
            int n1 = s1[pos] - '0'; 
            int n2 = s2[pos] - '0'; 
            res[pos] = (carry + n1 + n2) % 10; 
            carry = (carry + n1 + n2) / 10; 
            // System.out.printf("n1: %d; n2: %d; res: %d; carry: %d\n", n1, n2, res[pos], carry); 
            pos++; 
        }
        // i = s1.size() - 1 OR i = s2.size() - 1

        // don't forget to -'0'
        while(pos < s1.length){
            res[pos] = (carry + s1[pos] - '0') % 10; 
            carry = (carry + s1[pos] - '0') / 10; 
            // System.out.printf("pos: %d; res: %d; carry: %d\n", pos, res[pos], carry); 
            pos++; 
        }
        
        while(pos < s2.length){
            res[pos] = (carry + s2[pos] - '0') % 10; 
            carry = (carry + s2[pos] - '0') / 10; 
            pos++; 
        }
        
        if(carry > 0){
            res[pos] = carry; 
        } else{
            pos--; 
        }
        // ^^^^^
         
        StringBuilder sb = new StringBuilder(); 
        while(pos >= 0){
            sb.append((char)(res[pos] + '0')); 
            pos--; 
        }
        
        return sb.toString(); 
    }
    
    public String reverseString(String s){
        StringBuilder sb = new StringBuilder(); 
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i)); 
        }
        return sb.toString(); 
    }
}
