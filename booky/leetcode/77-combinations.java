class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> combine(int n, int k) {
        helper(new boolean[n + 1], new ArrayList<Integer>(), n, k, 1); 
        return res; 
    }
    public void helper(boolean[] used, List<Integer> curr, int n, int k, int idx){
        if(curr.size() == k){
            res.add(new ArrayList<>(curr)); 
            return; 
        }
        
        for(int i = idx; i <= n; i++){
            // if(used[i] || 
            if( (curr.size() > 0 && i <= curr.get(curr.size() - 1)) ){
                continue;
            }
            // used[i] = true; 
            curr.add(i); 
            helper(used, curr, n, k, idx + 1); 
            // used[i] = false; 
            curr.remove(curr.size() - 1); 
        }
    }
}

// 1. used[] array
// 2. skip when curr num == curr's last num