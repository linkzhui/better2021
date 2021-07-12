class Pair{
    int r; 
    int c; 
    public  Pair(int x, int y){
        this.r = x; 
        this.c = y; 
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return -1; 
        }

        int ROTTEN = 2; 
        int FRESH = 1; 
        int EMPTY = 0; 
        int tot = 0; 
        int res = -1; 
        boolean hasRotten = false; 

        int[] x = new int[]{0, 0, 1, -1}; 
        int[] y = new int[]{1, -1, 0, 0}; 
        
        Queue<Pair> queue = new LinkedList<>(); 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == ROTTEN){
                    queue.add(new Pair(i, j)); 
                    hasRotten = true; 
                }
                else if(grid[i][j] == FRESH){
                    tot++; 
                }
            }
        }
        
        while(!queue.isEmpty()){
            // System.out.printf("In WHILE - tot: %d; res: %d\n", tot, res); 
            res++; 
            int levelSize = queue.size(); 
            while(levelSize-- > 0){
                Pair curr = queue.poll(); 
                // bfs(grid, queue, curr.r, curr.c); 
                for(int k = 0; k < 4; k++){
                    int i = curr.r + x[k]; 
                    int j = curr.c + y[k]; 
                    if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == EMPTY){
                        continue; 
                    }
                    if(grid[i][j] == ROTTEN){
                        grid[i][j] = EMPTY;             
                    }
                    if(grid[i][j] == FRESH){
                        tot--; 
                        // System.out.printf("tot: %d\n", tot); 
                        grid[i][j] = EMPTY; 
                        queue.add(new Pair(i, j)); 
                    }
        
                }
            }
        }
        // System.out.printf("tot: %d, goodflag: %b\n", tot, goodflag); 

        if(tot > 0){
            return -1; 
        }
        if(!hasRotten){
            return 0; 
        }
        return res; 
    }
}

// Corner cases: 
// [[0]] : 0
// [[1]] : -1

// must use iterative