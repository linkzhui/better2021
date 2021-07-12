class Solution {
    int res; 
    public int findCircleNum(int[][] isConnected) {
        res = 0; 
        if(isConnected.length < 1){
            return res;  
        }   
        Queue<Integer> queue = new LinkedList<>(); 
        boolean[] visited = new boolean[isConnected.length]; 
        for(int i = 0; i < isConnected.length; i++){
            if(visited[i]){
               continue; 
            }
            visited[i] = true; 
            res++; 
            // start BFS from node i: 
            queue.add(i); 
            while(!queue.isEmpty()){
                int curr = queue.poll(); 
            // DONT FORGET
                visited[curr] = true; 
                for(int j = 0; j < isConnected.length; j++){
                    if(i == j){
                        continue; 
                    }
                    if(isConnected[curr][j] == 1 && !visited[j]){
                        queue.add(j); 
                    }
                }
            }
        }
        return res; 
    }
}

