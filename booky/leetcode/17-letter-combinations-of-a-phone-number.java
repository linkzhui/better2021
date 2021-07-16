class Solution {
    List<String> res = new ArrayList<>(); 
    Map<Character, String> map = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");    
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return res; 
        }
        
        helper(digits, new StringBuilder(), 0); 

        return res; 
    }
    public void helper(String digits, StringBuilder path, int index){
        if( digits.length() == path.length() // 
          ){
            res.add(path.toString()); 
        }
        if(index >= digits.length()){
            return; 
        }
        // System.out.print("index: " + index); 
        char[] chars = map.get(digits.charAt(index)).toCharArray(); 
        
        for(char ch: chars){
            path.append(ch);
            // System.out.print("index: " + index + 
                             // "; path: " + path.toString() + "\n"); 
            helper(digits, path, index+1); 
            path.deleteCharAt(path.length() - 1); 
        }
    }
}
// map define
// helper's exit; 