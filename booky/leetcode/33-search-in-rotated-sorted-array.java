class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0; 
        while(lo + 1 < hi){
            mid = (hi - lo) / 2 + lo; 
            if(nums[mid] == target){
                return mid; 
            }
            if( (target >= nums[0] && ( target < nums[mid] || 
                                       nums[mid] < nums[0]) ) || 
                (nums[mid] < nums[0] &&  target < nums[mid] ) ) {
                hi = mid; 
            } else {
                lo = mid; 
            }
            // System.out.printf("lo: %d; hi: %d; mid: %d\n", lo, hi, mid); 
        }
        if(nums[lo] == target){
            return lo;
        } 
        if(nums[hi] == target){
            return hi; 
        }
        return -1; 
    }
}

// 不光target有两个可能区间，nums[mid]也有两个可能区间，if条件要仔细检查edge case