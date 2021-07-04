class Solution {
    int LAND = 1; 
    int WATER = 0; 
    int tot = 0; 

    int[] x = new int[]{1, -1, 0, 0}; 
    int[] y = new int[]{0, 0, 1, -1}; 
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0; 
        }
        int res = 0; 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == LAND){
                    tot = 0; 
                    // grid[i][j] = WATER; 
                    bfs(grid, i, j); 
                }
                res = Math.max(res, tot); 

            }
        }
        return res; 
    }
    
    public void bfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == WATER){
            return ; 
        }
        grid[i][j] = WATER; 
        tot++; 
        // System.out.printf("Total: %d\n", tot); 
        

        for(int k = 0; k < 4; k++){
            bfs(grid,  i + x[k], j + y[k]); 
        }
    }
}

// 1. bfs 的入口、出口
// 2. update res