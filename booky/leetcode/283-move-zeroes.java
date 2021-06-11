class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0, q = p + 1; 
        while( p < nums.length && q < nums.length){
            // find first value == 0 
            while(p < nums.length && nums[p] != 0) {
                p++; 
            }  
            
            // find first value > 0 after p
            q = p + 1; 
            while(q < nums.length && nums[q] == 0){
                q++; 
            }
            
            if( q < nums.length){
                int tmp = nums[q]; 
                nums[q] = nums[p]; 
                nums[p] = tmp; 
            }
            p++; 
        }
        return; 
    }
}