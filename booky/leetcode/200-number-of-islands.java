class Solution {
    char WATER = '0'; 
    char LAND = '1'; 
    int res = 0; 
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0 ; 
        }
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == LAND){
                    res ++; 
                    helper(grid, r, c);
                }
            }
        }
        return res; 
    }
    
    public void helper(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
           || grid[r][c] == WATER){
            return; 
        }        
        grid[r][c] = WATER; // update; 
        int[] x = {-1, 1, 0, 0}; 
        int[] y = {0, 0, 1, -1}; 
        for(int i = 0; i < 4; i++){
            // r += x[i]; 
            // c += y[i]; 
            // helper(grid, r, c);
            helper(grid, r + x[i], c + y[i]); 
            
        }
    }
}



// 递归函数helper(grid, r + x[i], c + y[i]). 而不能改变r，c值，因为在下一轮for loop还要用到原来的r, c

// instead of pre-calculate r, c. 