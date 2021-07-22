class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(new ArrayList<Integer>(), candidates, 0, 0, target); 
        return res; 
    }
    public void helper(List<Integer> curr, int[] candidates, int idx, int sum, int target){
        if(sum == target){
            res.add(new ArrayList<>(curr)); 
        }
        if(sum >= target){
            return; 
        }
        for(int i = idx; i < candidates.length; i++){
            if(sum + candidates[i] > target || 
               (curr.size() > 0 && candidates[i] < curr.get(curr.size() - 1) ) ){
                // de-dup!!
                continue;
            }
            sum += candidates[i]; 
            curr.add(candidates[i]); 
            helper(curr, candidates, idx, sum, target); 
            sum -= candidates[i]; 
            curr.remove(curr.size() - 1); 
        }
    }
}