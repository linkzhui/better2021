class Solution {
    public int minKnightMoves(int x, int y) {
        int res = 0; 

        int[] deltax = {2, 2, 1, 1, -2, -2, -1, -1}; 
        int[] deltay = {1, -1, 2, -2, 1, -1, 2, -2}; 
        
        boolean[][] visited = new boolean[610][610]; 
        Queue<int[]> queue = new LinkedList<>(); 
        
        queue.add(new int[]{0, 0}); 
        // visited[0 + 300][0 + 300] = true; 
        while(!queue.isEmpty()){
            int levelsize = queue.size(); 

            while(levelsize-- > 0){
                int[] curr = queue.poll(); 
                int r = curr[0]; // 已经+300
                int c = curr[1]; 
                if (r == x && c == y){ 
                    return res;
                }
                for(int i = 0; i < 8; i++){


                    // if(r + deltax[i] < 0 ||
                    //    c + deltay[i]< 0 ||
                    //    r + deltax[i]> 600 || 
                    //    c + deltay[i] >600){
                    //     continue; 
                    // }
                    if( !visited[r + deltax[i] + 302][c + deltay[i] + 302]){
                        visited[r + deltax[i] + 302][c + deltay[i] + 302] = true; 
                        queue.add(new int[]{r + deltax[i], c + deltay[i]}); 
                    } 
                }
            }
            res ++; 

        }
        return res; 
        
    }
}

// 1. 棋盘有复数，所以坐标x, y是 -300～+300；又因为delta范围是-2～+2，所以offset是+302才能保证在合理坐标范围内
// 2. 需要visited数组在遍历的时候确保不要死循环
// 3. 用while实现bfs （联想二叉树的bfs）,while + for(i: 0->level size)

