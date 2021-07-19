class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> permute(int[] nums) {
        helper(new ArrayList<Integer>(), new boolean[nums.length], nums); 
        return res; 
    }
    public void helper(List<Integer> curr, boolean[] used, int[] nums){
        if(curr.size() == nums.length){
            res.add(new ArrayList<Integer>(curr)); 
            // avoid deep copy
        }
        
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            curr.add(nums[i]); 
            used[i] = true; 
            helper(curr, used, nums); 
            curr.remove(curr.size() - 1); 
            used[i] = false; 
        }
    }
    
}
// 本题nums长度较小，可以used数组记录是否已经取用，决定是否append到string尾部