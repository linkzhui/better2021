class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length; 
        if(len == 1){
            return 0; 
        }
        if(nums[0] > nums[1]){
            return 0; 
        }
        if(nums[len - 1] > nums[len - 2]){
            return len - 1; 
        }
        
        // up first, down last
        int lo = 0, hi = len - 1, mid = 0; 
        while(lo + 1 < hi){
            mid = (hi - lo) / 2 + lo; 
            if( (mid - 1 >= 0 && nums[mid] >= nums[mid - 1]) || 
              (mid + 1 < len && nums[mid + 1] >= nums[mid]) ){ // INC
                lo = mid; 
            } else { // DESC
                hi = mid; 
            }
            
            // else if ( (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) ||
            //           mid + 1 < len && nums[mid + 1] < nums[mid - 1] ){
            //     hi = mid; 
            // }
        }

        if(nums[lo] > nums[hi]){
            return lo; 
        } 
        return hi; 
    }
}
// simplify the cases to only check: 
// [INC first, DESC last]