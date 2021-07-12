class Solution {
    int[] dx = new int[]{0, 0, -1, 1}; 
    int[] dy = new int[]{-1, 1, 0, 0}; 
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights.length == 0 || heights[0].length == 0){
            return res; 
        }
        int M = heights.length; 
        int N = heights[0].length; 
        boolean[][] pacific_reacheable = new boolean[M][N]; 
        boolean[][] atlantic_reacheable = new boolean[M][N]; 
        
        for(int i = 0; i < M; i++){
            pacific_reacheable[i][0] = true; 
            dfs(pacific_reacheable, heights, i, 0); 
            
            atlantic_reacheable[i][N-1] = true; 
            dfs(atlantic_reacheable, heights, i, N-1); 
        }
        for(int i = 0; i < N; i++){
            pacific_reacheable[0][i] = true; 
            dfs(pacific_reacheable, heights, 0, i); 
            
            atlantic_reacheable[M-1][i] = true; 
            dfs(atlantic_reacheable, heights, M-1, i); 
        }
        
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(pacific_reacheable[i][j] && atlantic_reacheable[i][j]){
                    res.add(new ArrayList<Integer>( Arrays.asList(i, j) ) ); 
                }
            }
        }
        
        return res; 
    }
    
    public void dfs(boolean[][] reacheable, int[][] heights, int i, int j){
        if(!inbound(heights, i, j) || !reacheable[i][j]){
            return; 
        }
        // reacheable[i][j] = true; 
        for(int k = 0; k < 4; k++){
            int r = i + dx[k]; 
            int c = j + dy[k]; 
            if(inbound(heights, r, c) && heights[r][c] >= heights[i][j] && !reacheable[r][c]){
                //remember to skip cells already reacheable (avoid STACK OVERFLOW)
                reacheable[r][c] = true; 
                dfs(reacheable, heights, r, c); 
            }
        }
    }
    
    public boolean inbound(int[][] height, int i, int j){
        if (i < 0 || j < 0 || i >= height.length || j >= height[0].length){
            return false; 
        }
        return true; 
    }
}

// 易错点：不能只考虑四个方向直接去flow，会遗漏掉曲折的路线。
// 1. for i: 1->M (rol#) at every [i, 0], [i, N-1], dfs check neighbors' height > curr border cell, update pacific_reacheable[][]
// 2. for i: 1->N (col#) at every [0, i], [M-1, i], dfs check nei..... update atlantic_reacheable[][]
// 3. for i: 0->M, j: 0->N, check each cell and collect those have true value for both reachable flag. 