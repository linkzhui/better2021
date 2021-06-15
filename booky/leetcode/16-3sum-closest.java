class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0, diff = Integer.MAX_VALUE; 
        Arrays.sort(nums); 
        for(int i = 0; i < nums.length; i++){
            int l = i + 1, r = nums.length - 1 ; 
            while(l < r && 
                  l < nums.length && 
                  r > 0){
                if(diff > Math.abs(nums[i] + nums[l] + nums[r] - target)){
                    sum = nums[i] + nums[l] + nums[r]; 
                    // System.out.printf("sum: %d", sum); 
                    diff = Math.abs(nums[i] + nums[l] + nums[r] - target);
                }
                if(nums[i] + nums[l] + nums[r] < target || 
                   l == i ){
                    l++;
                }
                else if(nums[i] + nums[l] + nums[r] > target || 
                        r == i){
                    r--;
                }
                
                else{
                    l++; 
                }
            }
        }
        return sum;
    }
}

