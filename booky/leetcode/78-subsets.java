class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    
    public List<List<Integer>> subsets(int[] nums) {
        // Arrays.sort(nums); 
        // backtracking per size (1->N)
        for(int i = 0; i <= nums.length; i++){
            helper(new ArrayList<>(), nums, 0, i); 
        }
        return res; 
    }
    public void helper(List<Integer> curr, int[] nums, int idx, int len){
        if(curr.size() == len){
            res.add(new ArrayList<>(curr)); 
            return; 
        }
        
        for(int i = idx; i < nums.length; i++){
            // if(curr.size() > 0 && nums[i] <= curr.get(curr.size() - 1)){
            //     continue; 
            // }
            curr.add(nums[i]); 
            // helper(curr, nums, idx+1, len); 
            helper(curr, nums, i + 1, len); 
            curr.remove(curr.size() - 1); 
        }
    }
}