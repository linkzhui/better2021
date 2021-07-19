class Solution {
    // boolean res; 
    public boolean exist(char[][] board, String word) {
        int M = board.length; 
        int N = board[0].length; 
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == word.charAt(0)){
                    // return helper(board, word, i, j, 0);
                    if(helper(board, word, i, j, 0)){
                        // return true as long as see res=true in the middle, don't return helper()'s result directly (the last pass of traversal)
                        return true; 
                    }
                }
            }
        }
        return false; 
    }
    
    public boolean helper(char[][] board, String word, int r, int c, int index){
        if(index >= word.length()){
            return true; 
        }
        if(r < 0 || r >= board.length || 
           c < 0 || c >= board[0].length){
            return false; 
        }
        if(board[r][c] != word.charAt(index)){
            return false; 
        }
        board[r][c] = '#'; 
        int[] x = new int[]{0, 0, 1, -1}; 
        int[] y = new int[]{1, -1, 0, 0}; 
        boolean res = false; 
        for(int i = 0; i < 4; i++){
            res = helper(board, word, r + x[i], c + y[i], index + 1); 
            // return true as long as see res=true in the middle
            if(res){
                return true; 
            }
        }
        board[r][c] = word.charAt(index); 
        return res; 
    }
}
// don't forget to mark as visited ('#')
// return true as long as see res=true in the middle
