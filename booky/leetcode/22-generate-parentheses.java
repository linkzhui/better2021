class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        helper(n, res, 0, 0, new StringBuilder()); 
        return res; 
    }
    
    public void helper(int n, List<String> res, int open, int close, StringBuilder sb){
        if( sb.length() == 2*n ){
            res.add(sb.toString()); 
            return; 
        }
        // char[] chars = new char[]{'(', ')'}; 
        

        if(close < n && close < open) {
            sb.append(')'); 
            helper(n, res, open, close+1, sb); 
            sb.deleteCharAt(sb.length() - 1); 
        } 
        
        if(open < n) {
            sb.append("("); 
            helper(n, res, open+1, close, sb); 
            sb.deleteCharAt(sb.length() - 1); }
                
        }
    }

// close, open both need cnt
// can send integer change directly as helper() params