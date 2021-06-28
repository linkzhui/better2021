class Solution {
    public int[] searchRange(int[] nums, int target) { 
        if(nums.length == 0 || nums[nums.length - 1] < target || nums[0] > target){
            return new int[]{-1, -1}; 
        }
        int lo = 0, hi = nums.length - 1, mid = 0; 
        int st = 0, ed = hi; 
        
        while(lo + 1 < hi){
            mid = (hi - lo) / 2 + lo; 
            if(nums[mid] >= target){
                hi = mid; 
            }
            else {
                lo = mid; 
            }
        }
        if(nums[lo] == target){
            st = lo; 
        } else if (nums[hi] == target) {
            st = hi;
        } else 
            return new int[]{-1, -1}; 
        
        lo = 0; 
        hi = nums.length - 1; 
        while(lo + 1 < hi){
            mid = (hi - lo) / 2 + lo; 
            if(nums[mid] <= target){
                lo = mid; 
            }
            else {
                hi = mid; 
            }
        }
        if(nums[hi] == target){
            ed = hi;
        } else {
            ed = lo; 
        }
        return new int[]{st, ed};
    }
}

// edge case：lo、hi出了while循环后，需要判断值是否为target，决定有没有答案