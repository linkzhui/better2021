class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> res = new ArrayList<>(); 
        int maxHeight = 0; 
        for(int i = heights.length - 1; i >= 0; i--){
            if(heights[i] > maxHeight){
                res.add(i); 
                maxHeight = heights[i]; 
                // System.out.printf("added height: %d; \n", i ); 
            }
        }
        
        int[] ans = new int[res.size()]; 
        for(int i = 0; i < res.size(); i++){
            ans[i] = res.get(res.size() - 1 - i); 
        }
        return ans; 
    }
}''