class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // pre[i] = ai, bi: bi must be taken before ai, bi is prerequisite of ai
        // if has loop: false; or true        
        if(prerequisites.length == 0 || prerequisites[0].length == 0){
            return true; 
        }
        // build graph by adjacent list
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for(int i = 0; i < prerequisites.length; i++){
            List<Integer> list; 
            if(map.containsKey(prerequisites[i][1])){
                list = map.get(prerequisites[i][1]); 
            } else {
                list = new ArrayList<>(); 
            }
            
            list.add(prerequisites[i][0]); 
            map.put(prerequisites[i][1], list); 

        }
        
        boolean[] checked = new boolean[numCourses]; 
        boolean[] inPath = new boolean[numCourses]; 
        // traverse the graph node by node
        for(int i = 0; i < numCourses; i++){

            if(!map.containsKey(i)){
                checked[i] = true; 
                continue; 
            }
            if(isCyclic(i, map, checked, inPath)){
                return false; 
            }
            // checked[i] = true; 
        }
        return true; 
    }
    
    public boolean isCyclic(int i, Map<Integer, List<Integer>> map, boolean[] checked, boolean[] inPath){
        // System.out.printf("i: " + i + "\n"); 

        if(checked[i] || !map.containsKey(i)){
            return false; 
        }
        if(inPath[i]){
            return true; 
        }
        boolean res = true; 
        
        inPath[i] = true; 
        if(map.containsKey(i)){
            // List<Integer> currList = map.get(i); 
            // System.out.printf(currList + "\n"); 
            for(int j: map.get(i)){
                // // int currNode = currList.get(j); 
                // if(checked[j]){
                //     res = false; 
                // } // DON'T CHECK, just let it go with backtraking. 


                res = isCyclic(j, map, checked, inPath); 
                if( res ){
                    break; 
                } 
                // else{
                //     return false; 
                // }
                inPath[i] = false; 
                checked[j] = true; // DON'T FORGET THIS STEP 
            }
        }
        return res; 
    }
    
    
}

// dfs is better. 因为如果之前visit过的 （checked nodes），可以跳过-剪枝。
// backtracking则要从当前的node一个一个往前检查。
// 1->2->3->4->5

