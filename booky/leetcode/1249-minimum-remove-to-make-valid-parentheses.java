class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s.length() == 0){
            return s; 
        }
        StringBuilder sb = new StringBuilder(s); 
        int pos = 0, cntL = 0, cntR = 0; 
        while(pos < sb.length()){
            if(cntR >= cntL && 
               sb.charAt(pos) == ')'){
                sb.deleteCharAt(pos);
            } 
            
            else{
                if(sb.charAt(pos) == '('){
                    cntL++; 
                } else if (sb.charAt(pos) == ')'){
                    cntR++; 
                }
                pos++;
            }
        }
        // System.out.printf("string: %s; cntL: %d; cntR: %d\n", sb, cntL, cntR); 
        
        // Remember second pass when removing '(': needs to start from tail to head
        pos = sb.length() - 1; 
        while(pos >= 0 && 
              cntL > cntR){
            if(sb.charAt(pos) != '('){
                pos--;
                continue;
            }
            sb.deleteCharAt(pos--); 
            cntL--; 
        }
        
        return sb.toString(); 
    }
}

// 先列举各种例子再写代码

// 易错点：一开始想到了要two pass，分别处理')'e '('

// Remember second pass when removing '(': needs to start from tail to head
