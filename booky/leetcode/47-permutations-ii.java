class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
        }
        helper(new ArrayList<Integer>(), map, nums ); 
        return res; 
    }
    public void helper(List<Integer> curr, Map<Integer, Integer> map, int[] nums){
        if(curr.size() == nums.length){
            res.add(new ArrayList<Integer>(curr)); 
            // avoid deep copy
            return; 
        }
        for(int num: map.keySet()){
            // int num = entry.key(); 
            int cnt = map.get(num); 
            if(cnt == 0){
                continue; 
            }
            curr.add(num); 
            map.put(num, cnt - 1);
            helper(curr, map, nums); 
            
            curr.remove(curr.size() - 1); 
            map.put(num, cnt); 
        }
    }
}