class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0]; //global max
        int temSum = nums[0]; //temp sum
        for (int i = 1; i < nums.length; i++) {
            if (temSum + nums[i] > nums[i]) {
                temSum += nums[i];
            } else {
                temSum = nums[i];
            }
            result = Math.max(result, temSum);
        }
        return result;
    }
}
